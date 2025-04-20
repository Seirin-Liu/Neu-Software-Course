package net.dp.acombining.decorator;

import net.dp.acombining.adapter.Goose;
import net.dp.acombining.adapter.GooseAdapter;
import net.dp.acombining.ducks.DuckCall;
import net.dp.acombining.ducks.MallardDuck;
import net.dp.acombining.ducks.Quackable;
import net.dp.acombining.ducks.RedheadDuck;
import net.dp.acombining.ducks.RubberDuck;

public class DuckSimulator {
	public static void main(String[] args) {
		DuckSimulator simulator = new DuckSimulator();
		simulator.simulate();
	}

	void simulate() {
		Quackable mallardDuck = new QuackCounter(new MallardDuck());
		Quackable redheadDuck = new QuackCounter(new RedheadDuck());
		Quackable duckCall = new QuackCounter(new DuckCall());
		Quackable rubberDuck = new QuackCounter(new RubberDuck());
		Quackable gooseDuck = new GooseAdapter(new Goose());

		System.out.println("\nDuck Simulator: With Decorator");

		simulate(mallardDuck);
		simulate(redheadDuck);
		simulate(duckCall);
		simulate(rubberDuck);
		simulate(gooseDuck);

		System.out.println("The ducks quacked " + 
		                   QuackCounter.getQuacks() + " times");
	}

	void simulate(Quackable duck) {
		duck.quack();
	}
}
