package interfacePackage;


/**
 * 
 * @author Othmane
 * @author Bastien
 *
 * Implémentation du pattern Observer
 */
public interface Capteur extends Subject{
	
	/**
	 * Associe l'afficheur à mettre à jour
	 * @param o : Observer
	 */
	public void attach(Observer o);
	
	/**
	 * Dissocie l'afficheur à mettre à jour
	 * @param o : Observer
	 */
	public void detach(Observer o);
	
	/**
	 * Retourne la valeur du capteur
	 * @return La valeur du capteur
	 */
	public int getValue();
	
	/**
	 * Mise à jour du capteur
	 */
	public void tick();
	

	/**
	 * Retourne l'algo de diffusion utilisé
	 * @return L'algo de diffusion
	 */
	public AlgoDiffusion getAlgo();

}
