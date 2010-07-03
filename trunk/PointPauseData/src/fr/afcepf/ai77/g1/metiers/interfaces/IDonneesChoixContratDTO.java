package fr.afcepf.ai77.g1.metiers.interfaces;

import java.util.List;

import fr.afcepf.ai77.g1.persistence.entity.Formule;
import fr.afcepf.ai77.g1.persistence.entity.ModelAutomate;

public interface IDonneesChoixContratDTO {
	public List<Formule> getAllGeneral();
	public List<ModelAutomate> getAllMachines();
}
