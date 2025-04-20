package net.dp.acombining.observer;

import net.dp.acombining.ducks.DecoyDuck;

public class DecoyDuck2 extends DecoyDuck implements QuackablePlus{
	Observable observable;

	public DecoyDuck2() {
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
