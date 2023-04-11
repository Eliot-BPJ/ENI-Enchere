package fr.eni.enchere.bll;

import fr.eni.enchere.bo.ArticleBO;
import fr.eni.enchere.dal.ArticleDAO;
import fr.eni.enchere.dal.DALException;

public class ArticleManager {
	
	private static ArticleDAO articleDAO;
	
	public void addArticle(ArticleBO newArticle) throws BLLException {
		if(newArticle.getNoArticle() != null){
			throw new BLLException("Article deja existant.");
		}
		try {
			articleDAO.createArticle(newArticle);
		} catch (DALException e) {
			throw new BLLException("Echec addArticle", e);
		}
	}
}
