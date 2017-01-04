package defaut;
import interfacePackage.AlgoDiffusion;
import interfacePackage.Capteur;
import interfacePackage.Observer;


/**
 * 
 * @author Othmane
 * @author Bastien
 *
 * Implémentation du Capteur
 */
public class CapteurImpl implements Capteur {
	private AlgoDiffusion algoDiff;
	private int compteur = 0;
	
	/**
	 * Associe l'afficheur à mettre à jour
	 * @param o : Observer
	 */
	@Override
	public void attach(Observer o) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Dissocie l'afficheur à mettre à jour
	 * @param o : Observer
	 */
	@Override
	public void detach(Observer o) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Retourne la valeur du capteur
	 * @return La valeur du capteur
	 */
	@Override
	public int getValue() {		
		return compteur;
	}

	/**
	 * Mise à jour du capteur
	 */
	@Override
	public void tick() {
		compteur++;
		algoDiff.execute();
	}
	
	/**
	 * Modifie l'algo de diffusion utilisé
	 * @param algoDiffEntry : AlgoDiffusion
	 */
	public void setAlgoDiff(AlgoDiffusion algoDiffEntry){
		algoDiff = algoDiffEntry;
	}


	/**
	 * Retourne l'algo de diffusion utilisé
	 * @return L'algo de diffusion
	 */
	@Override
	public AlgoDiffusion getAlgo() {
		return algoDiff;
	}
	
	

}
