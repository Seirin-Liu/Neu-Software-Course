package net.dp.acombining.observer;

public class CountingDuckFactory extends AbstractDuckFactory {
  
	public QuackablePlus createMallardDuck() {
		return new QuackCounter2(new MallardDuck2());
	}
  
	public QuackablePlus createRedheadDuck() {
		return new QuackCounter2(new RedheadDuck2());
	}
  
	public QuackablePlus createDuckCall() {
		return new QuackCounter2(new DuckCall2());
	}
   
	public QuackablePlus createRubberDuck() {
		return new QuackCounter2(new RubberDuck2());
	}
}
