package net.dp.acombining.observer;

public class DuckFactory extends AbstractDuckFactory {
  
	public QuackablePlus createMallardDuck() {
		return new MallardDuck2();
	}
  
	public QuackablePlus createRedheadDuck() {
		return new RedheadDuck2();
	}
  
	public QuackablePlus createDuckCall() {
		return new DuckCall2();
	}
   
	public QuackablePlus createRubberDuck() {
		return new RubberDuck2();
	}
}
