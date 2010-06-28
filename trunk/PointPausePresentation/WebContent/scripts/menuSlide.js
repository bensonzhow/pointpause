{$(document).ready(function(){
$('ul .cache').hide();

//tester si y a une session d'ouverte ici
//$("#conteneurMenu").hide();

$('.horizontal li').hover(
function(){
 jQuery(".cache", this).slideDown('normal'); 
 }, 
function(){jQuery(".cache", this).slideUp('normal');});



//pour les onglets sélectionnés à mettre en orange
$("#onglet>ul>li").click(function(){
	  $("#onglet ul li").removeClass('Selectionne').addClass("OngletPrincipal");	
  $(this).removeClass().addClass('Selectionne');

});


});
}






