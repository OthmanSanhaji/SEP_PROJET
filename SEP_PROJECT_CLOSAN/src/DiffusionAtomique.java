import java.util.List;

import interfacePackage.AlgoDiffusion;
import interfacePackage.Capteur;


public class DiffusionAtomique implements AlgoDiffusion {
	
	Capteur capteurImpl;
	List <Canal> listCanal;
	
	@Override
	public void configure() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		for(Canal l : listCanal){
		l.update(capteurImpl);
		}
	}
	
	public void setCapteur(CapteurImpl capteurImplEntry){
		
		capteurImpl = capteurImplEntry;
	}
	
	public void addCanal(Canal canalEntry){
		
		listCanal.add(canalEntry);
	}

}
