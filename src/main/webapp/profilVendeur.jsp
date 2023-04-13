<%@page import="fr.eni.enchere.bo.UtilisateurBO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profil vendeur</title>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<%
	UtilisateurBO user = (UtilisateurBO) request.getAttribute("user");
	%>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<div
					class="d-flex justify-content-between align-items-center align-items-lg-start">
		            <a class="mt-2 text-decoration-none text-dark" href="/Enchère">
			          	<img style="width: 180px; height: 60px" alt="Eni - Enchères" src="images/LogoENIEncheres.jpeg">            
		            </a>
				</div>
			</div>
		</div>
	</div>


	<div class="container">
		<div class="row">
			<div class="col-12 mx-auto text-center mb-4">
				<h2>Profil</h2>
			</div>
		</div>
		<div class="row">
			<div class="col-12 col-md-8 mx-auto text-center">
				<form action="/Enchère/modificationProfil.jsp" method="POST">
					<div class="row">
						<div class="col-12 col-md-6 mb-3">
							<label for="pseudo" class="form-label h4">Pseudonyme</label>
							<p><%=user.getPseudo()%></p>
						</div>
						<div class="col-12 col-md-6 mb-3">
							<label for="nom" class="form-label h4">Nom</label>
							<p><%=user.getNom()%></p>
						</div>
					</div>
					<div class="row">
						<div class="col-12 col-md-6 mb-3">
							<label for="prenom" class="form-label h4">Prénom</label>
							<p><%=user.getPrenom()%></p>
						</div>
					</div>
					<div class="row">
						<div class="col-12 col-md-6 mb-3">
							<label for="codePostal" class="form-label h4">Code postal</label>
							<p><%=user.getCodePostal()%></p>
						</div>
						<div class="col-12 col-md-6 mb-3">
							<label for="ville" class="form-label h4">Ville</label>
							<p><%=user.getVille()%></p>
						</div>
					</div>
					<div class="row mx-auto">
						<div class="col-1"></div>
						<div class="col-3 mx-auto">
							<a href="/Enchère" class="btn btn-primary shadow-sm">Retour</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>