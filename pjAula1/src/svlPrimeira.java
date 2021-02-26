import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Exemplo de Servlet para Demonstração de um processo Client / Server
 * @author Paulo Barreto
 * @date 25/02/2021
 */

@WebServlet("/svlPrimeira")
public class svlPrimeira extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public svlPrimeira() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Você acessou o servidor: ").append(request.getContextPath());
		response.getWriter().append("Data Atual é " + new Date());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
