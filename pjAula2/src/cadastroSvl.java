

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pjAula2.Contato;
@WebServlet("/cadastroSvl")
public class cadastroSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	List<Contato> lista = new ArrayList<Contato>();
	
    public cadastroSvl() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Contato novo = new Contato();
		
		novo.setNome(request.getParameter("nome"));
		
		String data = request.getParameter("data");
		Date dataContato = new Date(Integer.parseInt(data.substring(0,4)),
								    Integer.parseInt(data.substring(5,7)), 
								    Integer.parseInt(data.substring(8,10)));		
		novo.setDataContato(dataContato);
		novo.setEmail(request.getParameter("email"));
		novo.setMensagem(request.getParameter("mensagem"));
		novo.setTelefone(request.getParameter("telefone"));
		
		lista.add(novo);
		
		for(Contato c : lista) {
			response.getWriter().append("<br>Contato " + c.getNome() + " Email "  + c.getEmail() );
		}
		
	}
}
