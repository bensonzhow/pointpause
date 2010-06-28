package fr.afcepf.ai77.g1.metiers.dto;

import java.io.Serializable;

public class SessionDTO implements Serializable{
	
	private int numeroClient;
	private String nom;
	private String login;
	private String pass;
	private String lang;
	
	
	public int getNumeroClient() {
		return numeroClient;
	}
	public void setNumeroClient(int numeroClient) {
		this.numeroClient = numeroClient;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
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
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	
	
	@Override
	public String toString() {
		return "SessionDTO [numeroClient=" + numeroClient + ", nom=" + nom
				+ ", login=" + login + ", pass=" + pass + ", lang=" + lang
				+ "]";
	}
	
	
}
