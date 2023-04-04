package fr.eni.enchere.bo;

public class RetraitBO {
	private String rue;
	private String codePostal;
	private String ville;
	private ArticleBO article;
	
	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public ArticleBO getArticle() {
		return article;
	}

	public void setArticle(ArticleBO article) {
		this.article = article;
	}

	public RetraitBO() {
		
	}

	public RetraitBO(String rue, String codePostal, String ville, ArticleBO article) {
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.article = article;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RetraitBO [getRue()=");
		builder.append(getRue());
		builder.append(", getCodePostal()=");
		builder.append(getCodePostal());
		builder.append(", getVille()=");
		builder.append(getVille());
		builder.append(", getArticle()=");
		builder.append(getArticle());
		builder.append("]");
		return builder.toString();
	}
	
}
