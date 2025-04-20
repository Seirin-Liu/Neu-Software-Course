package net.dp.acombining.composite;

import net.dp.acombining.adapter.Goose;
import net.dp.acombining.adapter.GooseAdapter;
import net.dp.acombining.decorator.QuackCounter;
import net.dp.acombining.ducks.Quackable;
import net.dp.acombining.factory.AbstractDuckFactory;
import net.dp.acombining.factory.CountingDuckFactory;

public class DuckSimulator {

	public static void main(String[] args) {
		DuckSimulator simulator = new DuckSimulator();
		AbstractDuckFactory duckFactory = new CountingDuckFactory();

		simulator.simulate(duckFactory);
	}

	void simulate(AbstractDuckFactory duckFactory) {
		Quackable redheadDuck = duckFactory.createRedheadDuck();
		Quackable duckCall = duckFactory.createDuckCall();
		Quackable rubberDuck = duckFactory.createRubberDuck();
		Quackable gooseDuck = new GooseAdapter(new Goose());

		System.out.println("\nDuck Simulator: With Composite - Flocks");

		Flock flockOfDucks = new Flock();

		flockOfDucks.add(redheadDuck);
		flockOfDucks.add(duckCall);
		flockOfDucks.add(rubberDuck);
		flockOfDucks.add(gooseDuck);

		Flock flockOfMallards = new Flock();

		Quackable mallardOne = duckFactory.createMallardDuck();
		Quackable mallardTwo = duckFactory.createMallardDuck();
		Quackable mallardThree = duckFactory.createMallardDuck();
		Quackable mallardFour = duckFactory.createMallardDuck();

		flockOfMallards.add(mallardOne);
		flockOfMallards.add(mallardTwo);
		flockOfMallards.add(mallardThree);
		flockOfMallards.add(mallardFour);

		flockOfDucks.add(flockOfMallards);

		System.out.println("\nDuck Simulator: Whole Flock Simulation");
		simulate(flockOfDucks);

		System.out.println("\nDuck Simulator: Mallard Flock Simulation");
		simulate(flockOfMallards);

		System.out.println("\nThe ducks quacked " + QuackCounter.getQuacks()
				+ " times");
	}

	void simulate(Quackable duck) {
		duck.quack();
	}
}
