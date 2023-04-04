package fr.eni.enchere.bo;

public class CategorieBO {
	private int noCategorie;
	private String libelle;
	
	
	public CategorieBO() {
	}

	public CategorieBO(String libelle) {
		this.libelle = libelle;
	}

	public int getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CategorieBO [getNoCategorie()=");
		builder.append(getNoCategorie());
		builder.append(", getLibelle()=");
		builder.append(getLibelle());
		builder.append("]");
		return builder.toString();
	}
	
	
}
