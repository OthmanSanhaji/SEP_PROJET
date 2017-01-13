package defaut;

import java.util.concurrent.ThreadLocalRandom;

import org.junit.Test;

public class TestExecute {

//	public static void main(String[] args) {
//
//	}
	
	@Test
	public void TestMonteeCharge(){
		System.out.println("[INFO] DEBUT TESTMONTEECHARGE");
		Horloge program = new Horloge();
		for(int i = 0; i < 10000;i++){
		program.init(new DiffusionAtomique());
		program.execute();
		}
		
		for(int i = 0; i < 10000;i++){
			program.init(new DiffusionSequentielle());
			program.execute();
			}
		
		for(int i = 0; i < 10000;i++){
			program.init(new DiffusionEpoque());
			program.execute();
			}
		
	}
	
	
	@Test
	public void testSwitch(){
		System.out.println("[INFO] DEBUT TESTSWITCH");
		Horloge program = new Horloge();
		int i;
		int randomChoiceAlgo;
		for(i = 0; i < 10000;i++){
		randomChoiceAlgo = ThreadLocalRandom.current().nextInt(0, 2);
		if (randomChoiceAlgo == 0)
		program.init(new DiffusionAtomique());
		else if (randomChoiceAlgo == 1)
		program.init(new DiffusionSequentielle());
		else
		program.init(new DiffusionEpoque());

		program.execute();
		}
	}
	

}
