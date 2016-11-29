package defaut;
import java.util.concurrent.Callable;

public class GetValue implements Callable<Integer> {

	CapteurImpl capteurImpl;
	
	public GetValue (CapteurImpl capt){
		this.capteurImpl = capt;
	}
	@Override
	public Integer call() throws Exception {		
		return capteurImpl.getValue();
	}
}
