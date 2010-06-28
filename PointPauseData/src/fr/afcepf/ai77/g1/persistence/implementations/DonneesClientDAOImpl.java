package fr.afcepf.ai77.g1.persistence.implementations;



import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import fr.afcepf.ai77.g1.persistence.entity.Client;
import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesClientDAO;

public class DonneesClientDAOImpl implements IDonneesClientDAO {

	private HibernateTemplate hibernateTemplate = null;

	public void setSessionFactory(SessionFactory sf) {
		hibernateTemplate = new HibernateTemplate(sf);
	}

	
	
	@Override
	public Client getClientByNumero(int numero) {
		// TODO Auto-generated method stub
		try {
			Client client = hibernateTemplate.get(Client.class, numero);

			return client;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
