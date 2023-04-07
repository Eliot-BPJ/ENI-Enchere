package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.enchere.bo.ArticleBO;
import fr.eni.enchere.bo.UtilisateurBO;
import fr.eni.enchere.dal.ArticleDAO;
import fr.eni.enchere.dal.DALException;
import fr.eni.enchere.dal.DAOFactory;

public class ArticleDAOImpl implements ArticleDAO {

	private static final String SELECT_BY_ID = "SELECT nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_categorie,no_utilisateur FROM ARTICLES_VENDUS WHERE no_article =?";
	private static final String CREATE_ARTICLE = "INSERT INTO ARTICLES_VENDUS(nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie) values(?,?,?,?,?,?,?,?)";
	private static final String DELETE_ARTICLE = "DELETE FROM ARTICLES_VENDUS WHERE no_article=?";
	private static final String UPDATE_ARTICLE = "UPDATE ARTICLES_VENDUS set nom_article=?,description=?,date_debut_encheres=?,date_fin_encheres=?,prix_initial=?,prix_vente=?,no_utilisateur=?,mot_de_passe=?,no_categorie=? WHERE no_article = ?";
	
	@Override
	public ArticleBO getArticleById(int id) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		ArticleBO article = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(SELECT_BY_ID);
			rqt.setInt(1, id);
			rs = rqt.executeQuery();
			if (rs.next()){
				article = new ArticleBO(rs.getString("nom_article"),
							rs.getString("description"),
							rs.getDate("date_debut_encheres"),
							rs.getDate("date_fin_encheres"),
							rs.getInt("prix_initial"),
							rs.getInt("prix_vente"),
							DAOFactory.getCategorieDAO().getCategorieById(rs.getInt("no_categorie")),
							DAOFactory.getUtilisateurDAO().getUtilisateurByNo(rs.getInt("no_utilisateur"))
							);
			}

		} catch (SQLException e) {
			throw new DALException("selectById failed - id = " + id , e);
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
		return article;
	}

	@Override
	public void createArticle(ArticleBO article) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(CREATE_ARTICLE, Statement.RETURN_GENERATED_KEYS);
			rqt.setString(1, article.getNomArticle());
			rqt.setString(2, article.getDescription());
			rqt.setDate(3, article.getDateDebutEncheres());
			rqt.setDate(4, article.getDateFinEncheres());
			rqt.setInt(5, article.getPrixInitial());
			rqt.setInt(6, article.getPrixVente());
			rqt.setInt(7, article.getVendeur().getNoUtilisateur());
			rqt.setInt(8, article.getCategorie().getNoCategorie());
			int nbRows = rqt.executeUpdate();
			if(nbRows == 1){
				ResultSet rs = rqt.getGeneratedKeys();
				if(rs.next()){
					article.setNoArticle(rs.getInt(1));
				}

			}

		}catch(SQLException e){
			throw new DALException("Insert user failed - " + article, e);
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
	public void updateArticle(ArticleBO article) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(UPDATE_ARTICLE);
			rqt.setString(1, article.getNomArticle());
			rqt.setString(2, article.getDescription());
			rqt.setDate(3, article.getDateDebutEncheres());
			rqt.setDate(4, article.getDateFinEncheres());
			rqt.setInt(5, article.getPrixInitial());
			rqt.setInt(6, article.getPrixVente());
			rqt.setInt(7, article.getVendeur().getNoUtilisateur());
			rqt.setInt(8, article.getCategorie().getNoCategorie());
			rqt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Update article failed - " + article, e);
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
	public void DeleteArticle(ArticleBO article) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {		
			cnx = JdbcTools.getConnection();
			//l'intégrité référentielle s'occupe d'invalider la suppression
			//si l'article est référencé dans une ligne de commande
			rqt = cnx.prepareStatement(DELETE_ARTICLE);
			rqt.setInt(1, article.getNoArticle());
			rqt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Delete article failed - id=" + article.getNoArticle(), e);
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
