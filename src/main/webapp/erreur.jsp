<%@ page language="java" contentType="text/html; charset=ISO-8859-1"	
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Resultat</title>
</head>
<body>
     <a class="mt-2 text-decoration-none text-dark" href="/Enchère">
    	<img style="width: 180px; height: 60px" alt="Eni - Enchères" src="images/LogoENIEncheres.jpeg">            
     </a>

	<%
		String erreurMsg = (String)session.getAttribute("erreur");
	%>
	<h1><%=erreurMsg%></h1>
	<%
		session.setAttribute("erreur", null);
	%>
</body>
</html>