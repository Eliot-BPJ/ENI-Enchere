package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.CategorieBO;
import fr.eni.enchere.bo.EnchereBO;
import fr.eni.enchere.dal.CategorieDAO;
import fr.eni.enchere.dal.DALException;
import fr.eni.enchere.dal.DAOFactory;

public class CategorieDAOImpl implements CategorieDAO{

	private static final String SELECT_BY_ID = "SELECT libelle FROM CATEGORIES WHERE no_categorie = ?";
	private static final String SELECT_ALL = "SELECT no_categorie,libelle FROM CATEGORIES";
	private static final String CREATE_CATEGORIE = "INSERT INTO CATEGORIES(libelle) VALUES(?)";
	private static final String UPDATE_CATEGORIE = "UPDATE FROM CATEGORIES set libelle = ? WHERE no_categorie = ?";
	private static final String DELETE_CATEGORIE = "DELETE FROM CATEGORIES WHERE no_categorie = ?";
	@Override
	public CategorieBO getCategorieById(int id) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		CategorieBO categorie= null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(SELECT_BY_ID);
			rqt.setInt(1, id);
			rs = rqt.executeQuery();
			if (rs.next()){
				categorie = new CategorieBO(rs.getString("libelle"));
				categorie.setNoCategorie(id);
			}

		} catch (SQLException e) {
			throw new DALException("selectCategorieById failed - id = " + id , e);
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
		return categorie;
	}
	
	public List<CategorieBO> getAllCategorie() throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		List<CategorieBO> categorie= new ArrayList<CategorieBO>();
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(SELECT_ALL);
			rs = rqt.executeQuery();
			while (rs.next()){
				CategorieBO cat = new CategorieBO(rs.getString("libelle"));
				cat.setNoCategorie(rs.getInt("no_categorie"));
				categorie.add(cat);
			}

		} catch (SQLException e) {
			throw new DALException("selectAllCategorie failed" , e);
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
		return categorie;
	}

	@Override
	public void createCategorie(CategorieBO categorie) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(CREATE_CATEGORIE);
			rqt.setString(1, categorie.getLibelle());
		}catch(SQLException e){
			throw new DALException("Insert Categorie failed - " + categorie, e);
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
	}

	@Override
	public void updateCategorie(CategorieBO categorie) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(UPDATE_CATEGORIE);
			rqt.setString(1, categorie.getLibelle());
			rqt.setInt(1, categorie.getNoCategorie());
			rqt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Update categorie failed - " + categorie, e);
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
	public void DeleteCategorie(CategorieBO categorie) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {		
			cnx = JdbcTools.getConnection();
			//l'intégrité référentielle s'occupe d'invalider la suppression
			//si l'article est référencé dans une ligne de commande
			rqt = cnx.prepareStatement(DELETE_CATEGORIE);
			rqt.setInt(1, categorie.getNoCategorie());
			rqt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Delete categorie failed - id=" + categorie.getNoCategorie(), e);
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

}
