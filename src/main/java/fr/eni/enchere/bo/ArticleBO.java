package fr.eni.enchere.bo;

import java.util.Date;

public class ArticleBO {
	private int noArticle;
	private String nomArticle;
	private String description;
	private Date dateDebutEncheres;
	private Date dateFinEncheres;
	private int prixInitial;
	private int prixVente;
	private CategorieBO categorie;
	
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
