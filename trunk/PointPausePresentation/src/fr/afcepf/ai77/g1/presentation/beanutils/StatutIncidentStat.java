package fr.afcepf.ai77.g1.presentation.beanutils;

public class StatutIncidentStat {
	private Integer intStatut;
	private String libelleStatut;
	private Integer combien;
	
	
	public Integer getIntStatut() {
		return intStatut;
	}
	public void setIntStatut(Integer intStatut) {
		this.intStatut = intStatut;
	}
	public String getLibelleStatut() {
		return libelleStatut;
	}
	public void setLibelleStatut(String libelleStatut) {
		this.libelleStatut = libelleStatut;
	}
	public Integer getCombien() {
		return combien;
	}
	public void setCombien(Integer combien) {
		this.combien = combien;
	}
	public StatutIncidentStat(Integer combien, Integer intStatut, String libelleStatut
			) {
		super();
		this.intStatut = intStatut;
		this.libelleStatut = libelleStatut;
		this.combien = combien;
	}
	
	public StatutIncidentStat(){
		combien=0;
	}
	
	public boolean isMe(int codeStatut){
		return (getIntStatut()==codeStatut);
	}
}
