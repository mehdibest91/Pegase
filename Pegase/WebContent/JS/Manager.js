var stateError;


$("document").ready(function(){
	if ($("#myToggle").parent().hasClass("off")){
		stateError = 1;
	} else {
		stateError = 0;
	}
});

//le # récupère un ID
$("#gameProgress").click(function(e){
	e.stopPropagation(); // enlève les conflits JS
	var btn = $("#gameProgress");
	var msgPegase = $("#messagePegase");
	var msgHermes = $("#messageHermes");
	var state = btn.html();
	$.ajax({
	    url : 'Manager', // La ressource ciblée
	    type : 'POST', // Le type de la requête HTTP.
	    data : {"function":"turn","state":state},
	    dataType : "json",
	    success : function(monJson){
	    	btn.html(monJson.state);
	    	msgPegase.html(monJson.messagePegase);
	    	msgHermes.html(monJson.messageHermes)
	    },
	    error : function(){
	    	msgPegase.html("Une erreur est survenue, reporter l'opération")
	    	msgHermes.html("Une erreur est survenue sur Pegase, reporter l'opération")
	    }
	 });
});

$("#helloWorld").click(function(e){
	//e.stopPropagation(); // enlève les conflits JS
	var btn = $("#helloWorld");
	var msgPegase = $("#messagePegase");
	var msgHermes = $("#messageHermes");
	$.ajax({
	    url : 'Manager',
	    type : 'POST',
	    data : {"function":"helloWorld"},
	    dataType : "json",
	    success : function(monJson){
	    	msgPegase.html(monJson.messagePegase);
	    	msgHermes.html(monJson.messageHermes)
	    },
	    error : function(){
	    	msgPegase.html("Une erreur est survenue, reporter l'opération")
	    	msgHermes.html("Une erreur est survenue sur Pegase, reporter l'opération")
	    }
	 });
});

if ($("#gameProgress").html() == "ON"){
	stateError = 0;
	$('#helloWorld').prop('disabled', false);
} else {
	stateError = 1;
	$('#helloWorld').prop('disabled', true);
}

function toggleOn() {
	var msgPegase = $("#messagePegase");
	var msgHermes = $("#messageHermes");
	var state = ""
	var toto = $("#myToggle").parent();
	if (toto.hasClass("off")){
		state = "OFF";
	} else {
		state = "ON";
	}
	$.ajax({
	    url : 'Manager', // La ressource ciblée
	    type : 'POST', // Le type de la requête HTTP.
	    data : {"function":"turn","state":state},
	    dataType : "json",
	    success : function(monJson){
	    	msgPegase.html(monJson.messagePegase);
	    	msgHermes.html(monJson.messageHermes);
	    	if (monJson.state == "ON"){
	    		stateError = 0;
	    		$('#helloWorld').prop('disabled', false);
	    	} else {
	    		stateError = 1;
	    		$('#helloWorld').prop('disabled', true);
	    	}
	    },
	    error : function(){
	    	msgPegase.html("Une erreur est survenue, reporter l'opération")
	    	msgHermes.html("Une erreur est survenue sur Pegase, reporter l'opération")
	    	if (stateError == 0){
	    		toto.removeClass("off");
		    }else{
		    	toto.addClass("off");
		    }
	    }
	 });
  }