package net.dp.acombining.observer;

import net.dp.acombining.ducks.RedheadDuck;

public class RedheadDuck2 extends RedheadDuck implements QuackablePlus{
	Observable observable;

	public RedheadDuck2() {
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
