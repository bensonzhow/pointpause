package fr.afcepf.ai77.g1.persistence.implementations;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import fr.afcepf.ai77.g1.persistence.entity.Formule;
import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesContratDAO;

public class DonneesContratDAOImpl implements IDonneesContratDAO {
	
	private HibernateTemplate hibernateTemplate = null;

	public void setSessionFactory(SessionFactory sf) {
		hibernateTemplate = new HibernateTemplate(sf);
	}
	@Override
	public List<Formule> getAllFormule() {
		List<Formule> tteFormules = hibernateTemplate.find("from Formule");
		return tteFormules;
	}

}
