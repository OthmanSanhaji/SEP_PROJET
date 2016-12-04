package defaut;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import interfacePackage.AlgoDiffusion;
import interfacePackage.Capteur;


public class DiffusionAtomique implements AlgoDiffusion {
	
	private Capteur capteurImpl;
	private List <Canal> listCanal = new ArrayList<Canal>();
	private CyclicBarrier c;
	
	@Override
	public void configure() {
		c = new CyclicBarrier(listCanal.size() + 1);
	}

	@Override
	public void execute() {		
		for(Canal l : listCanal){
			l.update(capteurImpl);
		}
		
		try {
			c.await();
		} catch (InterruptedException | BrokenBarrierException e) {
		}
		
	}
	
	public void unlockBarrier(){
		try {
			c.await();
		} catch (InterruptedException | BrokenBarrierException e) {
		}
	}
	
	public void reset(){
		c.reset();
	}
	
	public void setCapteur(CapteurImpl capteurImplEntry){
		capteurImpl = capteurImplEntry;
	}
	
	public void addCanal(Canal canalEntry){
		listCanal.add(canalEntry);
	}

}
