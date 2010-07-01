package fr.afcepf.ai77.g1.metiers.dto;
import java.io.Serializable;
import java.util.List;

import fr.afcepf.ai77.g1.persistence.entity.Formule;
public class ContratDTO {
 private List<Formule> formule;

public List<Formule> getFormule() {
	return formule;
}

public void setFormule(List<Formule> pFormule) {
	formule = pFormule;
}

}
