package fr.afcepf.ai77.g1.persistence.entity;

import java.util.HashSet;
import java.util.Set;

public class Client {
	
	private Integer numero=null;
	private String nom;
	private String codeSIRET;
	private String nomContact;
	private String telephone;
	private String mail;
	private String login;
	private String pass;
	private String langue;
	private Set<Contrat> listeContrats = new HashSet<Contrat>();
	private Set<SiteClient> listeSitesClients = new HashSet<SiteClient>();
	private Employe employe;
	private Set<Incident> listeIncidents = new HashSet<Incident>();
	
	
	
	public Set<Contrat> getListeContrats() {
		return listeContrats;
	}
	public void setListeContrats(Set<Contrat> listeContrats) {
		this.listeContrats = listeContrats;
	}
	public Set<SiteClient> getListeSitesClients() {
		return listeSitesClients;
	}
	public void setListeSitesClients(Set<SiteClient> listeSitesClients) {
		this.listeSitesClients = listeSitesClients;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public Set<Incident> getListeIncidents() {
		return listeIncidents;
	}
	public void setListeIncidents(Set<Incident> listeIncidents) {
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
		return "Client [numero=" + numero + ", nom=" + nom + ", codeSIRET="
				+ codeSIRET + ", nomContact=" + nomContact + ", telephone="
				+ telephone + ", mail=" + mail + ", login=" + login + ", pass="
				+ pass + ", langue=" + langue + ", listeContrats="
				+ listeContrats + ", listeSitesClients=" + listeSitesClients
				+ ", employe=" + employe + ", listeIncidents=" + listeIncidents
				+ "]";
	}
	public Client( String nom, String codeSIRET,
			String nomContact, String telephone, String mail, String login,
			String pass, String langue, 
			Employe employe
			) {
		super();
		this.nom = nom;
		this.codeSIRET = codeSIRET;
		this.nomContact = nomContact;
		this.telephone = telephone;
		this.mail = mail;
		this.login = login;
		this.pass = pass;
		this.langue = langue;
		this.employe = employe;
	}
	
	public Client(){
		
	}
	
}
