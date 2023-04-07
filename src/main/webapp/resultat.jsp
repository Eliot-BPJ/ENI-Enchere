<%@page import="fr.eni.enchere.bo.UtilisateurBO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"	
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Resultat</title>
</head>
<body>
	<%
		UtilisateurBO user = (UtilisateurBO)session.getAttribute("user");
	%>
	User pseudo : <%=user.getPseudo()%>
	<p></p>
	User nom : <%=user.getNom()%>
	<p></p>
	User email : <%=user.getEmail()%>
	<p></p>
	User tel : <%=user.getTelephone()%>
	<p></p>
	User ville : <%=user.getVille()%>
</body>
</html>