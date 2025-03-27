

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class TableauBord
 */
@WebServlet("/TableauBord")
public class TableauBord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TableauBord() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
        String taille = null, poids = null, imc = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("taille")) {
                    taille = cookie.getValue();
                } else if (cookie.getName().equals("poids")) {
                    poids = cookie.getValue();
                } else if (cookie.getName().equals("imc")) {
                    imc = cookie.getValue();
                }
            }
        }

        if (taille != null && poids != null && imc != null) {
            request.setAttribute("taille", taille);
            request.setAttribute("poids", poids);
            request.setAttribute("imc", imc);
        } else {
            request.setAttribute("error", "Aucune donnée disponible.");
        }
        request.getRequestDispatcher("resultat.jsp").forward(request, response);

    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
