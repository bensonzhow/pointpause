var $j = jQuery.noConflict();
 
$j(document).ready(function($){
if($('#cacheur').is(":visible")){
	$('#general').hide();
}
$('#simplediv').click(function(){
$(this).fadeOut("slow", redirectPage);
}
);

function redirectPage() {
    
    window.location = "http://localhost:8080/PointPausePresentation/connexion.html";
}
});
