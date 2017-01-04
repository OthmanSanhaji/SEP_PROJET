package interfacePackage;

/**
 * 
 * @author Othmane
 * @author Bastien
 *
 * Implémentation du pattern Observer
 *
 * @param <Capteur> Le Capteur à observer
 */
public interface ObserverDeCapteur extends Observer<Capteur> {
	/**
	 * Mise à jour de l'observer en fonction du Capteur
	 * @param subject : Capteur Le Capteur
	 */
	public void update(Capteur subject);
}
