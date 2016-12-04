package defaut;
import interfacePackage.AlgoDiffusion;
import interfacePackage.Capteur;
import interfacePackage.ObserverDeCapteur;

import javax.swing.JLabel;


public class Afficheur extends JLabel implements ObserverDeCapteur {
	
	public Afficheur(String value){
		super(value);
	}
	
	@Override
	public void update(Capteur subject) {
		AlgoDiffusion algo = subject.getAlgo();
		if(algo instanceof DiffusionAtomique) {
			int val = subject.getValue();
			this.setText(String.valueOf(val));
			((DiffusionAtomique) algo).unlockBarrier();
		}
		else if (algo instanceof DiffusionSequentielle) {
			int val;
			if(((DiffusionSequentielle) algo).lecture()){
				val = subject.getValue();
				((DiffusionSequentielle) algo).setValue(val);
			}
			else{
				val = ((DiffusionSequentielle) algo).getValue();
			}
			this.setText(String.valueOf(val));
		}
		else if (algo instanceof DiffusionEpoque) {
			int val = subject.getValue();
			this.setText(String.valueOf(val));
		}
	}
}
