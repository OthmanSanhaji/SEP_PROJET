import java.util.List;

import interfacePackage.AlgoDiffusion;


public class DiffusionAtomique implements AlgoDiffusion {
	
	CapteurImpl capteurImpl;
	List <Canal> listCanal;
	
	@Override
	public void configure() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		listCanal.get(0).update(capteurImpl);
	}
	
	public void setCapteur(CapteurImpl capteurImplEntry){
		
		capteurImpl = capteurImplEntry;
	}
	
	public void addCanal(Canal canalEntry){
		
		listCanal.add(canalEntry);
	}

}
