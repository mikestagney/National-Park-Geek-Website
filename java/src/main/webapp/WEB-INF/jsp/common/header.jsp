<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">


<link
	href="https://fonts.googleapis.com/css?family=EB+Garamond|Roboto|Roboto+Slab|ABeeZee|Bungee+Inline|Doppio+One|Molengo|Montserrat+Alternates|Righteous|Amaranth|Lobster|Reenie+Beanie|Special+Elite"
	rel="stylesheet">

<meta charset="UTF-8">
<title>National Park Geek</title>
<c:url value="/css/npgeek.css" var="cssHref" />
<link rel="stylesheet" href="${cssHref}">
</head>

<body>
	<header>

		<c:url value="/" var="homePageHref" />
		<c:url value="/img/logo.png" var="logoSrc" />
		<a href="${homePageHref}"> <img src="${logoSrc}"
			alt="National Park Geek logo" />
		</a>


	</header>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">


		<a class="navbar-brand" href="<c:url value="/"/>">Home</a> <a
			class="navbar-brand" href="<c:url value="/survey/post/add"/>">Survey</a>

	</nav>