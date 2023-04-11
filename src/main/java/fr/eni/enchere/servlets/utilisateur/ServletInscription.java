package fr.eni.enchere.servlets.utilisateur;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bo.UtilisateurBO;
import fr.eni.enchere.bll.UtilisateurManager;


/**
 * Servlet implementation class ServletInscription
 */
@WebServlet("/ServletInscription")
public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager utilisateur = new UtilisateurManager();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInscription() {
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
//		 UtilisateurBO res = null;
		 Map userMap = request.getParameterMap();
	     Set s = userMap.entrySet();
	     Iterator it = s.iterator();
	     String[] user = new String[10];
	     int index = 0;

	     while(it.hasNext()){
            Map.Entry<String,String[]> entry = (Map.Entry<String,String[]>)it.next();
            String key = entry.getKey();
            String[] value = entry.getValue();
            user[index] = value[0];
//            System.out.println(user[index]);
//            System.out.println("Key is "+key+"value: "+value[0]+"<br>");
            index++;
        }
	     // TODO ajouter a la page jsp la vérif du double mdp
// 	     UtilisateurBO res = utilisateur.registerUtilisateur(user[0], user[1], user[2], user[3], user[4], user[5], user[6], user[7], user[8], 100, false);
// 	     System.out.print(res);
	}
}
