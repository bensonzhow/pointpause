package fr.afcepf.ai77.g1.persistence.entity;

import java.util.HashSet;
import java.util.Set;

public class Bouquet {
	private Integer codeBouquet;
	//private Formule formule;
	//private ModeleAutomate modeleAutomate;
	private Contrat contrat;
	private Integer quantite;

	
	private Set<Installation> historiqueInstallation = new HashSet<Installation>();

	public Integer getCodeBouquet() {
		return codeBouquet;
	}

	public void setCodeBouquet(Integer codebouquet) {
		this.codeBouquet = codebouquet;
	}

	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public Set<Installation> getHistoriqueInstallation() {
		return historiqueInstallation;
	}

	public void setHistoriqueInstallation(Set<Installation> historiqueInstallation) {
		this.historiqueInstallation = historiqueInstallation;
	}

	@Override
	public String toString() {
		return "Bouquet [codebouquet=" + codeBouquet + ", contrat=" + contrat
				+ ", quantite=" + quantite + ", historiqueInstallation="
				+ historiqueInstallation + "]";
	}
	
	
	
}
