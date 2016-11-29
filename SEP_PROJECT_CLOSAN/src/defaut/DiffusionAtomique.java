package defaut;
import java.util.ArrayList;
import java.util.List;

import interfacePackage.AlgoDiffusion;
import interfacePackage.Capteur;


public class DiffusionAtomique implements AlgoDiffusion {
	
	Capteur capteurImpl;
	List <Canal> listCanal = new ArrayList<Canal>();
	
	@Override
	public void configure() {
		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		// Currently sequential
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
