<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Calculatrice Web</title>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<p class="response">${empty response ? '': response}</p>
	<p class="error" style="color: red;">${empty error ? '': error}</p>
	<form method="post" action="Calculatrice">
		<p>
			<input type="number" name="param1" id="param1" /> <select
				name="operation" id="operation">
				<option value="+">+</option>
				<option value="-">-</option>
				<option value="*">*</option>
				<option value="/">/</option>
			</select> <input type="number" name="param2" id="param2" /> <input
				type="submit" value="Afficher le résultat">
		</p>
	</form>
	<br/>
	<ul>
	<span><b>Jeu de test : </b></span>
		<li>2 + 1 = 3</li>
		<li>3 + vide = 3</li>
		<li>1 + -5 = -4</li>
		<li>5 / 0 = Affichage d'une erreur</li>
	</ul>
</body>
</html>