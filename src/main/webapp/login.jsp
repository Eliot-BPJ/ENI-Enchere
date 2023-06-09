<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Identifiez-vous</title>
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
            <a class="mt-2 text-decoration-none text-dark" href="/Ench�re">
	          	<img style="width: 180px; height: 60px" alt="Eni - Ench�res" src="images/LogoENIEncheres.jpeg">            
            </a>
          </div>
        </div>
      </div>
    </div>

    <div class="container mx-auto col-6 mt-5" style="width: 400px">
      <form class="row g-3" role="form" action="/Ench�re/ServletConnexion" method="post">
        <div class="col-12">
          <label for="inputPseudo" class="form-label h4">Pseudo :</label>
          <input type="text" class="form-control" id="inputPseudo" name="inputPseudo" required/>
        </div>
        <div class="col-12">
          <label for="inputPassword" class="form-label h4">Mot de passe :</label>
          <input type="password" class="form-control" id="inputPassword" name="inputPassword" required/>
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

        <div class="row mt-3">
          <div class="col-6 d-flex justify-content-start">
            <button type="submit" class="btn btn-primary shadow">
              Connexion
            </button>
          </div>
          <div class="col-6 d-flex justify-content-end">
            <div class="form-check mt-2">
              <input class="form-check-input" type="checkbox" id="gridCheck" />
              <label class="form-check-label fs-6" for="gridCheck">
                Se souvenir de moi
              </label>
            </div>
          </div>
        </div>
        <div class="col-12 mb-5 d-flex ml-5 justify-content-center">
          <a href="#">Mot de passe oubli�</a>
        </div>
      </form>
    </div>

    <div class="container">
      <div class="row">
        <div class="col-12">
          <div
            class="d-flex justify-content-center align-items-center align-items-lg-start"
          >
            <a class="btn btn-primary shadow py-2 px-5" href="inscription.jsp"
              >Cr�er un compte</a
            >
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
