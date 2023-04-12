package fr.eni.enchere.dal;

import java.util.List;

import fr.eni.enchere.bo.ArticleBO;

public interface ArticleDAO {
	public List<ArticleBO> getArticles() throws DALException;
	public ArticleBO getArticleById(int id) throws DALException;
	public ArticleBO createArticle(ArticleBO article) throws DALException;
	public void updateArticle(ArticleBO article) throws DALException;
	public void DeleteArticle(ArticleBO article) throws DALException;
}
