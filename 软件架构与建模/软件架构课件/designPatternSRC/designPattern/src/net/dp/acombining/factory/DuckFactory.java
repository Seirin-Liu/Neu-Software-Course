package net.dp.acombining.factory;

import net.dp.acombining.ducks.DuckCall;
import net.dp.acombining.ducks.MallardDuck;
import net.dp.acombining.ducks.Quackable;
import net.dp.acombining.ducks.RedheadDuck;
import net.dp.acombining.ducks.RubberDuck;

public class DuckFactory extends AbstractDuckFactory {
  
	public Quackable createMallardDuck() {
		return new MallardDuck();
	}
  
	public Quackable createRedheadDuck() {
		return new RedheadDuck();
	}
  
	public Quackable createDuckCall() {
		return new DuckCall();
	}
   
	public Quackable createRubberDuck() {
		return new RubberDuck();
	}
}
