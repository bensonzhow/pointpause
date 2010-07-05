package fr.afcepf.ai77.g1.persistence.implementations;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;

import fr.afcepf.ai77.g1.persistence.entity.Client;
import fr.afcepf.ai77.g1.persistence.entity.Formule;
import fr.afcepf.ai77.g1.persistence.entity.ModeleAutomate;
import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesChoixContratDAO;

public class DonneesChoixContratDAOImpl implements IDonneesChoixContratDAO {
 
	
	private HibernateTemplate hibernateTemplate = null;

	public void setSessionFactory(SessionFactory sf) {
		hibernateTemplate = new HibernateTemplate(sf);
	}
	
	//retourne toutes les formules générales donc pas celles rattachées à un client particulier
	@Override
	public List<Formule> getAllGeneralFormules() {
		DetachedCriteria crit = DetachedCriteria.forClass(Formule.class);
		crit.add(Restrictions.isNull("client"));
		
		List<Formule> ttesformulesGeneral = hibernateTemplate.findByCriteria(crit);
		return ttesformulesGeneral;
	}
	@Override
	public Formule getFormuleById(Integer id) {
		Formule formule = hibernateTemplate.get(Formule.class, id);
		return formule;
	}
	
	@Override
	public List<ModeleAutomate> getAllAutomates() {
	List<ModeleAutomate> ttAutomates = hibernateTemplate.find("from ModeleAutomate");
		return ttAutomates;
	}

	@Override
	public ModeleAutomate getAutomateById(Integer id) {
		ModeleAutomate automate = hibernateTemplate.get(ModeleAutomate.class, id);
		return automate;
	}
}
