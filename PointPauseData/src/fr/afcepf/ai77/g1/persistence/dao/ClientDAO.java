package fr.afcepf.ai77.g1.persistence.dao;

import java.util.HashSet;
import java.util.Set;

public class ClientDAO {
	
	private Integer numero;
	private String nom;
	private String codeSIRET;
	private String nomContact;
	private String telephone;
	private String mail;
	private String login;
	private String pass;
	private String langue;
	private Set<ContratDAO> listeContrats = new HashSet<ContratDAO>();
	private Set<SiteClientDAO> listeSitesClients = new HashSet<SiteClientDAO>();
	private EmployeDAO employe;
	private Set<IncidentDAO> listeIncidents = new HashSet<IncidentDAO>();
	
	
	
	public Set<ContratDAO> getListeContrats() {
		return listeContrats;
	}
	public void setListeContrats(Set<ContratDAO> listeContrats) {
		this.listeContrats = listeContrats;
	}
	public Set<SiteClientDAO> getListeSitesClients() {
		return listeSitesClients;
	}
	public void setListeSitesClients(Set<SiteClientDAO> listeSitesClients) {
		this.listeSitesClients = listeSitesClients;
	}
	public EmployeDAO getEmploye() {
		return employe;
	}
	public void setEmploye(EmployeDAO employe) {
		this.employe = employe;
	}
	public Set<IncidentDAO> getListeIncidents() {
		return listeIncidents;
	}
	public void setListeIncidents(Set<IncidentDAO> listeIncidents) {
		this.listeIncidents = listeIncidents;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCodeSIRET() {
		return codeSIRET;
	}
	public void setCodeSIRET(String codeSIRET) {
		this.codeSIRET = codeSIRET;
	}
	public String getNomContact() {
		return nomContact;
	}
	public void setNomContact(String nomContact) {
		this.nomContact = nomContact;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getLangue() {
		return langue;
	}
	public void setLangue(String langue) {
		this.langue = langue;
	}
	
	
	@Override
	public String toString() {
		return "ClientDAO [numero=" + numero + ", nom=" + nom + ", codeSIRET="
				+ codeSIRET + ", nomContact=" + nomContact + ", telephone="
				+ telephone + ", mail=" + mail + ", login=" + login + ", pass="
				+ pass + ", langue=" + langue + ", listeContrats="
				+ listeContrats + ", listeSitesClients=" + listeSitesClients
				+ ", employe=" + employe + ", listeIncidents=" + listeIncidents
				+ "]";
	}
	
	
	
}
