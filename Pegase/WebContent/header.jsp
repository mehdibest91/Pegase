<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css" rel="stylesheet">
	<link rel="stylesheet" href="css\bootstrap-theme.min.css" />
	<link rel="stylesheet" href="css\bootstrap.min.css" />
	<title>Header Pégase</title>
</head>
	<body  onload="activePage()" style='pegase-font'> 
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<div class="row">
						<div class="col-md-1">
							<img src="images\logo-pegase.jpg" alt="Logo Pégase" /> 
						</div>
						<div class="col-md-11">
							<ul class="nav nav-tabs" id="navHeader">
								<li id="navT2B" class="disabled">
									<a href="#"><p>Tableau de bord</p></a>
									<!-- <a href="t2b.jsp">Tableau de bord</a> -->
								</li>
								<li id="navManager">
									<a href="Manager"><p>Gestion Partie</p></a>
								</li>
								<li id="navHelp" class="active">
									<a href="help.jsp"><p>Aide</p></a>
								</li>
								<li id="navLogin" class="disabled">
									<a href="#"><p>Se connecter</p></a>
									<!-- <a href="login.jsp">Se connecter</a> -->
								</li>
							</ul>
							
							
							
							<div class="alert alert-dismissable alert-success">
								 
								<button type="button" class="close" data-dismiss="alert" aria-hidden="true">
									<p>×</p>
								</button>
								<h4>
									Alert!
								</h4> <p><strong>Warning!</strong> Best check yo self, you're not looking too good. <a href="#" class="alert-link">alert link</a></p>
							</div>
						</div>
					</div>
					<div class="row" id="breadcrumbGenerale">
						<div class="col-md-12">
							<ul class="breadcrumb">
								<li><a href="Manager" class="disabled">Vue Générale</a></li>
								<li><a href="counterstrike.jsp"> Partie : Counter Strike</a></li>
								<li><a href="#"> Pylônes : 2 connectés</a></li>
							</ul>
						</div>
					</div>
					<div class="row" id="colmd6Generale">
						<div class="col-md-6">
						Vue Générale (Horloge, Timeur partie, jauge des pylones, synthèses partie, synthèse pylones)
						<br>Partie (Horloge, Timeur partie, tous les indicateurs partie toutes équipes confondues)
						<br>Equipe 1 ... N (Progression, tous les indicateurs partie de l'équipe)
						</div>
						<div class="col-md-6">
						<br>Pylônes (Horloge, Jauge de batteries, synthèses pylones)
						<br>Pylône 1...N (Jauge de batterie, tous les indicateurs pylones)
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<script type="text/javascript" src="JS\jquery-3.1.1.min.js"></script>
		<script src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>
		<script type="text/javascript" src="JS\bootstrap.min.js"></script>
		<script type="text/javascript" src="JS\npm.js"></script>
		<script type="text/javascript" src="JS\Header.js"></script>
	</body>
</html>