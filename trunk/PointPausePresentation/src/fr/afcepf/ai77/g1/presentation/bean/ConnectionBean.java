package fr.afcepf.ai77.g1.presentation.bean;


import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import fr.afcepf.ai77.g1.facade.DTOFactory;
import fr.afcepf.ai77.g1.metiers.dto.SessionDTO;
import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesSessionDTO;

public class ConnectionBean {

	
	private String login;
	private String mdp; 
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String pLogin) {
		login = pLogin;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String pMdp) {
		mdp = pMdp;
	}
	
	@Override
	public String toString() {
		return "ConnectionBean [login=" + login + ", mdp=" + mdp + "]";
	} 
	
	public String connecter(){
		IDonneesSessionDTO donneesSession = DTOFactory.getIDonneesSessionDTO();
		
		SessionDTO session = donneesSession.getSessionDTO(login, mdp);
		
		if (session==null) {
			System.out.println("login failed");
			return "Failure";
		}else{
			System.out.println("login success");
			return "OK";	
		}
	}
	
}
