package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.enchere.bo.CategorieBO;
import fr.eni.enchere.bo.RetraitBO;
import fr.eni.enchere.dal.DALException;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.RetraitDAO;

public class RetraitDAOImpl implements RetraitDAO {
	private static final String SELECT_RETRAIT_BY_ID = "SELECT rue,code_postal,ville FROM RETRAITS WHERE no_article = ?";
	private static final String CREATE_RETRAIT = "INSET INTO RETRAITS(no_article,rue,code_postal,ville) VALUES(?,?,?,?)";
	private static final String UPDATE_RETRAIT = "UPDATE FROM RETRAITS set rue = ?, code_postal = ?, ville = ? WHERE no_article = ?";
	private static final String DELETE_RETRAIT = "DELETE FROM RETRAITS WHERE no_article = ?";
	
	@Override
	public RetraitBO getRetraitById(int id) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		RetraitBO retrait= null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(SELECT_RETRAIT_BY_ID);
			rqt.setInt(1, id);
			rs = rqt.executeQuery();
			if (rs.next()){
				retrait = new RetraitBO(rs.getString("libelle"),
										rs.getString(""),
										rs.getString(""),
										DAOFactory.getArticleDAO().getArticleById(id));
			}

		} catch (SQLException e) {
			throw new DALException("selectRetraitById failed - id = " + id , e);
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
		return retrait;
	}

	@Override
	public void createRetrait(RetraitBO retrait) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(CREATE_RETRAIT);
			rqt.setInt(1, retrait.getArticle().getNoArticle());
			rqt.setString(2, retrait.getRue());
			rqt.setString(3, retrait.getCodePostal());
			rqt.setString(4, retrait.getVille());
		}catch(SQLException e){
			throw new DALException("Insert Enchere failed - " + retrait, e);
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
	public void updateRetrait(RetraitBO retrait) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(UPDATE_RETRAIT);
			rqt.setString(1, retrait.getRue());
			rqt.setString(2, retrait.getCodePostal());
			rqt.setString(3, retrait.getVille());
			rqt.setInt(4, retrait.getArticle().getNoArticle());
			rqt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Update retrait failed - " + retrait, e);
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
	public void DeleteRetrait(RetraitBO retrait) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {		
			cnx = JdbcTools.getConnection();
			//l'intégrité référentielle s'occupe d'invalider la suppression
			//si l'article est référencé dans une ligne de commande
			rqt = cnx.prepareStatement(DELETE_RETRAIT);
			rqt.setInt(1, retrait.getArticle().getNoArticle());
			rqt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Delete retrait failed - id=" + retrait.getArticle().getNoArticle(), e);
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
