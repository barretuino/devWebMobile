import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pjAula1.Livro;

@WebServlet("/cadLivro")
public class cadLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Livro livro;
	
    public cadLivro() {
        super();
        livro = new Livro();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("<html>");
		response.getWriter().append("<head><title>Respostas</title> </head>");
		response.getWriter().append("<body><h1>"
				+ request.getParameter("nome") + "</h1></body>");
		response.getWriter().append("</html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		livro.setTitulo(request.getParameter("nome"));
		
		System.out.println(livro.getTitulo());
		
		response.getWriter().append("Cadastro realizado com sucesso");
	}
}