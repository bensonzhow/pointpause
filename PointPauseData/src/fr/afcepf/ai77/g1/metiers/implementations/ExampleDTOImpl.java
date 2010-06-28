package fr.afcepf.ai77.g1.metiers.implementations;

import java.util.List;

import fr.afcepf.ai77.g1.metiers.dto.ExampleDTO;
import fr.afcepf.ai77.g1.metiers.interfaces.IExampleDTO;

public class ExampleDTOImpl implements IExampleDTO {

	@Override
	public ExampleDTO getExampleDTOByNumero(int numero_dto) {
		// TODO Auto-generated method stub
		ExampleDTO newdto = new ExampleDTO();
		newdto.setNumero(numero_dto);
		return newdto;
	}

	@Override
	public boolean updateExampleDTO(ExampleDTO dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createExampleDTO(ExampleDTO dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeExampleDTO(ExampleDTO dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ExampleDTO> getAllExampleDTOFromContrat(int numero_contrat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExampleDTO> getAllExampleDTOWhereValeurContratSuperieurA(
			float valeur_minimum_contrat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExampleDTO> getExampleDTOByClient(int numero_client) {
		// TODO Auto-generated method stub
		return null;
	}

}
