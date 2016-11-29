package interfacePackage;

import defaut.Canal;
import defaut.CapteurImpl;


public interface AlgoDiffusion {

	public void configure();
	
	public void execute();
	
	public void setCapteur(CapteurImpl capteurImplEntry);
	
	public void addCanal(Canal canalEntry);
}
