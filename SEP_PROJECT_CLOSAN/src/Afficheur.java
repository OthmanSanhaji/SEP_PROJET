import interfacePackage.Capteur;
import interfacePackage.ObserverDeCapteur;


public class Afficheur implements ObserverDeCapteur {

	@Override
	public void update(Capteur subject) {
		
		int val = subject.getValue();
		
		
	}
}
