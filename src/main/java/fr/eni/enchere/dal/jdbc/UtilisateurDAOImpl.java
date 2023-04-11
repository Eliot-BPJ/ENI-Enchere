package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import fr.eni.enchere.bo.UtilisateurBO;
import fr.eni.enchere.dal.DALException;
import fr.eni.enchere.dal.UtilisateurDAO;

public class UtilisateurDAOImpl implements UtilisateurDAO {
	private static final String sqlSelectById = "select no_utilisateur, pseudo, nom, prenom, email, rue, code_postal, ville, mot_de_passe, credit, administrateur " +
			" from UTILISATEURS where no_utilisateur = ?";
	private static final String sqlSelectByPseudo = "select no_utilisateur, pseudo, nom, prenom, email, rue, code_postal, ville, mot_de_passe, credit, administrateur " +
			" from UTILISATEURS where pseudo = ?";
	private static final String CREATE_USER = "INSERT INTO UTILISATEURS(pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) "
			+ " VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	private static final String DELETE_USER = "DELETE FROM UTILISATEURS WHERE no_utilisateur = ?";
	private static final String CONNECT = "SELECT no_utilisateur, pseudo, nom, prenom, email, rue, code_postal, ville, mot_de_passe, credit, administrateur FROM UTILISATEURS WHERE pseudo = ? AND mot_de_passe = ?";
	private static final String UPDATE_USER = "UPDATE UTILISATEURS set pseudo=?,nom=?,prenom=?,email=?,rue=?,code_postal=?,ville=?,mot_de_passe=?,credit=?,administrateur=? WHERE no_utilisateur = ?";
		
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
	public UtilisateurBO getUtilisateurByPseudo(String pseudo) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		UtilisateurBO user = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlSelectByPseudo);
			rqt.setString(1, pseudo);
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
			throw new DALException("selectById failed - id = " + pseudo , e);
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
	public UtilisateurBO createUtilisateur(UtilisateurBO user) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		if(getUtilisateurByPseudo(user.getPseudo()) != null)
		{
			throw new DALException("L'utilisateur existe déjà");
		}
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(CREATE_USER, Statement.RETURN_GENERATED_KEYS);
			rqt.setString(1, user.getPseudo());
			rqt.setString(2, user.getNom());
			rqt.setString(3, user.getPrenom());
			rqt.setString(4, user.getEmail());
			rqt.setString(5, user.getTelephone());
			rqt.setString(6, user.getRue());
			rqt.setString(7, user.getCodePostal());
			rqt.setString(8, user.getVille());
			rqt.setString(9, user.getMotDePasse());
			rqt.setInt(10, user.getCredit());
			rqt.setBoolean(11, user.isAdministrateur());
			rqt.setInt(12, user.getNoUtilisateur());
			int nbRows = rqt.executeUpdate();
			if(nbRows == 1){
				ResultSet rs = rqt.getGeneratedKeys();
				if(rs.next()){
					user.setNoUtilisateur(rs.getInt(1));
					return user;
				}

			}

		}catch(SQLException e){
			throw new DALException("Insert user failed - " + user, e);
		}
		finally {
			try {
				if (rqt != null){
					rqt.close();
				}
				if(cnx!=null){
					cnx.close();
				}
			} catch (SQLException e) {
				throw new DALException("close failed - ", e);
			}

		}
		return null;	
	}

	@Override
	public void updateUtilisateur(UtilisateurBO user) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(UPDATE_USER);
			rqt.setString(1, user.getPseudo());
			rqt.setString(2, user.getNom());
			rqt.setString(3, user.getPrenom());
			rqt.setString(4, user.getEmail());
			rqt.setString(5, user.getTelephone());
			rqt.setString(6, user.getRue());
			rqt.setString(7, user.getCodePostal());
			rqt.setString(8, user.getVille());
			rqt.setString(9, user.getMotDePasse());
			rqt.setInt(10, user.getCredit());
			rqt.setBoolean(11, user.isAdministrateur());
			rqt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Update article failed - " + user, e);
		} finally {
			try {
				if (rqt != null){
					rqt.close();
				}
				if(cnx !=null){
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	@Override
	public void DeleteUtilisateur(UtilisateurBO user) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {		
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(DELETE_USER);
			rqt.setInt(1, user.getNoUtilisateur());
			rqt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Delete article failed - id=" + user.getNoUtilisateur(), e);
		} finally {
			try {
				if (rqt != null){
					rqt.close();
				}
				if(cnx!=null){
					cnx.close();
				}
			} catch (SQLException e) {
				throw new DALException("close failed " , e);
			}

		}
		
	}

	public UtilisateurBO SeConnecter(String pseudo, String password) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		UtilisateurBO user = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(CONNECT);
			rqt.setString(1, pseudo);
			rqt.setString(2, password);
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
			throw new DALException("Connection failed - id = " + pseudo  , e);
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
}
