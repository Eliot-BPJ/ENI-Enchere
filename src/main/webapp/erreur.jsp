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
		String erreurMsg = (String)session.getAttribute("erreur");
	%>
	<h1><%=erreurMsg%></h1>
</body>
</html>