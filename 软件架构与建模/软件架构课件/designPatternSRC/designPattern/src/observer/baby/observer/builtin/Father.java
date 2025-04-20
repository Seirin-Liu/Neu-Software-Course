package observer.baby.observer.builtin;

import java.util.Observable;
import java.util.Observer;

public class Father implements Observer {

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		Baby baby;
		
		if(arg0 instanceof Baby){
			baby=(Baby) arg0;
			if(baby.getState().equals("crying")){ //pull
				System.out.println("Father: Do not cry!"+baby.toString());
				baby.setState("happy");
			}
		}
	}

}
