package fr.afcepf.ai77.g1.persistence.implementations;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
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
			DetachedCriteria crit = DetachedCriteria.forClass(Client.class);
			
			crit.add(Restrictions.eq("login", login));
			crit.add(Restrictions.eq("pass", password));
			List<Client> liste = hibernateTemplate.findByCriteria(crit);
			
			
			if ((liste==null)||(liste.size()==0)) return null;
			client= liste.get(0);
			

			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			return client;
		}
		
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see fr.afcepf.ai77.g1.persistence.interfaces.IDonneesClientDAO#insertClient(fr.afcepf.ai77.g1.persistence.entity.Client)
	 * si l'insertion ne leve pas d'exception alors c'est que tout s'est bien pass� et on return true. Si exception, on retourne false
	 */
	
	@Override
	public boolean insertClient(Client c) {
		// TODO Auto-generated method stub
		try{
			hibernateTemplate.save(c);
			return true;
		}catch(Exception e){
			e.printStackTrace();return false;
		}
		
	}

}