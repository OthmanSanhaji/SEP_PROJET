package interfacePackage;

import defaut.Canal;
import defaut.CapteurImpl;

/**
 * 
 * @author Othmane
 * @author Bastien
 *
 * Interface des algos de diffusion
 * 
 */
public interface AlgoDiffusion {

	/**
	 * Configuration de l'algorithme
	 */
	public void configure();
	
	/**
	 * Exécution de l'algorithme de diffusion sur tous les canals
	 */
	public void execute();
	
	/**
	 * Association du capteur
	 * @param capteurImplEntry : CapteurImpl Le capteur
	 */
	public void setCapteur(CapteurImpl capteurImplEntry);
	
	/**
	 * Association des canals
	 * @param canalEntry : Canal Le canal à ajouter
	 */
	public void addCanal(Canal canalEntry);
}
