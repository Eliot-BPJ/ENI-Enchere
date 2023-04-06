package fr.eni.enchere.dal;

import fr.eni.enchere.bo.ArticleBO;

public interface ArticleDAO {
	public ArticleBO getArticleById(int id) throws DALException;
	public void createArticle(ArticleBO article) throws DALException;
	public void updateArticle(ArticleBO article) throws DALException;
	public void DeleteArticle(ArticleBO article) throws DALException;
}
