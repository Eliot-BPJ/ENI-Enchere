package fr.eni.enchere.servlets.utilisateur;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.enchere.bll.UtilisateurManager;
import fr.eni.enchere.bo.UtilisateurBO;
import fr.eni.enchere.utils.MD5Utils;

/**
 * Servlet implementation class ServletConnexion
 */
@WebServlet("/ServletConnexion")
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager utilisateur = new UtilisateurManager();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("user", null);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pseudo = request.getParameter("inputPseudo");
		String password = request.getParameter("inputPassword");
		byte[] pswdBytes = MD5Utils.digest(password.getBytes(StandardCharsets.UTF_8));
		String pswdHash = Base64.getEncoder().encodeToString(pswdBytes);
		
		UtilisateurBO user = this.utilisateur.connectUtilisateur(pseudo, pswdHash);
		String redirectPath = null;
		HttpSession session = request.getSession();
	
		if (user != null) {
			session.setAttribute("user", user);
			redirectPath = "/index.jsp";
		} else {
			session.setAttribute("erreur", "Erreur de connexion à l'utilisateur: " + pseudo);
			redirectPath = "/login.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(redirectPath); 
		rd.forward(request, response);
	}

}
