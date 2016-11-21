import interfacePackage.AlgoDiffusion;
import interfacePackage.Capteur;
import interfacePackage.Observer;



public class CapteurImpl implements Capteur {

	private AlgoDiffusion algoDiff;
	
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		algoDiff.execute();
		
	}
	
	public void setAlgoDiff(AlgoDiffusion algoDiffEntry){
		
		algoDiff = algoDiffEntry;
	}
	
	

}
