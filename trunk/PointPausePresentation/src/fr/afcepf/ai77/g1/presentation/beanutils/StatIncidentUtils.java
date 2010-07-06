package fr.afcepf.ai77.g1.presentation.beanutils;

import java.util.List;
import java.util.Vector;

import fr.afcepf.ai77.g1.metiers.dto.IncidentDTO;
import fr.afcepf.ai77.g1.metiers.dto.StatutIncidentDTO;

public class StatIncidentUtils {

	public static List<TypeIncidentStat> getStatsTypeIncident(List<IncidentDTO> liste){
		List<TypeIncidentStat> listeStats = new Vector<TypeIncidentStat>();
		
		//calculer les stats;
		for (IncidentDTO incident : liste){
			try{
				StatutIncidentDTO statut = incident.getLastStatutDTO();
				
				if (statut==null) continue;
				
				//si l'incident n'est pas de statut terminé, on doit 
				//rajouter le type de probleme.
				if (statut.getIntStatut()!=3){
					
					//rechercher si la stat existe déjà
					TypeIncidentStat stat = null;
					for (TypeIncidentStat incStat : listeStats){
						if (incStat.isMe(incident.getNumTypePb())) stat=incStat;
					}
					
					//si elle existe déjà on a juste à l'incrémenter, sinon on crée un nouveau
					if (stat!=null){
						stat.setCombien(stat.getCombien()+1);
					}
					else{
						stat=new TypeIncidentStat(1,incident.getNumTypePb(),incident.getLibelTypePb());
						listeStats.add(stat);
					}
					
				}
								
			}catch(Exception e){
				//ignore
			}
		}
		
		
		return listeStats;
	}
	
	
	public static List<StatutIncidentStat> getStatsStatutIncident(List<IncidentDTO> liste){
		List<StatutIncidentStat> listeStats = new Vector<StatutIncidentStat>();
		
		//calculer les stats;
		for (IncidentDTO incident : liste){
			try{
				StatutIncidentDTO statut = incident.getLastStatutDTO();
				
				if (statut==null) continue;
				
				//si l'incident n'est pas de statut terminé, on doit 
				//rajouter le type de probleme.
				if (statut.getIntStatut()!=3){
					
					//rechercher si la stat existe déjà
					StatutIncidentStat stat = null;
					for (StatutIncidentStat incStat : listeStats){
						if (incStat.isMe(statut.getIntStatut())) stat=incStat;
					}
					
					//si elle existe déjà on a juste à l'incrémenter, sinon on crée un nouveau
					if (stat!=null){
						stat.setCombien(stat.getCombien()+1);
					}
					else{
						stat=new StatutIncidentStat(1,statut.getIntStatut(),statut.getStatut());
						listeStats.add(stat);
					}
					
				}
								
			}catch(Exception e){
				//ignore
			}
		}
		
		
		return listeStats;
	}	
	
	
}
