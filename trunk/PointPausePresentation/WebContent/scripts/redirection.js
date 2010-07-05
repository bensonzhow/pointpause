var $j = jQuery.noConflict();
 
$j(document).ready(function($){
	$('#simplediv').hide().animate({
	    opacity: 1,
	    height: 'toggle',
	    	width:'toggle'
	  });
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
