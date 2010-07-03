package fr.afcepf.ai77.g1.metiers.dto;

import java.io.Serializable;

public class TypePbDTO implements Serializable{
	
	private Integer numTypePb;
	private String libelleTypePb;
	
	public Integer getNumTypePb() {
		return numTypePb;
	}
	public void setNumTypePb(Integer numTypePb) {
		this.numTypePb = numTypePb;
	}
	public String getLibelleTypePb() {
		return libelleTypePb;
	}
	public void setLibelleTypePb(String libelleTypePb) {
		this.libelleTypePb = libelleTypePb;
	}
	
	@Override
	public String toString() {
		return "TypePbDTO [libelleTypePb=" + libelleTypePb + ", numTypePb="
				+ numTypePb + "]";
	}
	
	
	
}
