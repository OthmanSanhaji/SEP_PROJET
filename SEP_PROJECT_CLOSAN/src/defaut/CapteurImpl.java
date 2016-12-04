package defaut;
import interfacePackage.AlgoDiffusion;
import interfacePackage.Capteur;
import interfacePackage.Observer;



public class CapteurImpl implements Capteur {
	private AlgoDiffusion algoDiff;
	private int compteur = 0;
	
	@Override
	public void attach(Observer o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void detach(Observer o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getValue() {		
		return compteur;
	}

	@Override
	public void tick() {
		compteur++;
		algoDiff.execute();
	}
	
	public void setAlgoDiff(AlgoDiffusion algoDiffEntry){
		algoDiff = algoDiffEntry;
	}

	@Override
	public AlgoDiffusion getAlgo() {
		return algoDiff;
	}
	
	

}
