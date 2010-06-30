package fr.afcepf.ai77.g1.presentation.bean;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ApplicationBean {
	
	/*
	 * todo : ajouter un truc pour document xml
	 * 
	 * private String nomBaseFichier
	 * private XMLmachin fichierLangue
	 * 
	 * private loadFichierLangue(String langue){
	 *  fichierLangue = charger(nomBaseFichier+nomBaseFichier)
	 * }
	 * 
	 */
	
	
	public ApplicationBean(){
		//trucs à mettre pour vérifier que l'utilisateur est connecté
		/*
		 * pseudo code
		 * 
		 * 1) verifier si session existe
		 * 2) si n'existe pas, sortir
		 * 3) sinon, charger le fichier de langue loadFichierLangue(langue)
		 * 
		 * 
		 */
	}
	
	public boolean testConnexion(){
		FacesContext context = FacesContext.getCurrentInstance();  
		HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();  
		HttpSession httpSession = request.getSession(false);  
		
		Object sessionOK= httpSession.getAttribute("session");
		
		return (sessionOK!=null)?true:false;
	
	}
}
