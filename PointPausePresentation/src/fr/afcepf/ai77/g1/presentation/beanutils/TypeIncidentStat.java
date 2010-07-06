package fr.afcepf.ai77.g1.presentation.beanutils;

public class TypeIncidentStat {
	
	private Integer combien;
	private Integer codeProbleme;
	private String libelleProbleme;
	
	
	public Integer getCombien() {
		return combien;
	}
	public void setCombien(Integer combien) {
		this.combien = combien;
	}
	public Integer getCodeProbleme() {
		return codeProbleme;
	}
	public void setCodeProbleme(Integer codeProbleme) {
		this.codeProbleme = codeProbleme;
	}
	public String getLibelleProbleme() {
		return libelleProbleme;
	}
	public void setLibelleProbleme(String libelleProbleme) {
		this.libelleProbleme = libelleProbleme;
	}
	
	
	public TypeIncidentStat(Integer combien, Integer codeProbleme,
			String libelleProbleme) {
		super();
		this.combien = combien;
		this.codeProbleme = codeProbleme;
		this.libelleProbleme = libelleProbleme;
	}
	
	public TypeIncidentStat(){
		combien=0;
	}
	


	public boolean isMe(Integer codeProbleme){
		return (this.codeProbleme==codeProbleme);
	}
	
}
