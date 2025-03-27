

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tp1.Imc;

import java.io.IOException;

/**
 * Servlet implementation class CMonImc2ex4
 */
@WebServlet("/CMonImc2ex4")
public class CMonImc2ex4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CMonImc2ex4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tailleStr = request.getParameter("taille");
        String poidsStr = request.getParameter("poids");

        if (tailleStr == null || tailleStr.trim().isEmpty() || poidsStr == null || poidsStr.trim().isEmpty()) {
            throw new IllegalArgumentException("Les valeurs de taille et de poids sont obligatoires.");
        }

        double taille = Double.parseDouble(tailleStr);
        double poids = Double.parseDouble(poidsStr);

        Imc imc = new Imc(taille, poids);
        HttpSession session = request.getSession();
        session.setAttribute("imc", imc);
        double resultatImc = imc.calcul();
        
        request.setAttribute("resultatImc", resultatImc);

        request.getRequestDispatcher("resultat.jsp").forward(request, response);

	}

}
