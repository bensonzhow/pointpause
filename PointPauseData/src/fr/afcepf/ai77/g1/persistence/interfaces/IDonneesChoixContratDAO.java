package fr.afcepf.ai77.g1.persistence.interfaces;

import java.util.List;

import fr.afcepf.ai77.g1.persistence.entity.Formule;
import fr.afcepf.ai77.g1.persistence.entity.ModeleAutomate;

public interface IDonneesChoixContratDAO {
	public List<Formule> getAllGeneralFormules();
	public List<ModeleAutomate> getAllAutomates();
	public Formule getFormuleById(Integer id);
	public ModeleAutomate getAutomateById(Integer id);
}
