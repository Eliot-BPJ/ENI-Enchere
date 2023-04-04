package fr.eni.enchere.bo;

import java.util.Date;

public class EnchereBO {
	private Date dateEnchere;
	private int montantEnchere;
	private UtilisateurBO utilisateur;
	private ArticleBO article;
	
	public EnchereBO() {
		
	}	
	public EnchereBO(Date dateEnchere, int montantEnchere, UtilisateurBO utilisateur, ArticleBO article) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.utilisateur = utilisateur;
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
	public UtilisateurBO getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(UtilisateurBO utilisateur) {
		this.utilisateur = utilisateur;
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
		builder.append(getUtilisateur());
		builder.append(", getArticle()=");
		builder.append(getArticle());
		builder.append("]");
		return builder.toString();
	}
	
	
}
