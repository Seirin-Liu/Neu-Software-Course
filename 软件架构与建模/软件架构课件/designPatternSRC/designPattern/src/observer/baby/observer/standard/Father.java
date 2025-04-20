package observer.baby.observer.standard;

public class Father implements Observer {

	public void update(Subject s) {
		Baby baby = (Baby) s;
		if(baby.getState().equals("cry")){
			System.out.println("Don't cry");
			baby.setState("happy");
		}

	}

}
