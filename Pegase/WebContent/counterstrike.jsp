<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Pegase - Gestion de Partie</title>
	</head>

	<body>
		<%@ include file="header.jsp" %>
		<h1> Gestion de partie - Counter Strike </h1>
		<h3> Partie</h3>
		<table>
			<tr>
				<td>
					Sirène tous pylônes :
				</td>
				<td></td>
				<td>
					<button type="button" class="btn btn-primary" id="debutPartie">Début/Reprise de partie (1 sirène longue)</button>
					<button type="button" class="btn btn-secondary" id="pausetPartie">Pause de partie (2 sirène courtes)</button>
					<button type="button" class="btn btn-danger" id="finPartie">Fin de partie (2 sirène courtes, 1 sirène longue)</button>
				</td>
			</tr>
			<tr><td></td><td>&nbsp;</td><td></td></tr>
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
					Poser la bombe au :
				</td>
				<td></td>
				<td>
					<button type="button" class="btn btn-warning" id="pylone">Pylône 1</button>
					<button type="button" class="btn btn-warning" id="pylone">Pylône 2</button>
					<button type="button" class="btn btn-warning" id="pylone">Pylône 3</button>
				</td>
			</tr>
			<tr><td></td><td>&nbsp;</td><td></td></tr>
		</table>
		
		<script type="text/javascript" src="JS\counterstrike.js"></script>
	</body>
</html>