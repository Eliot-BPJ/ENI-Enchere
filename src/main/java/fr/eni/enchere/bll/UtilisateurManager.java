package fr.eni.enchere.bll;

import fr.eni.enchere.bo.UtilisateurBO;
import fr.eni.enchere.dal.DALException;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.UtilisateurDAO;

public class UtilisateurManager {
	private UtilisateurDAO userDAO = DAOFactory.getUtilisateurDAO();

	public String connectUtilisateur(String pseudo, String password) {
//		this.userDAO.SeConnecter(user, password);
		try {
			UtilisateurBO user = this.userDAO.SeConnecter(pseudo, password);
			if (user == null) return "ko";
			System.out.println(user);
			return "ok";
			
		} catch (DALException e) {
			e.printStackTrace();
		}
		return "ko";
	}
}
