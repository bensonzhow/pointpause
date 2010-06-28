{$(document).ready(function(){
$('ul .cache').hide();


$('.horizontal li').hover(
function(){
 jQuery(".cache", this).slideDown('normal'); 
 }, 
function(){jQuery(".cache", this).slideUp('normal');});
/* pour les onglets sélectionnés à mettre en orange
$("#onglet>ul>li").click(function(){
  $(this).removeClass().addClass('Selectionne');
});
//../../Pointpause/images/
*/
});
}

