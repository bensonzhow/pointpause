package fr.afcepf.ai77.g1.presentation.bean;

import java.util.Date;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class DeclarationIncidentBean {
	
	FacesContext context = FacesContext.getCurrentInstance();
	HttpServletRequest request = (HttpServletRequest) context
	.getExternalContext().getRequest();
	
	private String telephone;
	

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String declare(String numContrat, String numMachine, 
							String tel, Date dateConstat, Date dateDeclaration, String comment, Boolean flag){
		
		
		return null;
	}
}
