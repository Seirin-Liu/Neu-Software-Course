package net.dp.acombining.observer;

import net.dp.acombining.ducks.RubberDuck;

public class RubberDuck2 extends RubberDuck implements QuackablePlus {
	Observable observable;

	public RubberDuck2() {
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
