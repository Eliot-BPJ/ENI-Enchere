package fr.eni.enchere.servlets.utilisateur;

import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bo.UtilisateurBO;
import fr.eni.enchere.utils.MD5Utils;
import fr.eni.enchere.bll.UtilisateurManager;

/**
 * Servlet implementation class ServletInscription
 */
@WebServlet("/ServletInscription")
public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager utilisateur = new UtilisateurManager();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		 UtilisateurBO res = null;
		Map userMap = request.getParameterMap();
		Set s = userMap.entrySet();
		Iterator it = s.iterator();
		String[] user = new String[10];
		String redirectPath = null;
		int index = 0;

		while (it.hasNext()) {
			Map.Entry<String, String[]> entry = (Map.Entry<String, String[]>) it.next();
			String key = entry.getKey();
			String[] value = entry.getValue();
			user[index] = value[0];
			index++;
		}
		
		Pattern pat = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=\\S+$).{12,}$");
		if (pat.matcher(user[8]).matches() == false) {
			request.getSession().setAttribute("erreur", "Le mot de passe n'est pas conforme");
			request.getRequestDispatcher("/inscription.jsp").forward(request, response);
		}

		if (user[8] != user[9]) {
			request.getSession().setAttribute("erreur", "Les mots de passes ne sont pas similaires");
			request.getRequestDispatcher("/inscription.jsp").forward(request, response);
		}
		byte[] pswdBytes = MD5Utils.digest(user[8].getBytes(StandardCharsets.UTF_8));
		String pswdHash = Base64.getEncoder().encodeToString(pswdBytes);

		UtilisateurBO userBo = utilisateur.registerUtilisateur(user[0], user[1], user[2], user[3], user[4], user[5],
				user[6], user[7], pswdHash, 100, false);
		if (userBo != null) {
			System.out.println("Inscription: " + userBo);
			redirectPath = "/login.html";
		} else {
			request.getSession().setAttribute("erreur", "Erreur d'inscription");
			redirectPath = "/erreur.jsp";
		}
		request.getRequestDispatcher(redirectPath).forward(request, response);
	}
}
