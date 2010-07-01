 var $j = jQuery.noConflict();
 
$j(document).ready(function($){


$('ul .cache').hide();


//tester si y a une session d'ouverte ici
//$("#conteneurMenu").hide();

$('.horizontal li').hover(
function(){
 jQuery(".cache", this).slideDown('normal'); 
 }, 
function(){jQuery(".cache", this).slideUp('normal');});



/*/pour les onglets sélectionnés à mettre en orange
$("#onglet>ul>li").load(function(){
	
	  $("#onglet ul li").removeClass('Selectionne').addClass("OngletPrincipal");	
	  alert('lala');
  $(this).removeClass().addClass('Selectionne');
  $(this).unbind('mouseenter mouseleave');


});*/

//on enleve tous les oranges des onglets et on garde celui qui vient d'être sélectionné.
$("#onglet ul li").removeClass('Selectionne').addClass("OngletPrincipal");
var urlActuel = window.location.pathname;
var collection = urlActuel.split("/");
var url = collection[2];
if (url=="accueil.html") {
	$("li[id~=accueil]").removeClass('OngletPrincipal').addClass("Selectionne");
	$("li[id~=accueil]").unbind('hover');	
	 
}
if (url=="societe.html") {
	$("#onglet>ul>#societe").removeClass('OngletPrincipal').addClass("Selectionne");
	 $("#onglet>ul>#societe").unbind('hover');
}

if (url=="contact.html") {
	$("#onglet>ul>#contact").removeClass('OngletPrincipal').addClass("Selectionne");
	 $("#onglet>ul>#contact").unbind('mouseenter mouseleave');
}

if (url=="tableauBord.html") {
	$("#onglet>ul>#tableauBord").removeClass('OngletPrincipal').addClass("Selectionne");
	 $("#onglet>ul>#tableauBord").unbind('mouseenter mouseleave');
}
if (url=="masterPage.html") {
	$("#onglet>ul>#catalogue").removeClass('OngletPrincipal').addClass("Selectionne");
	 $("#onglet>ul>#catalogue").unbind('mouseenter mouseleave');
}



});








