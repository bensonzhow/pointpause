package fr.afcepf.ai77.g1.persistence.implementations;



import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
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
	
	
	@Override
	public Client getClientBySession(String login, String password){
		Client client=null;
		try {
			org.hibernate.Session session =hibernateTemplate.getSessionFactory().getCurrentSession();
			
			if (session.isOpen()==false ) System.out.println("connection hibernate fermée !"); 
				
			Transaction tx = session.beginTransaction();	
		
			Criteria crit = session.createCriteria(Client.class);
			
			crit.add(Restrictions.eq("login", login));
			crit.add(Restrictions.eq("pass", password));
			
			client= (Client) crit.uniqueResult();
			
			
			tx.commit();

			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			return client;
		}
		
	}

}
