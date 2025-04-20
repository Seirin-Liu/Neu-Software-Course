package net.dp.acombining.observer;

import net.dp.acombining.adapter.Goose;

public class DuckSimulator {
	public static void main(String[] args) {
		DuckSimulator simulator = new DuckSimulator();
		AbstractDuckFactory duckFactory = new CountingDuckFactory();
 
		simulator.simulate(duckFactory);
	}
  
	void simulate(AbstractDuckFactory duckFactory) {
  
		QuackablePlus redheadDuck = duckFactory.createRedheadDuck();
		QuackablePlus duckCall = duckFactory.createDuckCall();
		QuackablePlus rubberDuck = duckFactory.createRubberDuck();
		QuackablePlus gooseDuck = new GooseAdapter2(new Goose());
 
		Flock2 flockOfDucks = new Flock2();
 
		flockOfDucks.add(redheadDuck);
		flockOfDucks.add(duckCall);
		flockOfDucks.add(rubberDuck);
		flockOfDucks.add(gooseDuck);
 
		Flock2 flockOfMallards = new Flock2();
 
		QuackablePlus mallardOne = duckFactory.createMallardDuck();
		QuackablePlus mallardTwo = duckFactory.createMallardDuck();
		QuackablePlus mallardThree = duckFactory.createMallardDuck();
		QuackablePlus mallardFour = duckFactory.createMallardDuck();

		flockOfMallards.add(mallardOne);
		flockOfMallards.add(mallardTwo);
		flockOfMallards.add(mallardThree);
		flockOfMallards.add(mallardFour);

		flockOfDucks.add(flockOfMallards);

		System.out.println("\nDuck Simulator: With Observer");

		Quackologist quackologist = new Quackologist();
		flockOfDucks.registerObserver(quackologist);

		simulate(flockOfDucks);

		System.out.println("\nThe ducks quacked " + 
		                   QuackCounter2.getQuacks() + 
		                   " times");
	}
 
	void simulate(QuackablePlus duck) {
		duck.quack();
	}
}
