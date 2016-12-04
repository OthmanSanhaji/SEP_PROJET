package defaut;
import java.util.concurrent.Callable;

public class Update implements Callable<Object> {

	private Afficheur afficheur;
	private Canal canal;
	
	public Update (Afficheur affEntry, Canal canEntry){
		this.afficheur = affEntry;
		this.canal = canEntry;
	}
	@Override
	public Object call() throws Exception {

		afficheur.update(canal);
		
		return null;
	}
	
	

}
