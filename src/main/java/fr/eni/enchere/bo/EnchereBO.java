package fr.eni.enchere.bo;

import java.sql.Date;

public class EnchereBO {
	private Date dateEnchere;
	private int montantEnchere;
	private UtilisateurBO acheteur;
	private ArticleBO article;
	
	public EnchereBO() {
		
	}	
	public EnchereBO(Date dateEnchere, int montantEnchere, UtilisateurBO utilisateur, ArticleBO article) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.acheteur = utilisateur;
		this.article = article;
	}
	
	public Date getDateEnchere() {
		return dateEnchere;
	}
	public void setDateEnchere(Date dateEnchere) {
		this.dateEnchere = dateEnchere;
	}
	public int getMontantEnchere() {
		return montantEnchere;
	}
	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}
	public UtilisateurBO getAcheteur() {
		return acheteur;
	}
	public void setAcheteur(UtilisateurBO utilisateur) {
		this.acheteur = utilisateur;
	}
	public ArticleBO getArticle() {
		return article;
	}
	public void setArticle(ArticleBO article) {
		this.article = article;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EnchereBO [getDateEnchere()=");
		builder.append(getDateEnchere());
		builder.append(", getMontantEnchere()=");
		builder.append(getMontantEnchere());
		builder.append(", getUtilisateur()=");
		builder.append(getAcheteur());
		builder.append(", getArticle()=");
		builder.append(getArticle());
		builder.append("]");
		return builder.toString();
	}
	
	
}
