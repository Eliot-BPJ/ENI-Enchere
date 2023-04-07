package fr.eni.enchere.dal;

import java.sql.Date;

import fr.eni.enchere.bo.EnchereBO;

public interface EnchereDAO {
	public EnchereBO getEnchereByArticle(int id_article) throws DALException;
	public EnchereBO getEnchere(int id_article, int id_utilisateur, Date date_enchere) throws DALException;
	public EnchereBO getEnchereByUserId(int id_utilisateur) throws DALException;
	public EnchereBO getEnchereByDate(Date date_enchere) throws DALException;
	public void createEnchere(EnchereBO enchere) throws DALException;
	public void updateEnchere(EnchereBO enchere) throws DALException;
	public void DeleteEnchere(EnchereBO enchere) throws DALException;
}
