package fr.afcepf.ai77.g1.persistence.interfaces;

import java.util.List;

import fr.afcepf.ai77.g1.persistence.entity.Formule;

public interface IDonneesContratDAO {
	List<Formule> getAllFormule();
}