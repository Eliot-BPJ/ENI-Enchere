package fr.eni.enchere.bll;

import fr.eni.enchere.bo.UtilisateurBO;
import fr.eni.enchere.dal.DALException;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.UtilisateurDAO;

public class UtilisateurManager {
	private UtilisateurDAO userDAO = DAOFactory.getUtilisateurDAO();

	public UtilisateurBO connectUtilisateur(String pseudo, String password) {
//		this.userDAO.SeConnecter(user, password);
		try {
			UtilisateurBO user = this.userDAO.SeConnecter(pseudo, password);
			return user;
		} catch (DALException e) {
			e.printStackTrace();
		}
		return null;
	}
}
