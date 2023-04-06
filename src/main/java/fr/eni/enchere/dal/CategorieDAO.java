package fr.eni.enchere.dal;

import fr.eni.enchere.bo.CategorieBO;

public interface CategorieDAO {
	public CategorieBO getCategorieById(int id) throws DALException;
	public void createArticle(CategorieBO categorie) throws DALException;
	public void updateArticle(CategorieBO categorie) throws DALException;
	public void DeleteArticle(CategorieBO categorie) throws DALException;
}
