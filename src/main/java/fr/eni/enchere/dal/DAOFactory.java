package fr.eni.enchere.dal;

public class DAOFactory {
	
	public static UtilisateurDAO getUtilisateurDAO()  {
		UtilisateurDAO utilisateurDAO=null;
		try {
			utilisateurDAO=(UtilisateurDAO ) Class.forName("fr.eni.enchere.dal.jdbc.UtilisateurDAOImpl").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return utilisateurDAO; 
	}
	public static ArticleDAO getArticleDAO()  {
		ArticleDAO articleDAO=null;
		try {
			articleDAO=(ArticleDAO ) Class.forName("fr.eni.enchere.dal.jdbc.ArticleDAOImpl").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return articleDAO; 
	}
	public static RetraitDAO getRetraitDAO()  {
		RetraitDAO retraitDAO=null;
		try {
			retraitDAO=(RetraitDAO ) Class.forName("fr.eni.enchere.dal.jdbc.RetraitDAOImpl").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retraitDAO; 
	}
	public static EnchereDAO getEnchereDAO()  {
		EnchereDAO enchereDAO=null;
		try {
			enchereDAO=(EnchereDAO) Class.forName("fr.eni.enchere.dal.jdbc.EnchereDAOImpl").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return enchereDAO; 
	}
	public static CategorieDAO getCategorieDAO()  {
		CategorieDAO categorieDAO=null;
		try {
			categorieDAO=(CategorieDAO) Class.forName("fr.eni.enchere.dal.jdbc.CategorieDAOImpl").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categorieDAO; 
	}

}
