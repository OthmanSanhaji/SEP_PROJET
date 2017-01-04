package interfacePackage;

/**
 * 
 * @author Othmane
 * @author Bastien
 *
 * Implémentation du pattern Observer
 *
 * @param <T> Le type de Sujet à observer
 */
public interface Observer<T> {
	/**
	 * Mise à jour de l'observer en fonction du Subject
	 * @param subject : T Le subject
	 */
	public void update(T subject);
}
