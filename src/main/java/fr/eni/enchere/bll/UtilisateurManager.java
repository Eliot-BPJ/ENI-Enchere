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
	
	public UtilisateurBO registerUtilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue, String codePostal,
			String ville, String motDePasse, int credit, boolean administrateur) {
		UtilisateurBO user = new UtilisateurBO();
		try {
			
			user.setPseudo(pseudo);
			user.setNom(nom);
			user.setPrenom(prenom);
			user.setEmail(email);
			user.setTelephone(telephone);
			user.setRue(rue);
			user.setCodePostal(codePostal);
			user.setVille(ville);
			user.setMotDePasse(motDePasse);
			user.setCredit(credit);
			user.setAdministrateur(administrateur);
			
			user = userDAO.createUtilisateur(user);
			
			return user;
			
		} catch (DALException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public UtilisateurBO updateUser(int no_user,String pseudo, String nom, String prenom, String email, String telephone, String rue, String codePostal,
			String ville, String motDePasse) {
		UtilisateurBO user = new UtilisateurBO();
		try {
			user.setNoUtilisateur(no_user);
			user.setPseudo(pseudo);
			user.setNom(nom);
			user.setPrenom(prenom);
			user.setEmail(email);
			user.setTelephone(telephone);
			user.setRue(rue);
			user.setCodePostal(codePostal);
			user.setVille(ville);
			user.setMotDePasse(motDePasse);			
			userDAO.updateUtilisateur(user);
			return user;
			
		} catch (DALException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}
