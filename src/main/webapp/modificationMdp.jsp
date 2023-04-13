<%@page import="fr.eni.enchere.bo.UtilisateurBO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modifier le profil</title>
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
                <h2>Modifier mon mot de passe</h2>
            </div>
        </div>
        <div class="row">
            <div class="col-12 col-md-8 mx-auto">
                <form action="/Enchère/ServletUpdateProfile" method="POST">
                     <div class="row">
                        <div class="col-12 col-md-6 mb-3">
                            <label for="mdpactuel" class="form-label h4">Mot de passe actuel</label>
                            <input type="password" class="form-control" id="mdpactuel" name="mdpactuel"
                                placeholder="********">
                        </div>
                      </div>
                     <div class="row">
                        <div class="col-12 col-md-6 mb-3">
                            <label for="mdp" class="form-label h4">Nouveau mot de passe</label>
                            <input type="password" class="form-control" id="mdp" name="mdp"
                                placeholder="********">
                        </div>
                        <div class="col-12 col-md-6 mb-3">
                            <label for="mdp2" class="form-label h4">Confirmez nouveau mot de passe</label>
                            <input type="password" class="form-control" id="mdp2" name="mdp2"
                                placeholder="********">
                        </div>
                    </div>
                    <div class="row mx-auto">
                        <div class="col-1"></div>
                        <div class="col-3">
                            <button type="submit" class="btn btn-dark">Enregistrer</button>
                        </div>
                        <div class="col-1"></div>
                        <div class="col-3 mx-auto">
                            <a href="modificationProfil.jsp" class="btn btn-dark">Retour</a>
                        </div>
                    </di>
                </form>
              <%
                String errMsg = (String)session.getAttribute("erreur");
            	if (errMsg != null) 
            	{
              %>
	              <p class="h5 text-center mt-4 text-danger"><%=errMsg %></p>
			  <% }
            	session.setAttribute("erreur", null);
              %>
            </div>
        </div>
    </div>


</body>

</html>