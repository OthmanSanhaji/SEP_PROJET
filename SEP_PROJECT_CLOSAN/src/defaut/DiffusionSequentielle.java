package defaut;

import interfacePackage.AlgoDiffusion;
import interfacePackage.Capteur;

import java.util.ArrayList;
import java.util.List;

public class DiffusionSequentielle implements AlgoDiffusion {

	private Capteur capteurImpl;
	private List<Canal> listCanal = new ArrayList<Canal>();
	private boolean lecture = true;
	private int value;
	private int cpt = 0;

	@Override
	public void configure() {
	}

	@Override
	public void execute() {
		for (Canal l : listCanal) {
			l.update(capteurImpl);
		}
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
