package fr.afcepf.ai77.g1.persistence.implementations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateTemplate;

import fr.afcepf.ai77.g1.persistence.dao.ClientDAO;
import fr.afcepf.ai77.g1.persistence.hibernateutils.HibernateUtil;
import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesClientDAO;

public class DonneesClientDAOImpl implements IDonneesClientDAO {

	private HibernateTemplate hibernateTemplate = null;

	public void setSessionFactory(SessionFactory sf) {
		hibernateTemplate = new HibernateTemplate(sf);
	}

	
	
	@Override
	public ClientDAO getClientByNumero(int numero) {
		// TODO Auto-generated method stub
		try {
			ClientDAO client = hibernateTemplate.get(ClientDAO.class, numero);

			return client;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
