package fr.eni.enchere.dal;

import fr.eni.enchere.bo.CategorieBO;

public interface CategorieDAO {
	public CategorieBO getCategorieById(int id) throws DALException;
	public void createCategorie(CategorieBO categorie) throws DALException;
	public void updateCategorie(CategorieBO categorie) throws DALException;
	public void DeleteCategorie(CategorieBO categorie) throws DALException;
}
