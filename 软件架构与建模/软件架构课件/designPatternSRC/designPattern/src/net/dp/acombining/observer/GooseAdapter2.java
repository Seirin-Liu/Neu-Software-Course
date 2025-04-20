package net.dp.acombining.observer;

import net.dp.acombining.adapter.Goose;
import net.dp.acombining.adapter.GooseAdapter;

public class GooseAdapter2 extends GooseAdapter implements QuackablePlus {
	Observable observable;

	public GooseAdapter2(Goose goose) {
		super(goose);
		observable = new Observable(this);
	}
 
	public void quack() {
		goose.honk();
		notifyObservers();
	}

	public void registerObserver(Observer observer) {
		observable.registerObserver(observer);
	}

	public void notifyObservers() {
		observable.notifyObservers();
	}
}
