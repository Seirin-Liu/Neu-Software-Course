package net.dp.acombining.observer;

import net.dp.acombining.ducks.MallardDuck;

public class MallardDuck2 extends MallardDuck implements QuackablePlus{
	Observable observable;
 
	public MallardDuck2() {
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
