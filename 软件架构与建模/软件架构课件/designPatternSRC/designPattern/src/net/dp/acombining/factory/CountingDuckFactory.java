package net.dp.acombining.factory;

import net.dp.acombining.decorator.QuackCounter;
import net.dp.acombining.ducks.DuckCall;
import net.dp.acombining.ducks.MallardDuck;
import net.dp.acombining.ducks.Quackable;
import net.dp.acombining.ducks.RedheadDuck;
import net.dp.acombining.ducks.RubberDuck;

public class CountingDuckFactory extends AbstractDuckFactory {
  
	public Quackable createMallardDuck() {
		return new QuackCounter(new MallardDuck());
	}
  
	public Quackable createRedheadDuck() {
		return new QuackCounter(new RedheadDuck());
	}
  
	public Quackable createDuckCall() {
		return new QuackCounter(new DuckCall());
	}
   
	public Quackable createRubberDuck() {
		return new QuackCounter(new RubberDuck());
	}
}
