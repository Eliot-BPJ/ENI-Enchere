package fr.eni.enchere.dal;

import fr.eni.enchere.bo.EnchereBO;

public interface EnchereDAO {
	public EnchereBO getEnchereById(int id) throws DALException;
	public void createArticle(EnchereBO enchere) throws DALException;
	public void updateArticle(EnchereBO enchere) throws DALException;
	public void DeleteArticle(EnchereBO enchere) throws DALException;
}
