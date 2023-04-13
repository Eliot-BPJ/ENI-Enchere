package fr.eni.enchere.bll;

import java.util.List;

import fr.eni.enchere.bo.EnchereBO;
import fr.eni.enchere.dal.DALException;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.EnchereDAO;

public class EnchereManager {

	private static EnchereDAO enchereDAO = DAOFactory.getEnchereDAO();
	
	public List<EnchereBO> getAllEnchere() {
		try {
			List<EnchereBO> encheres = enchereDAO.getAllEnchere();
			return encheres;
		} catch (DALException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<EnchereBO> searchEnchere(String word, int categorieID) {
		try {
			List<EnchereBO> encheres = enchereDAO.searchEnchere(word, categorieID);
			return encheres;
		} catch (DALException e) {
			e.printStackTrace();
		}
		return null;
	}

}