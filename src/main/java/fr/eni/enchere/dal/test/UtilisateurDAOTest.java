package fr.eni.enchere.dal.test;

import fr.eni.enchere.bo.UtilisateurBO;
import fr.eni.enchere.dal.DALException;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.UtilisateurDAO;
import fr.eni.enchere.dal.jdbc.UtilisateurDAOImpl;

public class UtilisateurDAOTest {
	public static void main(String[] args) {
	UtilisateurDAO userDAO = DAOFactory.getUtilisateurDAO();
	try {
		UtilisateurBO user2 = userDAO.getUtilisateurByNo(1);
		System.out.println(user2.toString());
	} catch (DALException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
}
