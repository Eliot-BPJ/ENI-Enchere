package fr.eni.enchere.bll;

import java.util.List;

import fr.eni.enchere.bo.CategorieBO;
import fr.eni.enchere.dal.CategorieDAO;
import fr.eni.enchere.dal.DALException;
import fr.eni.enchere.dal.DAOFactory;

public class CategorieManager {
	private static CategorieDAO categorieDAO = DAOFactory.getCategorieDAO();
	
	public List<CategorieBO> getAllCategorie()
	{
		try {
			List<CategorieBO> cats = categorieDAO.getAllCategorie();
			if( cats != null)
			return cats;
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
