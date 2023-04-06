package fr.eni.enchere.dal;

import fr.eni.enchere.bo.RetraitBO;

public interface RetraitDAO {
	public RetraitBO getRetraitById(int id) throws DALException;
	public void createRetrait(RetraitBO retrait) throws DALException;
	public void updateRetrait(RetraitBO retrait) throws DALException;
	public void DeleteRetrait(RetraitBO retrait) throws DALException;
}
