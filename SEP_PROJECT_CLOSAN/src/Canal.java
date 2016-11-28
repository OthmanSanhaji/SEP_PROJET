import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import interfacePackage.Capteur;
import interfacePackage.Observer;
import interfacePackage.ObserverDeCapteur;


public class Canal implements Capteur, ObserverDeCapteur {

	private Afficheur a;
	private CapteurImpl capteurImpl;
	
	public Canal (CapteurImpl capteurEntry, Afficheur afficheurImpl){
		this.a = afficheurImpl;
		this.capteurImpl = capteurEntry;
	}
	
	@Override
	public void update(Capteur subject) {

		Update update = new Update(a, this);
		ScheduledThreadPoolExecutor schedule = new ScheduledThreadPoolExecutor(20);
		schedule.schedule(update, 720, TimeUnit.MILLISECONDS);
	}

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
		return capteurImpl.getValue();
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

}
