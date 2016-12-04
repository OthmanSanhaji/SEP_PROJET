package defaut;
import interfacePackage.AlgoDiffusion;
import interfacePackage.Capteur;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;


public class DiffusionAtomique implements AlgoDiffusion {
	
	private Capteur capteurImpl;
	private List <Canal> listCanal = new ArrayList<Canal>();
	private Semaphore s;
	
	@Override
	public void configure() {
		s = new Semaphore(0);
	}

	@Override
	public void execute() {		
		for(Canal l : listCanal){
			l.update(capteurImpl);
		}
		
		try {
			s.acquire(listCanal.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void release(){
		s.release();
	}
	
	public void reset(){
		s.release(listCanal.size());
	}
	
	public void setCapteur(CapteurImpl capteurImplEntry){
		capteurImpl = capteurImplEntry;
	}
	
	public void addCanal(Canal canalEntry){
		listCanal.add(canalEntry);
	}

}
