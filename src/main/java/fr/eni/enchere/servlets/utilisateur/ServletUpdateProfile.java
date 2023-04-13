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
		HttpSession session = request.getSession();
		UtilisateurBO actualUser = (UtilisateurBO)session.getAttribute("user");

		String redirectPath = null;
		String pseudo = request.getParameter("pseudo");		
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email =  request.getParameter("email");
		String telephone =  request.getParameter("telephone");
		String codePostal =  request.getParameter("codePostal");
		String ville =  request.getParameter("ville");
		String rue =  request.getParameter("rue");
		UtilisateurBO newUser = utilisateur.updateUser(actualUser,pseudo, nom, prenom, email, telephone, rue, codePostal, ville);
		if(newUser != null)
		{
			session.setAttribute("user", newUser);
			redirectPath = "/profil.jsp";
		}
		else
		{
			session.setAttribute("erreur", "Erreur de mise à jour données utilisateur ");
			redirectPath = "/erreur.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(redirectPath); 
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UtilisateurBO actualUser = (UtilisateurBO)session.getAttribute("user");
		String passwordActual = request.getParameter("mdpactuel");
		String pswdActualHash = Base64.getEncoder().encodeToString(MD5Utils.digest(passwordActual.getBytes(StandardCharsets.UTF_8)));

		if (!pswdActualHash.equals(actualUser.getMotDePasse())) {
			request.getSession().setAttribute("erreur", "Mot de passe actuel invalide");
			request.getRequestDispatcher("/modificationMdp.jsp").forward(request, response);
			return;
		}
		
		String password = request.getParameter("mdp");
		String password2 = request.getParameter("mdp2");
		String pswdHash;
		if(password.equals(password2))
		{
			byte[] pswdBytes = MD5Utils.digest(password.getBytes(StandardCharsets.UTF_8));
			pswdHash = Base64.getEncoder().encodeToString(pswdBytes);
		}
		else {
			request.getSession().setAttribute("erreur", "Les mots de passes ne sont pas similaires");
			request.getRequestDispatcher("/modificationMdp.jsp").forward(request, response);
			return;
		}

		String redirectPath = null;
		UtilisateurBO newUser = utilisateur.updateUserPswd(actualUser, pswdHash);
		if(newUser != null)
		{
			session.setAttribute("user", newUser);
			redirectPath = "/profil.jsp";
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
