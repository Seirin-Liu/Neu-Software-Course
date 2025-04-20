package net.dp.acombining.observer;

import net.dp.acombining.ducks.DuckCall;

public class DuckCall2 extends DuckCall implements QuackablePlus{
	Observable observable;

	public DuckCall2() {
		observable = new Observable(this);
	}
 
	public void quack() {
		super.quack();
		notifyObservers();
	}
 
	public void registerObserver(Observer observer) {
		observable.registerObserver(observer);
	}

	public void notifyObservers() {
		observable.notifyObservers();
	}
}
