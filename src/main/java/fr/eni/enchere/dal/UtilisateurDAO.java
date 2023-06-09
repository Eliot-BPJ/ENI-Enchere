package fr.eni.enchere.dal;

import fr.eni.enchere.bo.UtilisateurBO;

public interface UtilisateurDAO {
	public UtilisateurBO getUtilisateurByNo(int no) throws DALException;
	public UtilisateurBO createUtilisateur(UtilisateurBO user) throws DALException;
	public void updateUtilisateur(UtilisateurBO user) throws DALException;
	public void DeleteUtilisateur(UtilisateurBO user) throws DALException;
	public UtilisateurBO SeConnecter(String pseudo, String password) throws DALException;
	public UtilisateurBO getUtilisateurByPseudo(String pseudo) throws DALException;
}
