<%@page import="fr.eni.enchere.bo.UtilisateurBO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
	<meta charset="ISO-8859-1">
	<title>Ench�re</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
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
<%--   	${
		UtilisateurBO user = (UtilisateurBO)session.getAttribute("user");
  	 }
 --%>
   	 <%
		UtilisateurBO user = (UtilisateurBO)session.getAttribute("user");
   	 %>
    <div class="container">
      <div class="row">
        <div class="col-12">
          <div
            class="d-flex justify-content-between align-items-center align-items-lg-start"
          >
            <a class="text-decoration-none text-dark mt-2" href="/Ench�re">
	          	<img style="width: 180px; height: 60px" alt="Eni - Ench�res" src="images/LogoENIEncheres.jpeg">            
            </a>
            <% 
            	if (user != null) 
            	{
            %>
            <div class="d-flex justify-content-lg-end mt-lg-3">
              <p>
                <a class="link-primary" href="profil.html">Ench�res</a>
                <a class="link-primary" href="nouvelleVente.html">Vendre un article</a>
                <a class="link-primary" href="profil.jsp">Mon profil</a>
                <a href="/Ench�re/ServletConnexion" class="link-primary">D�connexion</a>
              </p>
            </div>
            <%
	            }
	            else { 
            %>
            <div class="d-flex justify-content-lg-end mt-lg-3">
              <p>
                <a class="link-primary" href="inscription.jsp">S'inscrire</a> -
                <a href="login.jsp" class="link-primary">Se connecter</a>
              </p>
            </div>
            <% } %>
          </div>
        </div>
      </div>
    </div>

    <div class="container mt-3">
      <div class="row">
        <div class="col-12">
          <h4 class="text-center">Liste des ench�res</h4>
        </div>
      </div>

      <div class="container">
        <h4>Filtres :</h4>
        <div class="row form-group mt-5">
          <div class="col-5">
            <input
              type="search"
              class="form-control mt-1"
              placeholder="Le nom de l'article contient"
              aria-label="Search"
            />
<!--             <select -->
<!--               class="form-select mt-2" -->
<!--               aria-label="Default select example" -->
<!--             > -->
<!--               <label for="select">Cat�gorie</label> -->
<!--               <option value="1">Toutes</option> -->
<!--               <option value="2">Informatique</option> -->
<!--               <option value="3">Ameublement</option> -->
<!--               <option value="4">V�tements</option> -->
<!--               <option value="5">Sports & Loisirs</option> -->
<!--             </select> -->
			<select class="form-select mt-2 w-50" name="categorie">
				<option value="10">Toutes cat�gories</option>
    			<c:forEach items="${categorieList}" var="cat">
        			<option value="${cat.getNoCategorie()}">${cat.getLibelle()}</option>
    			</c:forEach>
			</select>
            <%
            	
            	if (user != null) 
            	{
            %>
            <!-- bloquer les checkbox de la radio non selectionn�e -->
            <div class="row col-12">
              <div class="form-check mt-3 col-6">
                <div class="form-group">
                  <input
                    class="form-check-input"
                    type="radio"
                    name="flexRadioDefault"
                    id="flexRadioDefault1"
                    checked
                  />
                  <label class="form-check-label" for="flexRadioDefault1">
                    Achats
                  </label>
                  <div class="form-check">
                    <input
                      class="form-check-input"
                      type="checkbox"
                      value=""
                      id="flexCheckDefault"
                    />
                    <label class="form-check-label" for="flexCheckDefault">
                      ench�res ouvertes
                    </label>
                  </div>
                  <div class="form-check">
                    <input
                      class="form-check-input"
                      type="checkbox"
                      value=""
                      id="flexCheckDefault"
                    />
                    <label class="form-check-label" for="flexCheckDefault">
                      mes ench�res en cours
                    </label>
                  </div>
                  <div class="form-check">
                    <input
                      class="form-check-input"
                      type="checkbox"
                      value=""
                      id="flexCheckDefault"
                    />
                    <label class="form-check-label" for="flexCheckDefault">
                      mes ench�res remport�es
                    </label>
                  </div>
                </div>
              </div>
              <div class="form-check mt-3 col-6">
              <div class="form-group">
                <input
                  class="form-check-input"
                  type="radio"
                  name="flexRadioDefault"
                  id="flexRadioDefault1"
                  checked
                />
                <label class="form-check-label" for="flexRadioDefault1">
                  Mes ventes
                </label>
                <div class="form-check">
                  <input
                    class="form-check-input"
                    type="checkbox"
                    value=""
                    id="flexCheckDefault"
                  />
                  <label class="form-check-label" for="flexCheckDefault">
                    mes ventes en cours
                  </label>
                </div>
                <div class="form-check">
                  <input
                    class="form-check-input"
                    type="checkbox"
                    value=""
                    id="flexCheckDefault"
                  />
                  <label class="form-check-label" for="flexCheckDefault">
                    ventes non d�but�es
                  </label>
                </div>
                <div class="form-check">
                  <input
                    class="form-check-input"
                    type="checkbox"
                    value=""
                    id="flexCheckDefault"
                  />
                  <label class="form-check-label" for="flexCheckDefault">
                    ventes termin�es
                  </label>
                </div>
              </div>
            </div>
          </div>
          <% } %>
        </div>
        <div class="col-2"></div>
        <div
          class="col-4 d-flex justify-content-end align-items-md-start mt-3 mt-md-0"
        >
          <button
            type="submit"
            class="btn btn-primary mt-3 shadow-sm"
            style="width: 100%; height: 48px"
          >
            Rechercher
          </button>
        </div>
      </div>
    </div>

    <!-- For each existing article create a bloc with this.article.photo / this.article.titre / ... -->
    <div class="mt-5 container">
      <div class="row d-flex justify-content-around">
        <!-- EXEMPLE ARTICLE : -->
<!--         <div class="col-12 col-md-4"> -->
<!--           <div class="card mt-3"> -->
<!--             <div class="row"> -->
<!--               <div class="col-4"> -->
<!--                 <img -->
<!--                   src="https://picsum.photos/id/1/100/200" -->
<!--                   class="card-img-top" -->
<!--                   alt="image {article.title}" -->
<!--                 /> -->
<!--               </div> -->
<!--               <div class="col-md-8"> -->
<!--                 <div class="card-body"> -->
<!--                   <h5 class="card-title">Ordinateur portable</h5> -->
<!--                   <p class="card-text">Prix de d�part : 100</p> -->
<!--                   <p class="card-text">Fin de l'ench�re : 01/01/2021</p> -->
<!--                   <p class="card-text"> -->
<!--                     Vendeur : <a href="#" class="link-primary">Jean Dupont</a> -->
<!--                   </p> -->
<!--                   <a href="#" class="btn btn-outline-success">Ench�rir</a> -->
<!--                 </div> -->
<!--               </div> -->
<!--             </div> -->
<!--           </div> -->
<!--         </div> -->

        <c:forEach items="${enchereList}" var="enchere" >

        <div class="col-12 col-md-4">
          <div class="card mt-3">
            <div class="row">
              <div class="col-4">
                <img
                  src="https://picsum.photos/id/2/100/200"
                  class="card-img-top"
                  alt="image {article.title}"
                />
              </div>
              <div class="col-md-8">
                <div class="card-body">
                  <h5 class="card-title">${enchere.getArticle().getNomArticle()}</h5>
                  <p class="card-text">${enchere.getArticle().getPrixInitial()}</p>
                  <p class="card-text">${enchere.getArticle().getDateFinEncheres()}</p>
                  <p class="card-text">
                    Vendeur : <a href="#" class="link-primary">${enchere.getArticle().getVendeur().getPseudo()}</a>
                  </p>
                  <a href="#" class="btn btn-outline-success">Ench�rir</a>
                </div>
              </div>
            </div>
          </div>
        </div>
        </c:forEach>
        
        
      </div>
    </div>
  </body>
</html>

<style>
  .lowchar {
    font-size: 0.8em;
  }
</style>
    