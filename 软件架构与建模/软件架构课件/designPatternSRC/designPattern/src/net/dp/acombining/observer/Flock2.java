package net.dp.acombining.observer;

import java.util.ArrayList;
import java.util.Iterator;

public class Flock2 implements QuackablePlus{
	protected ArrayList<QuackablePlus> quackers = new ArrayList<QuackablePlus>();

	public void add(QuackablePlus quacker) {
		quackers.add(quacker);
	}

	public void quack() {
		Iterator<QuackablePlus> iterator = quackers.iterator();
		while (iterator.hasNext()) {
			QuackablePlus quacker = iterator.next();
			quacker.quack();
		}
	}
	
	public void registerObserver(Observer observer) {
		Iterator<QuackablePlus> iterator = quackers.iterator();
		while (iterator.hasNext()) {
			QuackObservable duck = iterator.next();
			duck.registerObserver(observer);
		}
	}

	public void notifyObservers() {
	}

	public String toString() {
		return "Flock of Ducks";
	}
}
