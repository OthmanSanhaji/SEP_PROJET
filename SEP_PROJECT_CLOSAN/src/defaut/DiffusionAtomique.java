package defaut;
import interfacePackage.AlgoDiffusion;
import interfacePackage.Capteur;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * 
 * @author Othmane
 * @author Bastien
 *
 * Implémentation de l'algorithme de diffusion atomique
 * 
 */
public class DiffusionAtomique implements AlgoDiffusion {
	
	private Capteur capteurImpl;
	private List <Canal> listCanal = new ArrayList<Canal>();
	private Semaphore s;
	
	/**
	 * Configuration de l'algorithme avec un sémaphore
	 */
	@Override
	public void configure() {
		s = new Semaphore(0);
	}

	/**
	 * Exécution de l'algorithme de diffusion atomique sur tous les canals
	 */
	@Override
	public void execute() {		
		for(Canal l : listCanal){
			l.update(capteurImpl);
		}
		
		try {
			s.acquire(listCanal.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Synchronisation de la diffusion
	 */
	public void release(){
		s.release();
	}
	
	/**
	 * Remise à zéro de l'algorithme
	 */
	public void reset(){
		s.release(listCanal.size());
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
