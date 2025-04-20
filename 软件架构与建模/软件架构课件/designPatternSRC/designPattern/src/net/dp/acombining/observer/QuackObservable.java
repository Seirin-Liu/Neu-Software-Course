package net.dp.acombining.observer;

public interface QuackObservable {
	public void registerObserver(Observer observer);
	public void notifyObservers();
}
