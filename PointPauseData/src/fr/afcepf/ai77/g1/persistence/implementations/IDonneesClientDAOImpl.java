package fr.afcepf.ai77.g1.persistence.implementations;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.afcepf.ai77.g1.persistence.dao.ClientDAO;
import fr.afcepf.ai77.g1.persistence.hibernateutils.HibernateUtil;
import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesClientDAO;

public class IDonneesClientDAOImpl implements IDonneesClientDAO {
	@Override
	public ClientDAO getClientByNumero(int numero) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.currentSession();
		
		Transaction tx = session.beginTransaction();		
		
		ClientDAO client = (ClientDAO)session.get(ClientDAO.class, 1);
		
		System.out.println(client.toString());

		tx.commit();
		HibernateUtil.closeSession();
		
		
		return client;
	}

}
