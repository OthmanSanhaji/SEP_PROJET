package defaut;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import interfacePackage.AlgoDiffusion;
import interfacePackage.Capteur;
import interfacePackage.Observer;
import interfacePackage.ObserverDeCapteur;

/**
 * 
 * @author Othmane
 * @author Bastien
 *
 * Implémentation du Canal
 */
public class Canal implements Capteur, ObserverDeCapteur {

	private Afficheur a;
	private CapteurImpl capteurImpl;
	
	/**
	 * Constructeur du canal
	 * @param capteurEntry : CapteurImpl Le capteur
	 * @param afficheurImpl : Afficheur L'afficheur à mettre à jour
	 */
	public Canal (CapteurImpl capteurEntry, Afficheur afficheurImpl){
		this.a = afficheurImpl;
		this.capteurImpl = capteurEntry;
	}
	
	/**
	 * Mise à jour du Canal en fonction du Capteur
	 * @param subject : Capteur Le Capteur
	 */
	@Override
	public void update(Capteur subject) {

		Update update = new Update(a, this);
		ScheduledThreadPoolExecutor schedule = new ScheduledThreadPoolExecutor(10);
		schedule.schedule(update, (long)(Math.random() * 4000) + 500, TimeUnit.MILLISECONDS);
		//schedule.schedule(update, 5000, TimeUnit.MILLISECONDS);
	}

	@Override
	public void attach(Observer o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void detach(Observer o) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Retourne la valeur du capteur
	 * @return La valeur du capteur
	 */
	@Override
	public int getValue() {
		GetValue getValue = new GetValue(capteurImpl);
		ScheduledThreadPoolExecutor schedule = new ScheduledThreadPoolExecutor(10);
		ScheduledFuture<Integer> future = schedule.schedule(getValue, (long)(Math.random() * 4000) + 500, TimeUnit.MILLISECONDS);
		//ScheduledFuture<Integer> future = schedule.schedule(getValue, 5000, TimeUnit.MILLISECONDS);
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

	/**
	 * Retourne l'algo de diffusion utilisé
	 * @return L'algo de diffusion
	 */
	@Override
	public AlgoDiffusion getAlgo() {
		return capteurImpl.getAlgo();
	}

}
