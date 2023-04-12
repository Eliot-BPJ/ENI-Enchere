<%@page import="fr.eni.enchere.bo.UtilisateurBO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Profil</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<%	UtilisateurBO user = (UtilisateurBO)session.getAttribute("user");   	 %>
	        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="d-flex justify-content-between align-items-center align-items-lg-start">
                        <a class="text-decoration-none text-dark" href="index.jsp"
             			 ><h1>ENI - Enchères</h1></a
            			>
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
                        <div class="col-12 col-md-6 mb-3">
                            <label for="email" class="form-label h4">Email</label>
                            <p><%=user.getEmail()%></p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12 col-md-6 mb-3">
                            <label for="telephone" class="form-label h4">Téléphone</label>
                            <p><%=user.getTelephone()%></p>
                        </div>
                        <div class="col-12 col-md-6 mb-3">
                            <label for="rue" class="form-label h4">Rue</label>
                            <p><%=user.getRue()%></p>
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
                            <button type="submit" class="btn btn-dark">Modifier mon compte</button>
                        </div>
                    </di>
                </form>
            </div>
        </div>
    </div>
	
</body>
</html>