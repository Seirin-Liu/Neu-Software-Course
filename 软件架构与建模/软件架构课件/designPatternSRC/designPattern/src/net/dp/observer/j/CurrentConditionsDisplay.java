package net.dp.observer.j;

import java.util.Observable;
import java.util.Observer;
	
public class CurrentConditionsDisplay implements Observer, DisplayElement {
	private float temperature;
	private float humidity;
	
	public CurrentConditionsDisplay(Observable observable) {
		observable.addObserver(this);
	}
	
	public void update(Observable obs, Object arg) {
		if (obs instanceof WeatherData) {
			WeatherData weatherData = (WeatherData)obs;
			this.temperature = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();
			display();
		}
	}
	
	public void display() {
		System.out.println("Current conditions: " + temperature 
			+ "F degrees and " + humidity + "% humidity");
	}
}