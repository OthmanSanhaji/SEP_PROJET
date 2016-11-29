package defaut;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;
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
		ScheduledThreadPoolExecutor schedule = new ScheduledThreadPoolExecutor(2);
		schedule.schedule(update, (long)(Math.random() * 10000), TimeUnit.MILLISECONDS);
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
		GetValue getValue = new GetValue(capteurImpl);
		ScheduledThreadPoolExecutor schedule = new ScheduledThreadPoolExecutor(2);
		ScheduledFuture<Integer> future = schedule.schedule(getValue, (long)(Math.random() * 10000), TimeUnit.MILLISECONDS);
		int ret = 0;
		try {
			ret = future.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

}
