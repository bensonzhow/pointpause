package fr.afcepf.ai77.g1.persistence.interfaces;

import java.util.List;

import fr.afcepf.ai77.g1.persistence.entity.TypePb;

public interface IDonneesTypePbDAO {

	TypePb getTypePbByNumero(int numero);
	Integer insertTypePb(TypePb typePb);
	List<String> getTypePb();
}
