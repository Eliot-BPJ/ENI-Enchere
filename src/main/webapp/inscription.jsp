<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Inscription</title>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
      crossorigin="anonymous"
    ></script>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
      crossorigin="anonymous"
    />
  </head>

  <body>
    <div class="container">
      <div class="row">
        <div class="col-12">
          <div
            class="d-flex justify-content-between align-items-center align-items-lg-start"
          >
            <a class="text-decoration-none text-dark" href="/Enchère"
 			 ><h1>ENI - Enchères</h1></a
			>
          </div>
        </div>
      </div>
    </div>

    <div class="container">
      <div class="row">
        <div class="col-12 d-flex justify-content-center">
          <h1>Créer un compte</h1>
        </div>
      </div>
      <div class="row">
        <div class="col-12 col-md-8 mx-auto">
          <form role="form" action="/Enchère/ServletInscription" method="post">
            <div class="row">
              <div class="col-12 col-md-6 mb-3">
                <label for="pseudo" class="form-label col-4 h4">Pseudo*</label>
                <input
                  required
                  type="text"
                  class="form-control col-8"
                  id="pseudo"
                  name="pseudo"
                  placeholder="Votre pseudo"
                />
              </div>
              <div class="col-12 col-md-6 mb-3">
                <label for="nom" class="form-label col-4 h4">Nom*</label>
                <input
                  required
                  type="text"
                  class="form-control col-8"
                  id="nom"
                  name="nom"
                  placeholder="Votre nom"
                />
              </div>
            </div>
            <div class="row">
              <div class="col-12 col-md-6 mb-3">
                <label for="prenom" class="form-label h4">Prénom*</label>
                <input
                  required
                  type="text"
                  class="form-control"
                  id="prenom"
                  name="prenom"
                  placeholder="Votre prénom"
                />
              </div>
              <div class="col-12 col-md-6 mb-3">
                <label for="email" class="form-label h4">Email*</label>
                <input
                  required
                  type="email"
                  class="form-control"
                  id="email"
                  name="email"
                  placeholder="Votre email"
                />
              </div>
            </div>
            <div class="row">
              <div class="col-12 col-md-6 mb-3">
                <label for="telephone" class="form-label h4">Téléphone</label>
                <input
                  type="tel"
                  class="form-control"
                  id="telephone"
                  name="telephone"
                  placeholder="Votre téléphone"
                />
              </div>
              <div class="col-12 col-md-6 mb-3">
                <label for="rue" class="form-label h4">Rue*</label>
                <input
                  required
                  type="text"
                  class="form-control"
                  id="rue"
                  name="rue"
                  placeholder="Nom de votre rue"
                />
              </div>
            </div>
            <div class="row">
              <div class="col-12 col-md-6 mb-3">
                <label for="codePostal" class="form-label h4">Code postal*</label>
                <input
                  required
                  type="text"
                  class="form-control"
                  id="codePostal"
                  name="codePostal"
                  placeholder="Votre code postal"
                />
              </div>
              <div class="col-12 col-md-6 mb-3">
                <label for="ville" class="form-label h4">Ville*</label>
                <input
                  required
                  type="text"
                  class="form-control"
                  id="ville"
                  name="ville"
                  placeholder="Votre ville"
                />
              </div>
            </div>
            <div class="row">
              <div class="col-12 col-md-6 mb-3">
                <label for="mdp" class="form-label h4">Mot de passe*</label>
                <input
                  required
                  type="password"
                  class="form-control"
                  id="mdp"
                  name="mdp"
                  placeholder="Votre mot de passe"
                />
              </div>
              <div class="col-12 col-md-6 mb-3">
                <label for="mdp2" class="form-label h4"
                  >Confirmez mot de passe*</label
                >
                <input
                  required
                  type="password"
                  class="form-control"
                  id="mdp2"
                  name="mdp2"
                  placeholder="Votre mot de passe"
                />
              </div>
              <p>Minimum requis: 12 caractères ; 1 majuscule ; 1 minuscule ; 1 chiffre ; 1 caractère spéciale </p>
            </div>
            <div class="row">
              <div class="col-5 mx-auto">
                <button type="submit" style="width: 100px" class="btn btn-dark">
                  Créer
                </button>
              </div>
              <div class="col-5 mx-auto">
                <a href="index.jsp" style="width: 100px" class="btn btn-dark"
                  >Annuler</a
                >
              </div>
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
          </form>
        </div>
      </div>
    </div>
  </body>
</html>
