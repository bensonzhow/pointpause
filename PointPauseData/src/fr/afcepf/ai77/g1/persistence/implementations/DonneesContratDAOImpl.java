package fr.afcepf.ai77.g1.persistence.implementations;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import fr.afcepf.ai77.g1.metiers.dto.ContratDTO;
import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesContratDTO;
import fr.afcepf.ai77.g1.persistence.entity.Bouquet;

import fr.afcepf.ai77.g1.persistence.entity.Contrat;
import fr.afcepf.ai77.g1.persistence.entity.Formule;
import fr.afcepf.ai77.g1.persistence.entity.Installation;
import fr.afcepf.ai77.g1.persistence.entity.LoadingPolicy;
import fr.afcepf.ai77.g1.persistence.entity.TypeAutomate;
import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesContratDAO;

public class DonneesContratDAOImpl implements IDonneesContratDAO {

	private HibernateTemplate hibernateTemplate = null;

	public void setSessionFactory(SessionFactory sf) {
		hibernateTemplate = new HibernateTemplate(sf);
	}

	public List getNumMachineByNumContrat(int numContrat) {
		List listeMachine = null;
		try {
			Contrat c = getContratById(numContrat);
			DetachedCriteria crit = DetachedCriteria
					.forClass(TypeAutomate.class);
			crit.add(Restrictions.eq("contrat", c));
			listeMachine = hibernateTemplate.findByCriteria(crit);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return listeMachine;
		}

	}

	@Override
	public Contrat getContratById(Integer id) {
		// TODO Auto-generated method stub
		Contrat c = null;
		try {
			c = hibernateTemplate.get(Contrat.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return c;
		}

	}
	
	/**
	 * 
	 * Raaahlala ce qu'il faut pas faire, p#%*n de m$��e !
	 * 
	 */
	@Override
	public Contrat getContratById(final Integer id, final LoadingPolicy policies) {
		// TODO Auto-generated method stub
		Contrat c = null;
		try {

			c = hibernateTemplate.execute(new HibernateCallback<Contrat>() {
				@Override
				public Contrat doInHibernate(Session session)
						throws HibernateException, SQLException {
					// TODO Auto-generated method stub
					Contrat tempc = (Contrat) session.get(Contrat.class, id);

					if (policies != null) {
						Hibernate.initialize(tempc);
						for (String policy : policies.getPolicies()) {
							if (policy.equals("bouquet")) {
								Hibernate.initialize(tempc.getListeBouquets());
								for(Bouquet bouquet : tempc.getListeBouquets()){
									Hibernate.initialize(bouquet.getFormule());
									Hibernate.initialize(bouquet.getModeleAutomate());
								}
								continue;
							}
						}

					}

					return tempc;
				}
			});

		} catch (Exception e) {
			e.printStackTrace();
			c = null;
		} finally {
			return c;
		}
	}

	@Override
	public List<Formule> getAllFormule() {
		List<Formule> tteFormules = hibernateTemplate.find("from Formule");
		return tteFormules;
	}

	@Override
	public boolean updateContrat(Contrat contrat) {
		// TODO Auto-generated method stub
		Boolean result = true;
		try {
			hibernateTemplate.saveOrUpdate(contrat);
		} catch (HibernateException e) {
			e.printStackTrace();
			result = false;
		} finally {
			return result;
		}
	}

	@Override
	public Contrat getContratByNumInstallation(int numInstallation) {
		// TODO Auto-generated method stub
		Contrat contrat = null;
		List<Contrat> bob = null;
		try {
			DetachedCriteria crit = DetachedCriteria.forClass(Contrat.class);

			crit = crit.createCriteria("listeBouquets",
					DetachedCriteria.INNER_JOIN).createCriteria(
					"historiqueInstallations", DetachedCriteria.INNER_JOIN)
					.add(
							Restrictions.eq("numero", new Integer(
									numInstallation)));

			bob = hibernateTemplate.findByCriteria(crit);

			if ((bob != null) && (bob.size() > 0))
				contrat = bob.get(0);

			return contrat;

		} catch (Exception e) {
			e.printStackTrace();
			contrat = null;
		} finally {
			return contrat;
		}
	}

	@Override
	public List<Contrat> getListContratFromListNumInstallation(
			final List<Integer> listInstalls) {
		// TODO Auto-generated method stub
		List<Contrat> listContrat = null;
		try {

			listContrat = hibernateTemplate
					.execute(new HibernateCallback<List<Contrat>>() {

						@Override
						public List<Contrat> doInHibernate(Session session)
								throws HibernateException, SQLException {
							// TODO Auto-generated method stub

							List<Contrat> list = new Vector<Contrat>();
							try {

								for (Integer numInstall : listInstalls) {
									Criteria crit = session
											.createCriteria(Contrat.class);

									crit = crit.createCriteria("listeBouquets",
											Criteria.INNER_JOIN)
											.createCriteria(
													"historiqueInstallations",
													Criteria.INNER_JOIN).add(
													Restrictions.eq("numero",
															numInstall));

									list.add((Contrat) crit.uniqueResult());

								}
							} catch (Exception e) {
								e.printStackTrace();
								list = null;
							} finally {
								return list;
							}
						}

					});

		} catch (Exception e) {
			e.printStackTrace();
			listContrat = null;
		} finally {
			return listContrat;
		}

	}

	@Override
	@SuppressWarnings("unchecked")
	public Integer insertContrat(Contrat contrat) {
		// pas oublier ins�rer bouquet aussi
		// mettre un site client aussi pour la localisation...

		hibernateTemplate.save(contrat);
		List<Integer> maxNumero = (List<Integer>) hibernateTemplate
				.find("SELECT max(numero) from Contrat");
		int numero = maxNumero.get(0);
		return numero;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Integer insertBouquet(Bouquet bouquet) {
		hibernateTemplate.save(bouquet);
		List<Integer> maxNumero = (List<Integer>) hibernateTemplate
				.find("SELECT max(codeBouquet) from Bouquet");
		int numero = maxNumero.get(0);
		return numero;
	}

	@SuppressWarnings( { "null", "unchecked" })
	@Override
	public List<Integer> listeNumMachineByNumContrat(int numContrat) {
		DetachedCriteria crit = DetachedCriteria.forClass(Installation.class);
		crit = crit.createCriteria("historiqueBouquet",
				DetachedCriteria.INNER_JOIN).createCriteria("contrat",
				DetachedCriteria.INNER_JOIN).add(
				Restrictions.eq("numero", numContrat));

		List<Installation> listeInstallation = hibernateTemplate
				.findByCriteria(crit);
		List<Integer> listeNumMachine = new ArrayList<Integer>();
		for (Installation i : listeInstallation) {
			listeNumMachine.add(i.getNumero());
		}
		return listeNumMachine;
	}
	
//	static XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("SpringConfig.xml"));
//	
//	public static void main(String[] args) {
//		IDonneesContratDTO donneesContrat = (IDonneesContratDTO) factory.getBean("IDonneesContratDTO");
//		System.out.println(donneesContrat.getListeMachineByContrat(10));
//	}

	@Override
	public List<Contrat> getAllContratBouquetInstallByClient(final int numClient) {
		List<Contrat> listContrat = null;
		try {

			listContrat = hibernateTemplate
					.execute(new HibernateCallback<List<Contrat>>() {
						@Override
						public List<Contrat> doInHibernate(Session session)
								throws HibernateException, SQLException {
							// TODO Auto-generated method stub
							List<Contrat> liste = null;
							try {

								Criteria crit = session
										.createCriteria(Contrat.class);

								crit = crit.createCriteria("client",
										Criteria.INNER_JOIN).add(
										Restrictions.eq("numero", numClient));

								liste = crit.list();

								// initiliser le bousin
								for (Contrat contrat : liste) {
									Hibernate.initialize(contrat);
									Hibernate.initialize(contrat
											.getListeBouquets());
									for (Bouquet bouquet : contrat
											.getListeBouquets()) {
										Hibernate.initialize(bouquet);
										Hibernate.initialize(bouquet
												.getFormule());
										Hibernate.initialize(bouquet
												.getModeleAutomate());
										Hibernate.initialize(bouquet
												.getHistoriqueInstallations());
									}

								}
							} catch (Exception ex) {
								ex.printStackTrace();
								liste = null;
							} finally {
								return liste;
							}

						}
					});

		} catch (Exception e) {
			e.printStackTrace();
			listContrat = null;
		} finally {
			return listContrat;
		}
	}

	/**
	 * pour le tableau de bord les 7 derniers contrats � terminer !!!
	 */
	@Override
	public List<Contrat> getLastContratsBouquetInstallByClient(
			final int numClient) {

		List<Contrat> listLastContratFlagguesParClient = hibernateTemplate
				.execute(new HibernateCallback<List<Contrat>>() {
					@Override
					public List<Contrat> doInHibernate(Session session)
							throws HibernateException, SQLException {
						List<Contrat> liste;
						Criteria crit = session.createCriteria(Contrat.class);
						crit = crit.add(Restrictions.eq("flag", true)).addOrder(
								Order.desc("dateDebut")).createCriteria(
								"client", Criteria.INNER_JOIN).add(
								Restrictions.eq("numero", numClient))
								.setMaxResults(7);
						// là on a tous les contrats flaggués d'un client
						liste = crit.list();
						
						int reste = 7 - liste.size();
						
						if (reste>0){
							List<Contrat> listNonFlag;
							crit = session.createCriteria(Contrat.class);
							crit = crit.add(Restrictions.eq("flag", false)).addOrder(
									Order.desc("dateDebut")).createCriteria(
									"client", Criteria.INNER_JOIN).add(
									Restrictions.eq("numero", numClient))
									.setMaxResults(reste);
							// là on a tous les contrats flaggués d'un client
							listNonFlag = crit.list();	
							liste.addAll(listNonFlag);
							
							
						}
						for (Contrat contrat : liste) {
							Hibernate.initialize(contrat);
							Hibernate.initialize(contrat
									.getListeBouquets());
							for (Bouquet bouquet : contrat
									.getListeBouquets()) {
								Hibernate.initialize(bouquet);
								Hibernate.initialize(bouquet
										.getFormule());
								Hibernate.initialize(bouquet
										.getModeleAutomate());
								Hibernate.initialize(bouquet
										.getHistoriqueInstallations());
							}
					}
						return liste;
				} });
		// si le client a + que 7 contrats flaggu�s on coupe la liste � 7 pour
		// le tableau de bord et on la renverra
		// if (listContratFlagguesParClient.size()>=7){
		// liste7derniersContratsFlag = listContratFlagguesParClient.subList(0,
		// 7);
		// }

		return listLastContratFlagguesParClient;
	}
	// else

}
