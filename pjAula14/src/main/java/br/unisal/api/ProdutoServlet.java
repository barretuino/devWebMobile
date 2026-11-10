package br.unisal.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.unisal.dao.ProdutoDAO;
import br.unisal.model.Produto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/produtos")
public class ProdutoServlet extends HttpServlet {

    private ProdutoDAO produtoDAO;
    private ObjectMapper objectMapper;

    @Override
    public void init() throws ServletException {
        super.init();
        produtoDAO = new ProdutoDAO();
        objectMapper = new ObjectMapper(); // Instância do Jackson para conversão JSON <-> Objeto
        
        // Garante que o driver do MySQL seja carregado
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ServletException("Driver JDBC do MySQL não encontrado.", e);
        }
    }
    
 // MÉTODO DE CONSULTA (GET)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("application/json; charset=UTF-8");
        PrintWriter out = response.getWriter();
        String idParam = request.getParameter("id");

        try {
            if (idParam != null && !idParam.isEmpty()) {
                // Consulta por ID específico (Ex: /api/produtos?id=1)
                int id = Integer.parseInt(idParam);
                Produto produto = produtoDAO.buscarPorId(id);

                if (produto != null) {
                    response.setStatus(HttpServletResponse.SC_OK);
                    out.print(objectMapper.writeValueAsString(produto));
                } else {
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    out.print("{\"erro\": \"Produto com ID " + id + " não encontrado.\"}");
                }
            } else {
                // Consulta geral de todos os produtos (Ex: /api/produtos)
                List<Produto> produtos = produtoDAO.listarTodos();
                response.setStatus(HttpServletResponse.SC_OK);
                out.print(objectMapper.writeValueAsString(produtos));
            }

        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.print("{\"erro\": \"O parâmetro 'id' deve ser um número inteiro válido.\"}");
        } catch (SQLException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.print("{\"erro\": \"Erro ao acessar o banco de dados: " + e.getMessage() + "\"}");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Define o encoding e o tipo de conteúdo da resposta como JSON
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            // 1. Ler o corpo da requisição (JSON enviado pelo cliente)
            StringBuilder jsonBuffer = new StringBuilder();
            try (BufferedReader reader = request.getReader()) {
                String linha;
                while ((linha = reader.readLine()) != null) {
                    jsonBuffer.append(linha);
                }
            }

            // 2. Converter o JSON recebido para a classe Java Produto usando Jackson
            Produto produto = objectMapper.readValue(jsonBuffer.toString(), Produto.class);

            // 3. Salvar no Banco de Dados via JDBC
            Produto produtoSalvo = produtoDAO.inserir(produto);

            // 4. Retornar resposta de sucesso (Status 201 Created) e o objeto em JSON
            response.setStatus(HttpServletResponse.SC_CREATED);
            out.print(objectMapper.writeValueAsString(produtoSalvo));

        } catch (SQLException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.print("{\"erro\": \"Erro ao acessar o banco de dados: " + e.getMessage() + "\"}");
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.print("{\"erro\": \"Requisição inválida ou JSON malformado: " + e.getMessage() + "\"}");
        }
    }
}