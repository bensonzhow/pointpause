package fr.afcepf.ai77.g1.metiers.dto;

import java.util.HashSet;
import java.util.Set;


import fr.afcepf.ai77.g1.persistence.entity.Installation;

public class BouquetDTO {
	private Integer codeBouquet=null;
	private Integer codeFormule;
	private Integer codemodeleAutomate;
	private Integer quantite;
	private Set<Installation> historiqueInstallations = new HashSet<Installation>();

	public Integer getCodeBouquet() {
		return codeBouquet;
	}

	public void setCodeBouquet(Integer codebouquet) {
		this.codeBouquet = codebouquet;
	}

	
	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	/**
	 * @param codeFormule the codeFormule to set
	 */
	public void setCodeFormule(Integer codeFormule) {
		this.codeFormule = codeFormule;
	}

	/**
	 * @param historiqueInstallations the historiqueInstallations to set
	 */
	public void setHistoriqueInstallations(Set<Installation> historiqueInstallations) {
		this.historiqueInstallations = historiqueInstallations;
	}

	/**
	 * @return the historiqueInstallations
	 */
	public Set<Installation> getHistoriqueInstallations() {
		return historiqueInstallations;
	}

	/**
	 * @return the codeFormule
	 */
	public Integer getCodeFormule() {
		return codeFormule;
	}

	/**
	 * @param codemodeleAutomate the codemodeleAutomate to set
	 */
	public void setCodemodeleAutomate(Integer codemodeleAutomate) {
		this.codemodeleAutomate = codemodeleAutomate;
	}

	/**
	 * @return the codemodeleAutomate
	 */
	public Integer getCodemodeleAutomate() {
		return codemodeleAutomate;
	}


	
}
