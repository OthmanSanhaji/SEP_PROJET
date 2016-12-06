package defaut;

import interfacePackage.AlgoDiffusion;
import interfacePackage.Capteur;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class DiffusionSequentielle implements AlgoDiffusion {

	private Capteur capteurImpl;
	private List<Canal> listCanal = new ArrayList<Canal>();
	private boolean lecture = true;
	private int value;
	private int cpt = 0;
	private Semaphore s;
	private boolean ready = true;

	@Override
	public void configure() {
		s = new Semaphore(1);
	}

	@Override
	public void execute() {
		if(ready){
			ready = false;
			for (Canal l : listCanal) {
				l.update(capteurImpl);
			}
		}
	}
	
	public void acquire(){
		try {
			s.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void release(){
		s.release();
	}
	public synchronized boolean lecture() {
		if (lecture) {
			lecture = false;
			return true;
		}
		return lecture;
	}

	public synchronized int getValue() {
		cpt++;
		if (cpt == listCanal.size() - 1) {
			lecture = true;
			cpt = 0;
			ready = true;
		}
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void setCapteur(CapteurImpl capteurImplEntry) {
		capteurImpl = capteurImplEntry;
	}

	public void addCanal(Canal canalEntry) {
		listCanal.add(canalEntry);
	}

}
