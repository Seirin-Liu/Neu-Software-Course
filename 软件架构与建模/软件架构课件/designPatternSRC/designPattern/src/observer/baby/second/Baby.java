package observer.baby.second;

public class Baby {
	String state="happy";
	
	void cry(){
		state="crying";
		new Thread(){
			public void run(){
				while(state.equals("crying")){
					System.out.println("I will cry until die!");
				}
			}
		}.start();
		
	}
}
