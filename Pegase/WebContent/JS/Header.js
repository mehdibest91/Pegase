function activePage() {
	 $(".nav").find(".active").removeClass("active");
	 var currNav = window.location.href.substr(window.location.href.lastIndexOf('/') + 1).toUpperCase().replace(".JSP", "");
	 if (currNav == 'MANAGER') {
		 $("#navManager").addClass("active");
	 } else if (currNav == 'HELP'|currNav == '') {
		 $("#navHelp").addClass("active");
		 hide(document.getElementById('breadcrumbGenerale'));
		 hide(document.getElementById('colmd6Generale'));
	 } else if (currNav == 'T2B') {
		 $("#navT2B").addClass("active");
	 } else if (currNav == 'LOGIN') {
		 $("#navLogin").addClass("active");
		 hide(document.getElementById('breadcrumbGenerale'));
		 hide(document.getElementById('colmd6Generale'));
	 }
	 $(this).parent().addClass("active");
}

function hide (elements) {
	  elements = elements.length ? elements : [elements];
	  for (var index = 0; index < elements.length; index++) {
	    elements[index].style.display = 'none';
	  }
	}