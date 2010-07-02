package fr.afcepf.ai77.g1.metiers.interfaces;

import fr.afcepf.ai77.g1.metiers.dto.TypePbDTO;
import fr.afcepf.ai77.g1.persistence.entity.TypePb;

public interface IDonneesTypePbDTO {

	TypePbDTO getTypePbByNum(int numTypePb);
	Integer insertTypePb(TypePb typePb);
}
