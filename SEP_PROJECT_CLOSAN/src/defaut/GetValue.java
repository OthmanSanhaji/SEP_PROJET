package defaut;
import java.util.concurrent.Callable;

/**
 * 
 * @author Othmane
 * @author Bastien
 *
 * Implémentation du methodInvocation
 */
public class GetValue implements Callable<Integer> {

	private CapteurImpl capteurImpl;
	
	/**
	 * Constructeur de la methodInvocation
	 * @param capt : CapteurImpl
	 */
	public GetValue (CapteurImpl capt){
		this.capteurImpl = capt;
	}
	
	/**
	 * Appel de la méthode getValue du Capteur
	 */
	@Override
	public Integer call() throws Exception {		
		return capteurImpl.getValue();
	}
}
