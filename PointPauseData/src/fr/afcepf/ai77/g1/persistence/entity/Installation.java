package fr.afcepf.ai77.g1.persistence.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Installation {
	private Integer numero=null;
	//private
	private SiteClient site;
	private Date dateDebut;
	private Date dateFin;
	private Set<Incident> listeIncidents = new HashSet<Incident>();
	private Set<Bouquet> historiqueBouquet = new HashSet<Bouquet>();
	
	
	
	
	public Set<Bouquet> getHistoriqueBouquet() {
		return historiqueBouquet;
	}
	public void setHistoriqueBouquet(Set<Bouquet> historiqueBouquet) {
		this.historiqueBouquet = historiqueBouquet;
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
	public Installation( SiteClient site, Date dateDebut,
			Date dateFin ) {
		super();
		this.site = site;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}
	
	public Installation(){
		
	}
}
