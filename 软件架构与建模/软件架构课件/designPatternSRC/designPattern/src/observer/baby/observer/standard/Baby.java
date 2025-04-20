package observer.baby.observer.standard;

import java.util.ArrayList;

public class Baby implements Subject {
	ArrayList<Observer> arrayList;

	private String state;
	
	void cry(){
		state="cry";
		new Thread(){
			public void run(){
				while(state.equals("cry")){
					System.out.println("I will cry until die!");
				}
			}
		}.start();
		notifyObservers();
		
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Baby() {
		super();
		this.arrayList = new ArrayList<Observer>();
	}

	public void attach(Observer o) {
		// TODO Auto-generated method stub
		arrayList.add(o);
	}

	@Override
	public void dettach(Observer o) {
		// TODO Auto-generated method stub
		arrayList.remove(o);
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for(Observer observer : arrayList){
			observer.update(this);
		}
	}

}
