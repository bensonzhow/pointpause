package fr.afcepf.ai77.g1.persistence.implementations;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;

import fr.afcepf.ai77.g1.persistence.entity.Incident;
import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesIncidentDAO;

public class DonneesIncidentDAOImpl implements IDonneesIncidentDAO {

	private HibernateTemplate hibernateTemplate = null;

	public void setSessionFactory(SessionFactory sf) {
		hibernateTemplate = new HibernateTemplate(sf);
	}
	
	@Override
	public List<Incident> getIncidentByContrat(int numContrat) {
		return null;
	}

	@Override
	public Incident getIncidentByNumero(int numero) {
		try {
			Incident incident = hibernateTemplate.get(Incident.class, numero);
			return incident;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}
