package interfacePackage;



public interface Capteur extends Subject{
	
	public void attach(Observer o);
	
	public void detach(Observer o);
	
	public int getValue();
	
	public void tick();
	
	public AlgoDiffusion getAlgo();

}
