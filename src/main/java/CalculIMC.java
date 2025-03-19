

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tp1.Imc;

import java.io.IOException;

/**
 * Servlet implementation class CalculIMC
 */
@WebServlet("/CalculIMC")
public class CalculIMC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculIMC() {
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
		// TODO Auto-generated method stub
		String poidsStr = request.getParameter("poids");
        String tailleStr = request.getParameter("taille");

        double poids = 0, taille = 0;
        boolean erreur = false;

       
        
            if (poidsStr != null && tailleStr != null && !poidsStr.isEmpty() && !tailleStr.isEmpty()) {
                poids = Double.parseDouble(poidsStr.trim());
                taille = Double.parseDouble(tailleStr.trim());
            } else {
                erreur = true;
            }
      
        // Affichage du résultat ou message d'erreur
        response.getWriter().println("<html><body>");
        if (!erreur && taille > 0 && poids > 0) {
            
            Imc imc = new Imc(taille, poids);
            double resultatImc = imc.calcul();

            
            response.getWriter().println("<h2>Votre IMC est : " + String.format("%.2f", resultatImc) + "</h2>");
        } else {
            
            response.getWriter().println("<h2>Erreur : veuillez entrer des valeurs valides pour le poids et la taille.</h2>");
        }
        response.getWriter().println("</body></html>");
    
	}

}
