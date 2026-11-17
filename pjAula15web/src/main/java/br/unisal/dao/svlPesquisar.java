package br.unisal.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import br.unisal.modelagem.Cliente;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class svlPesquisar extends HttpServlet {
	private Cliente cliente;
	private ClienteDao DAO;
	private String mensagem;  
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {

		cliente = new Cliente();
		// pega parâmetros do request
		try {
			DAO = new ClienteDao();
			cliente = DAO.selecionar(Double.parseDouble(request.getParameter("cpf")));
			mensagem = "<font color=blue>Cliente Encontrado</font>";		
		} catch (SQLException erro) {	
			mensagem = "<font color=red>Houve um erro " + 	erro + "</font>";
		}

		//acerta tipo MIME para a resposta
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();	
		out.println("<a href=javascript:window.history.go(-1)>Voltar</a>");
		out.println("<HTML>");
		out.println("<BODY>");	

		if (cliente.getCpf()!=0){
			out.println("<P>" + mensagem + "</P>");
			out.println("<P>CPF: " + request.getParameter("cpf") + "   Nome: " + cliente.getNome() + "   Sexo: " + (cliente.getSexo().equals("M")? "Masculino":"Feminino") + " </P>");
			out.println("<P>Endereço: </P>");
			out.println("<P>Rua: " + cliente.getEndRua() + "   Número: " + cliente.getEndNum() + "   Complemento: " + cliente.getEndComplemento() + " </P>");
			out.println("<P>Bairro: " + cliente.getEndBairro() + "   Cidade: " + cliente.getEndCidade() + "   UF: " + cliente.getEndUF() + " </P>");		
		}else{
			out.println("<P><font color=red>Cliente Não Encontrado</font></P>");
		}
		out.println("<P>Programação Orientada a Objetos - Paulo Barreto</P>");	
		out.println("</BODY>");
		out.println("</HTML>");
		out.close();
	}
}