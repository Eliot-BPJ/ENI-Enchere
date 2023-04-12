package fr.eni.enchere.servlets.utilisateur;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.enchere.bll.UtilisateurManager;
import fr.eni.enchere.bo.UtilisateurBO;

/**
 * Servlet implementation class ServletUpdateProfile
 */
@WebServlet("/ServletUpdateProfile")
public class ServletUpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager utilisateur = new UtilisateurManager();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUpdateProfile() {
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
		String pseudo = request.getParameter("pseudo");
		String password = request.getParameter("mdp");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email =  request.getParameter("email");
		String telephone =  request.getParameter("telephone");
		String codePostal =  request.getParameter("codePostal");
		String ville =  request.getParameter("ville");
		String rue =  request.getParameter("rue");
		HttpSession session = request.getSession();
		String redirectPath = null;
		UtilisateurBO user2 = (UtilisateurBO)session.getAttribute("user");
		UtilisateurBO user =utilisateur.updateUser(user2.getNoUtilisateur(),pseudo, nom, prenom, email, telephone, rue, codePostal, ville, password);
		if(user != null)
		{
			session.setAttribute("user", user);
			redirectPath = "/index.jsp";
		}
		else
		{
			session.setAttribute("erreur", "Erreur de mise à jour données utilisateur ");
			redirectPath = "/erreur.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(redirectPath); 
		rd.forward(request, response);
	}

}
