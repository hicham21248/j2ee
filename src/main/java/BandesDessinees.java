

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Servlet implementation class BandesDessinees
 */
@WebServlet("/BandesDessinees")
public class BandesDessinees extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<String> listeBandesDessinees;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BandesDessinees() {
        super();
        listeBandesDessinees = new ArrayList<String>();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
		 out.println("<html><head><title>Liste de nos bandes dessinées préférées</title></head><body>");
	        out.println("<h4>Liste de nos bandes dessinées préférées</h4>");
	        for(String d : listeBandesDessinees)
	            out.println("<ul><li>"+d+"</li></ul>");
	        out.println("<hr/><form method='POST' action='BandesDessinees'>");
	        out.println("Entrez un nom de bande dessinée : <input type='text' name='bd'><br/><br/>");
	        out.println("<input type='submit' name='action' value='Ajouter'>");
	        out.println("<input type='submit' name='action' value='Retirer'>");
	        out.println("</form>");
	        out.println("</body>\r\n"
	        		+ "</html>");
	        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		PrintWriter out = response.getWriter();
        String bd = request.getParameter("bd");
        boolean exist= false;
        
       if(bd != null) {
    	   for(String d : listeBandesDessinees) {if(d.equals(bd)) {
    		   exist=true;
    		   break;
    	   }
    	   }
    	   if ("Ajouter".equals(action) && !exist) {
    		   listeBandesDessinees.add(bd);
    		   out.println("<h1>la bande dessinée "+bd+" est enregistrée</h1> <hr/>");
    		   out.println("<a href='http://localhost:8080/tp1/BandesDessinees'>Retour au formulaire</a>");
    		   
           } else if ("Retirer".equals(action) && !exist) {
        	   listeBandesDessinees.remove(bd);
        	   out.println("<h1>la bande dessinée "+bd+" est supprimé</h1> <hr/>");
    		   out.println("<a href='http://localhost:8080/tp1/BandesDessinees'>Retour au formulaire</a>");
           }
           else if(exist) {
        	   out.println("<h1>la bande dessinée "+bd+" n'est pas ajouté,elle existe deja dans la liste</h1> <hr/>");
    		   out.println("<a href='http://localhost:8080/tp1/BandesDessinees'>Retour au formulaire</a>");
           }
       }
       
	}

}
