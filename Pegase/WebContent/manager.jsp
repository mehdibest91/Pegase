<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Pegase - Gestion de Partie</title>
	</head>

	<body>
		<%@ include file="header.jsp" %>
		<h1> Gestion de partie </h1>
		<h3> Client (navigateur)</h3>
		<table>
			<tr>
				<td>
					Status de la partie : 
				</td>
				<td></td>
				<td>
					<div onclick="toggleOn()">
					<input type="checkbox" data-toggle="toggle" id="myToggle" data-off="Arrêtée" data-on="En Cours">
					</div>
				</td>
			</tr>
			<tr><td></td><td>&nbsp;</td><td></td></tr>
			<tr>
				<td>
					Client TCP :
				</td>
				<td></td>
				<td>
					<button type="button" class="btn btn-warning" id="helloWorld">Hello World!</button>
				</td>
			</tr>
		</table>
		
		<br><br>
		<h3> Serveur Pegase (serveur web)</h3>
		Message Pegase : <div id="messagePegase"></div>
		
		
		<h3> Serveur Hermes (serveur Jeu)</h3>
		Message Hermes : <div id="messageHermes"></div>
		
		<script type="text/javascript" src="JS\Manager.js"></script>
	</body>
</html>