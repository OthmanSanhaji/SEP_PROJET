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
 * Implémentation de l'algorithme de diffusion séquentielle
 * 
 */
public class DiffusionSequentielle implements AlgoDiffusion {

	private Capteur capteurImpl;
	private List<Canal> listCanal = new ArrayList<Canal>();
	private boolean lecture = true;
	private int value;
	private int cpt = 0;
	private Semaphore s;
	private boolean ready = true;

	/**
	 * Configuration de l'algorithme avec un sémaphore
	 */
	@Override
	public void configure() {
		s = new Semaphore(1);
	}

	/**
	 * Exécution de l'algorithme de séquentielle par époque sur tous les canals
	 */
	@Override
	public void execute() {
		if(ready){
			ready = false;
			for (Canal l : listCanal) {
				l.update(capteurImpl);
			}
		}
	}
	
	/**
	 * Synchronisation de la diffusion
	 */
	public void acquire(){
		try {
			s.acquire();
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
	 * Vérifier si la lecture auprès du capteur est nécessaire
	 * @return true si la valeur doit être lu sur le capteur
	 */
	public synchronized boolean lecture() {
		if (lecture) {
			lecture = false;
			return true;
		}
		return lecture;
	}

	/**
	 * Retourne la valeur à afficher
	 * @return La valeur à afficher
	 */
	public synchronized int getValue() {
		cpt++;
		if (cpt == listCanal.size() - 1) {
			lecture = true;
			cpt = 0;
			ready = true;
		}
		return value;
	}

	/**
	 * Mise à jour de la valeur du capteur
	 * @param value : int La nouvelle valeur du capteur
	 */
	public void setValue(int value) {
		this.value = value;
	}
	
	/**
	 * Association du capteur
	 * @param capteurImplEntry : CapteurImpl Le capteur
	 */
	public void setCapteur(CapteurImpl capteurImplEntry) {
		capteurImpl = capteurImplEntry;
	}

	/**
	 * Association des canals
	 * @param canalEntry : Canal Le canal à ajouter
	 */
	public void addCanal(Canal canalEntry) {
		listCanal.add(canalEntry);
	}

}
