package fr.eni.enchere.bll;

import java.sql.Date;
import java.util.List;

import fr.eni.enchere.bo.ArticleBO;
import fr.eni.enchere.bo.CategorieBO;
import fr.eni.enchere.bo.UtilisateurBO;
import fr.eni.enchere.dal.ArticleDAO;
import fr.eni.enchere.dal.DALException;
import fr.eni.enchere.dal.DAOFactory;

public class ArticleManager {
	
	private static ArticleDAO articleDAO = DAOFactory.getArticleDAO();
	
	public ArticleBO createArticle(String nom, String description, Date dateDebut, Date dateFin, 
			int prixInit, int prixVente, UtilisateurBO vendeur, CategorieBO cate) {
		ArticleBO article = new ArticleBO();
		try {
			article.setNomArticle(nom);
			article.setDescription(description);
			article.setDateDebutEncheres(dateDebut);
			article.setDateFinEncheres(dateFin);
			article.setPrixInitial(prixInit);
			article.setPrixVente(prixVente);
			article.setVendeur(vendeur);
			article.setCategorie(cate);
			article = articleDAO.createArticle(article);
			return article;
		} catch (DALException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<ArticleBO> getAllArticles() {
		try {
			List<ArticleBO> articles = articleDAO.getArticles();
			return articles;
		} catch (DALException e) {
			e.printStackTrace();
		}
		return null;
	}
}
