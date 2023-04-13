package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.EnchereBO;
import fr.eni.enchere.dal.DALException;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.EnchereDAO;

public class EnchereDAOImpl implements EnchereDAO {
	private static final String SELECT_BY_ARTICLE = "SELECT no_utilisateur,date_enchere,montant_enchere FROM ENCHERES WHERE no_article = ?";
	private static final String SELECT_BY_USER = "SELECT no_utilisateur,date_enchere,montant_enchere FROM ENCHERES WHERE no_utilisateur = ?";
	private static final String SELECT_ALL = "SELECT no_utilisateur,date_enchere,montant_enchere,no_article FROM ENCHERES";
	private static final String SELECT_BY_DATE = "SELECT no_utilisateur,date_enchere,montant_enchere FROM ENCHERES WHERE date_enchere = ?";
	private static final String SELECT_ENCHERE= "SELECT no_utilisateur,date_enchere,montant_enchere FROM ENCHERES WHERE no_article = ? AND no_utilisateur = ? AND date_enchere = ?";
	private static final String CREATE_ENCHERE = "INSERT INTO ENCHERES(no_utilisateur,no_article,montant_enchere) VALUES(?,?,?)";
	private static final String DELETE_ARTICLE = "DELETE FROM ENCHERES WHERE no_utilisateur= ? AND no_article= ? AND date_enchere = ?";
	private static final String SELECT_BY_WORD_AND_CAT = "SELECT no_utilisateur,date_enchere,montant_enchere,no_article "+
			"FROM ENCHERES T1 "+
			"INNER JOIN ARTICLES_VENDUS T2 ON T1.no_article = T2.no_article "+
			"WHERE nom_article like %?% "+
			"AND no_categorie = ?";
	private static final String SELECT_BY_WORD = "SELECT no_utilisateur,date_enchere,montant_enchere,no_article "+
			"FROM ENCHERES T1 "+
			"INNER JOIN ARTICLES_VENDUS T2 ON T1.no_article = T2.no_article "+
			"WHERE nom_article like %?% "+
			"AND no_categorie = ?";
	@Override
	public EnchereBO getEnchereByArticle(int id_article) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		EnchereBO enchere = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(SELECT_BY_ARTICLE);
			rqt.setInt(1, id_article);
			rs = rqt.executeQuery();
			if (rs.next()){
				enchere = new EnchereBO(rs.getDate("date_enchere"),
										rs.getInt("montant_enchere"),
										DAOFactory.getUtilisateurDAO().getUtilisateurByNo(rs.getInt("no_utilisateur")),
										DAOFactory.getArticleDAO().getArticleById(rs.getInt("no_article")));
			}

		} catch (SQLException e) {
			throw new DALException("selectById failed - id = " + id_article , e);
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
		return enchere;
	}
	
	@Override
	public List<EnchereBO> searchEnchere(String word, int categorieID) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		List<EnchereBO> enchere = null;
		try {
			cnx = JdbcTools.getConnection();
			if(categorieID == 10)
			{
				rqt = cnx.prepareStatement(SELECT_BY_WORD);
				rqt.setString(1, word);
			}
			else
			{
				rqt = cnx.prepareStatement(SELECT_BY_WORD_AND_CAT);
				rqt.setString(1, word);
				rqt.setInt(2, categorieID);
			}
			
			rs = rqt.executeQuery();
			while (rs.next()){
				enchere.add(new EnchereBO(rs.getDate("date_enchere"),
										rs.getInt("montant_enchere"),
										DAOFactory.getUtilisateurDAO().getUtilisateurByNo(rs.getInt("no_utilisateur")),
										DAOFactory.getArticleDAO().getArticleById(rs.getInt("no_article"))));
			}

		} catch (SQLException e) {
			throw new DALException("searchEnchere failed " , e);
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
		return enchere;
	}
	
	@Override
	public void createEnchere(EnchereBO enchere) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(CREATE_ENCHERE);
			rqt.setInt(1, enchere.getAcheteur().getNoUtilisateur());
			rqt.setInt(2, enchere.getArticle().getNoArticle());
			rqt.setInt(3, enchere.getMontantEnchere());
		}catch(SQLException e){
			throw new DALException("Insert Enchere failed - " + enchere, e);
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
	public void updateEnchere(EnchereBO enchere) throws DALException {
		
	}
	@Override
	public void DeleteEnchere(EnchereBO enchere) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {		
			cnx = JdbcTools.getConnection();
			//l'intégrité référentielle s'occupe d'invalider la suppression
			//si l'article est référencé dans une ligne de commande
			rqt = cnx.prepareStatement(DELETE_ARTICLE);
			rqt.setInt(1, enchere.getArticle().getNoArticle());
			rqt.setInt(2, enchere.getAcheteur().getNoUtilisateur());
			rqt.setDate(3, enchere.getDateEnchere());
			rqt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Delete enchere failed - id=" + enchere, e);
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
	@Override
	public EnchereBO getEnchere(int id_article, int id_utilisateur, Date date_enchere) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		EnchereBO enchere = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(SELECT_ENCHERE);
			rqt.setInt(1, id_article);
			rqt.setInt(2, id_utilisateur);
			rqt.setDate(3, date_enchere);
			rs = rqt.executeQuery();
			if (rs.next()){
				enchere = new EnchereBO(rs.getDate("date_enchere"),
										rs.getInt("montant_enchere"),
										DAOFactory.getUtilisateurDAO().getUtilisateurByNo(rs.getInt("no_utilisateur")),
										DAOFactory.getArticleDAO().getArticleById(rs.getInt("no_article")));
			}

		} catch (SQLException e) {
			throw new DALException("selectByDate failed - id article = " + id_article +" id user : " + id_utilisateur + "date : " + date_enchere , e);
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
		return enchere;
	}
	@Override
	public EnchereBO getEnchereByUserId(int id_utilisateur) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		EnchereBO enchere = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(SELECT_BY_USER);
			rqt.setInt(1, id_utilisateur);
			rs = rqt.executeQuery();
			if (rs.next()){
				enchere = new EnchereBO(rs.getDate("date_enchere"),
										rs.getInt("montant_enchere"),
										DAOFactory.getUtilisateurDAO().getUtilisateurByNo(rs.getInt("no_utilisateur")),
										DAOFactory.getArticleDAO().getArticleById(rs.getInt("no_article")));
			}

		} catch (SQLException e) {
			throw new DALException("selectByUserID failed - id = " + id_utilisateur , e);
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
		return enchere;
	}
	@Override
	public EnchereBO getEnchereByDate(Date date_enchere) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		EnchereBO enchere = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(SELECT_BY_DATE);
			rqt.setDate(1, date_enchere);
			rs = rqt.executeQuery();
			if (rs.next()){
				enchere = new EnchereBO(rs.getDate("date_enchere"),
										rs.getInt("montant_enchere"),
										DAOFactory.getUtilisateurDAO().getUtilisateurByNo(rs.getInt("no_utilisateur")),
										DAOFactory.getArticleDAO().getArticleById(rs.getInt("no_article")));
			}

		} catch (SQLException e) {
			throw new DALException("selectByDate failed - id = " + date_enchere , e);
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
		return enchere;
	}
	
	@Override
	public List<EnchereBO> getAllEnchere() throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		List<EnchereBO> enchere = new ArrayList<>();
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(SELECT_ALL);
			rs = rqt.executeQuery();
			while (rs.next()){
				System.out.println(rs.getDate("date_enchere"));
				System.out.println(rs.getInt("montant_enchere"));
				System.out.println(rs.getInt("no_utilisateur"));
				System.out.println(rs.getInt("no_article"));
				enchere.add(new EnchereBO(rs.getDate("date_enchere"),
										rs.getInt("montant_enchere"),
										DAOFactory.getUtilisateurDAO().getUtilisateurByNo(rs.getInt("no_utilisateur")),
										DAOFactory.getArticleDAO().getArticleById(rs.getInt("no_article"))));
			}

		} catch (SQLException e) {
			throw new DALException("selectAllEnchere failed ", e);
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
		return enchere;
	}
	
}
