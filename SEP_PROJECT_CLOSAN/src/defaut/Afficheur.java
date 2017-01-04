package defaut;
import interfacePackage.AlgoDiffusion;
import interfacePackage.Capteur;
import interfacePackage.ObserverDeCapteur;

import javax.swing.JLabel;

/**
 * 
 * @author Othmane
 * @author Bastien
 *
 * Implémentation de l'afficheur
 */
public class Afficheur extends JLabel implements ObserverDeCapteur {
	
	/**
	 * Constructeur de l'afficheur
	 * @param value : La valeur par défaut de l'afficheur
	 */
	public Afficheur(String value){
		super(value);
	}
	
	/**
	 * Mise à jour de l'afficheur en fonction du Capteur et de l'algorithme de diffusion
	 * @param subject : Capteur Le Capteur
	 */
	@Override
	public void update(Capteur subject) {
		AlgoDiffusion algo = subject.getAlgo();
		if(algo instanceof DiffusionAtomique) {
			int val = subject.getValue();
			this.setText(String.valueOf(val));
			((DiffusionAtomique) algo).release();
		}
		else if (algo instanceof DiffusionSequentielle) {
			int val;
			((DiffusionSequentielle) algo).acquire();
			if(((DiffusionSequentielle) algo).lecture()){
				val = subject.getValue();
				((DiffusionSequentielle) algo).setValue(val);
			}
			else{
				val = ((DiffusionSequentielle) algo).getValue();
			}
			((DiffusionSequentielle) algo).release();
			this.setText(String.valueOf(val));
		}
		else if (algo instanceof DiffusionEpoque) {
			int val = subject.getValue();
			this.setText(String.valueOf(val));
		}
	}
}
