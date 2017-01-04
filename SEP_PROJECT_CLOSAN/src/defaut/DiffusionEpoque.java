package defaut;
import java.util.ArrayList;
import java.util.List;

import interfacePackage.AlgoDiffusion;
import interfacePackage.Capteur;

/**
 * 
 * @author Othmane
 * @author Bastien
 *
 * Implémentation de l'algorithme de diffusion par époque
 * 
 */
public class DiffusionEpoque implements AlgoDiffusion {
	
	private Capteur capteurImpl;
	private List <Canal> listCanal = new ArrayList<Canal>();
	
	/**
	 * Configuration de l'algorithme
	 */
	@Override
	public void configure() {
		
	}

	/**
	 * Exécution de l'algorithme de diffusion par époque sur tous les canals
	 */
	@Override
	public void execute() {
		for(Canal l : listCanal){
			l.update(capteurImpl);
		}
	}
	
	/**
	 * Association du capteur
	 * @param capteurImplEntry : CapteurImpl Le capteur
	 */
	public void setCapteur(CapteurImpl capteurImplEntry){
		capteurImpl = capteurImplEntry;
	}
	
	/**
	 * Association des canals
	 * @param canalEntry : Canal Le canal à ajouter
	 */
	public void addCanal(Canal canalEntry){
		listCanal.add(canalEntry);
	}

}
