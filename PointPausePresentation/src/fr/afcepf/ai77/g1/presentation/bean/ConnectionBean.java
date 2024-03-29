package fr.afcepf.ai77.g1.presentation.bean;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sun.corba.se.spi.orbutil.fsm.Action;

import fr.afcepf.ai77.g1.facade.DTOFactory;
import fr.afcepf.ai77.g1.metiers.dto.SessionDTO;
import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesSessionDTO;

public class ConnectionBean {

	FacesContext context = FacesContext.getCurrentInstance();
	HttpServletRequest request = (HttpServletRequest) context
			.getExternalContext().getRequest();
	HttpSession httpSession = request.getSession(false);
	private String login;
	private String mdp;
	private Boolean inscriptionBool=false;
	private String verif;

	// private String statut;

	/*
	 * public String getStatut() { return statut; } public void setStatut(String
	 * pStatut) { statut = pStatut;}
	 */

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

	public String connecter() {
		System.out.println("connecter");
		IDonneesSessionDTO donneesSession = DTOFactory.getIDonneesSessionDTO();

		SessionDTO session = donneesSession.getSessionDTO(login, mdp);

		if (session == null) {
			System.out.println("login failed");
			httpSession.setAttribute("session", null);
			verif="mauvais identifiants";
			return "Failure";
		} else {
			System.out.println("login success");
			httpSession.setAttribute("session", session);
			return "OK";
		}
	}

	public String logOut() {
		System.out.println("logout");
		httpSession.setAttribute("session", null);
		 if(httpSession.getAttribute("session")==null)
		 return "OK";
		 else
		return "Failure";
	}
	
	public void afficherInscription(){
		System.out.println("afficherInscription");
		inscriptionBool=true;
	
	}

	/**
	 * @param inscriptionBool the inscriptionBool to set
	 */
	public void setInscriptionBool(Boolean inscriptionBool) {
		this.inscriptionBool = inscriptionBool;
	}

	/**
	 * @return the inscriptionBool
	 */
	public Boolean getInscriptionBool() {
		return inscriptionBool;
	}

	/**
	 * @param verif the verif to set
	 */
	public void setVerif(String verif) {
		this.verif = verif;
	}

	/**
	 * @return the verif
	 */
	public String getVerif() {
		return verif;
	}
	
}
