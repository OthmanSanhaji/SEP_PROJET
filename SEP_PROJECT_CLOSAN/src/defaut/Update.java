package defaut;
import java.util.concurrent.Callable;

/**
 * 
 * @author Othmane
 * @author Bastien
 *
 * Implémentation du methodInvocation
 */
public class Update implements Callable<Object> {

	private Afficheur afficheur;
	private Canal canal;
	
	/**
	 * Constructeur de la methodInvocation
	 * @param affEntry : Afficheur
	 * @param canEntry : Canal
	 */
	public Update (Afficheur affEntry, Canal canEntry){
		this.afficheur = affEntry;
		this.canal = canEntry;
	}
	
	/**
	 * Appel de la méthode update de l'afficheur
	 */
	@Override
	public Object call() throws Exception {

		afficheur.update(canal);
		
		return null;
	}
	
	

}
