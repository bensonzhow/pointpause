package fr.afcepf.ai77.g1.persistence.implementations;

import java.util.List;

import fr.afcepf.ai77.g1.persistence.entity.Example;
import fr.afcepf.ai77.g1.persistence.interfaces.IExampleDAO;


public class IExampleDAOImpl implements IExampleDAO {

	@Override
	public Example getExampleDAOByNumero(int numero_DAO) {
		// TODO Auto-generated method stub
		Example ex = new Example();
		ex.setNumero(numero_DAO);
		
		return ex;
	}

	@Override
	public boolean updateExampleDAO(Example DAO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createExampleDAO(Example DAO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeExampleDAO(Example DAO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Example> getAllExampleDAOFromContrat(int numero_contrat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Example> getAllExampleDAOWhereValeurContratSuperieurA(
			float valeur_minimum_contrat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Example> getExampleDAOByClient(int numero_client) {
		// TODO Auto-generated method stub
		return null;
	}

}
