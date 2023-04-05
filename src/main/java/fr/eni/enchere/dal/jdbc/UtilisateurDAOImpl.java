package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.enchere.bo.UtilisateurBO;
import fr.eni.enchere.dal.DALException;
import fr.eni.enchere.dal.UtilisateurDAO;

public class UtilisateurDAOImpl implements UtilisateurDAO {
	private static final String sqlSelectById = "select no_utilisateur, pseudo, nom, prenom, email, rue, code_postal, ville, mot_de_passe, credit, administrateur " +
			" from UTILISATEURS where no_utilisateur = ?";

	@Override
	public UtilisateurBO getUtilisateurByNo(int no) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		UtilisateurBO user = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlSelectById);
			rqt.setInt(1, no);

			rs = rqt.executeQuery();
			if (rs.next()){
				user = new UtilisateurBO(rs.getString("pseudo"),
							rs.getString("nom"),
							rs.getString("prenom"),
							rs.getString("email"),
							rs.getString("rue"),
							rs.getString("code_postal"),
							rs.getString("ville"),
							rs.getString("mot_de_passe"),
							rs.getInt("credit"),
							rs.getBoolean("administrateur"));
				user.setNoUtilisateur(rs.getInt("no_utilisateur"));
			}

		} catch (SQLException e) {
			throw new DALException("selectById failed - id = " + no , e);
		} finally {
			try {
				if (rs != null){
					rs.close();
				}
				if (rqt != null){
					rqt.close();
				}
				if(cnx!=null){
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return user;
	}

	@Override
	public void createUtilisateur(UtilisateurBO user) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUtilisateur(UtilisateurBO user) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DeleteUtilisateur(UtilisateurBO user) throws DALException {
		// TODO Auto-generated method stub
		
	}
}
