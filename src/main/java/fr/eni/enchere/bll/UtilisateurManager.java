package fr.eni.enchere.bll;

import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.UtilisateurDAO;

public class UtilisateurManager {
	private UtilisateurDAO userDAO = DAOFactory.getUtilisateurDAO();

	public String connectUtilisateur(String pseudo, String password) {
//		this.userDAO.SeConnecter(user, password);
		return "ko";
	}
}
