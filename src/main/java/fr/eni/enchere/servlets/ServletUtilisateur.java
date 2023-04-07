package fr.eni.enchere.servlets;

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
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.UtilisateurDAO;

/**
 * Servlet implementation class ServletUtilisateur
 */
@WebServlet("/ServletUtilisateur")
public class ServletUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager utilisateur = new UtilisateurManager();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUtilisateur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("get");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post");
		String pseudo = request.getParameter("inputPseudo");
		String password = request.getParameter("inputPassword");
		UtilisateurBO res = this.utilisateur.connectUtilisateur(pseudo, password);
		String redirectPath = null;
		HttpSession session = request.getSession();
		
		if (res != null) {			
			System.out.println("user: " + res);
			session.setAttribute("user", res);
			redirectPath = "/index.html";
		} else {
			session.setAttribute("erreur", "Erreur de connexion à l'utilisateur: " + pseudo);
			redirectPath = "/erreur.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(redirectPath); 
		rd.forward(request, response);
	}

}
