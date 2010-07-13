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
    
    window.location = "http://192.168.10.85:8081/PointPausePresentation/connexion.html";
}
});
