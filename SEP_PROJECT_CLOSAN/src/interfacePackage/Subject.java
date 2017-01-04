package interfacePackage;


/**
 * 
 * @author Othmane
 * @author Bastien
 *
 * Implémentation du pattern Observer
 */
public interface Subject {

	/**
	 * Associe l'observer à mettre à jour
	 * @param o : Observer
	 */
	public void attach(Observer o);
	
	/**
	 * Dissocie l'observer à mettre à jour
	 * @param o : Observer
	 */
	public void detach(Observer o);
	
}
