package fr.afcepf.ai77.g1.persistence.implementations;

import java.util.List;

import fr.afcepf.ai77.g1.persistence.dao.ExampleDAO;
import fr.afcepf.ai77.g1.persistence.interfaces.IExampleDAO;


public class IExampleDAOImpl implements IExampleDAO {

	@Override
	public ExampleDAO getExampleDAOByNumero(int numero_DAO) {
		// TODO Auto-generated method stub
		ExampleDAO ex = new ExampleDAO();
		ex.setNumero(numero_DAO);
		
		return ex;
	}

	@Override
	public boolean updateExampleDAO(ExampleDAO DAO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createExampleDAO(ExampleDAO DAO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeExampleDAO(ExampleDAO DAO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ExampleDAO> getAllExampleDAOFromContrat(int numero_contrat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExampleDAO> getAllExampleDAOWhereValeurContratSuperieurA(
			float valeur_minimum_contrat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExampleDAO> getExampleDAOByClient(int numero_client) {
		// TODO Auto-generated method stub
		return null;
	}

}
