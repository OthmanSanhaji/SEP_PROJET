package defaut;
import javax.swing.JLabel;

import interfacePackage.Capteur;
import interfacePackage.ObserverDeCapteur;


public class Afficheur extends JLabel implements ObserverDeCapteur {
	
	public Afficheur(String value){
		super(value);
	}
	
	@Override
	public void update(Capteur subject) {
		
		int val = subject.getValue();
		this.setText(String.valueOf(val));
		
	}
}
