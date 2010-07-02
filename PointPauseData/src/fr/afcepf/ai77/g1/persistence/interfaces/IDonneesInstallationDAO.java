package fr.afcepf.ai77.g1.persistence.interfaces;

import fr.afcepf.ai77.g1.persistence.entity.Installation;

public interface IDonneesInstallationDAO {

	boolean deleteInstallation(int numInstall);
	boolean deleteInstallation(Installation install);
	
}
