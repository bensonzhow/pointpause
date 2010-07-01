package fr.afcepf.ai77.g1.persistence.interfaces;

import fr.afcepf.ai77.g1.persistence.entity.Employe;

public interface IDonneesEmployeDAO {
	boolean insertEmploye(Employe e);
	Employe getEmployeByNum(int id);
}
