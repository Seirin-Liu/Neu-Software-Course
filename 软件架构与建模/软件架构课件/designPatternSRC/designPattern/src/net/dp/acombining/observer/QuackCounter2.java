package net.dp.acombining.observer;

import net.dp.acombining.decorator.QuackCounter;

public class QuackCounter2 extends QuackCounter implements QuackablePlus {
	QuackablePlus duck;
  
	public QuackCounter2(QuackablePlus duck) {
		super(duck);
		this.duck = duck;
	}
 
	public void registerObserver(Observer observer) {
		duck.registerObserver(observer);
	}
 
	public void notifyObservers() {
		duck.notifyObservers();
	}
}
