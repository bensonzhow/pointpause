package fr.afcepf.ai77.g1.persistence.interfaces;

import fr.afcepf.ai77.g1.persistence.entity.Bouquet;
import fr.afcepf.ai77.g1.persistence.entity.Contrat;
import fr.afcepf.ai77.g1.persistence.entity.LoadingPolicy;

public interface IDonneesBouquetDAO {

	Bouquet getBouquetByNumero(int bouquetID);
	Bouquet getBouquetByNumero(int bouquetID, LoadingPolicy policies);
	
	
	//update
	boolean updateBouquet(Bouquet bouquet);
}
