package observer.baby.observer.builtin;

import java.util.Observable;

public class Baby extends Observable {
	private String state="happy";
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	void cry(){
		state="crying";

		new Thread(){
			public void run(){
				while(state.equals("crying")){
					System.out.println("I will cry until die!");
				}
			}
		}.start();
		this.setChanged();
		this.notifyObservers();
	}
}
