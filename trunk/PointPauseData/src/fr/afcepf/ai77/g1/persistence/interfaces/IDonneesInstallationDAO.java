package fr.afcepf.ai77.g1.persistence.interfaces;

import java.util.Set;

import fr.afcepf.ai77.g1.persistence.entity.Installation;

public interface IDonneesInstallationDAO {

	boolean deleteInstallation(int numInstall);
	boolean deleteInstallation(Installation install);
	boolean deleteInstallationGroup(Set<Installation> instalset);
	Installation getInstallation(int numInstal);
	
}
