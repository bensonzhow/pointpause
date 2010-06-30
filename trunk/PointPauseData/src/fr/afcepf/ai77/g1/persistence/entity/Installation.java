package fr.afcepf.ai77.g1.persistence.entity;

import java.util.Date;

public class Installation {
	private Integer numero;
	//private
	private SiteClient site;
	private Date dateDebut;
	private Date dateFin;
	
	
	
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public SiteClient getSite() {
		return site;
	}
	public void setSite(SiteClient site) {
		this.site = site;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	
	
	@Override
	public String toString() {
		return "Installation [numero=" + numero + ", site=" + site
				+ ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + "]";
	}
	
	
}
