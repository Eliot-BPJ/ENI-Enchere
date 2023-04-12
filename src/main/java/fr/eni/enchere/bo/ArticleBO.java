package fr.eni.enchere.bo;

import java.sql.Date;

public class ArticleBO {
	private int noArticle;
	private String nomArticle;
	private String description;
	private Date dateDebutEncheres;
	private Date dateFinEncheres;
	private int prixInitial;
	private int prixVente;
	private CategorieBO categorie;
	private UtilisateurBO vendeur;
	
	public ArticleBO() {
	}
	public ArticleBO(String nomArticle, String description, Date dateDebutEncheres, Date dateFinEncheres,
			int prixInitial, int prixVente, CategorieBO categorie, UtilisateurBO vendeur) {
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.categorie = categorie;
		this.vendeur = vendeur;
	}
	public String getNomArticle() {
		return nomArticle;
	}
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateDebutEncheres() {
		return dateDebutEncheres;
	}
	public void setDateDebutEncheres(Date dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}
	public Date getDateFinEncheres() {
		return dateFinEncheres;
	}
	public void setDateFinEncheres(Date dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}
	public int getPrixInitial() {
		return prixInitial;
	}
	public void setPrixInitial(int prixInitial) {
		this.prixInitial = prixInitial;
	}
	public int getPrixVente() {
		return prixVente;
	}
	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}
	public Integer getNoArticle() {
		return noArticle;
	}
	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}
	public CategorieBO getCategorie() {
		return categorie;
	}
	public void setCategorie(CategorieBO categorie) {
		this.categorie = categorie;
	}
	public UtilisateurBO getVendeur() {
		return vendeur;
	}
	public void setVendeur(UtilisateurBO vendeur) {
		this.vendeur = vendeur;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ArticleBO [getNomArticle()=");
		builder.append(getNomArticle());
		builder.append(", getDescription()=");
		builder.append(getDescription());
		builder.append(", getDateDebutEncheres()=");
		builder.append(getDateDebutEncheres());
		builder.append(", getDateFinEncheres()=");
		builder.append(getDateFinEncheres());
		builder.append(", getPrixInitial()=");
		builder.append(getPrixInitial());
		builder.append(", getPrixVente()=");
		builder.append(getPrixVente());
		builder.append("]");
		return builder.toString();
	}
	
	
}
