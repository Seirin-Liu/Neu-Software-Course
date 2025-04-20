package net.dp.strategy;

import net.dp.strategy.fly.FlyNoWay;
import net.dp.strategy.fly.FlyWithWings;
import net.dp.strategy.quack.MuteQuack;
import net.dp.strategy.quack.Squeak;

public class ADuck extends Duck {
	public ADuck() {
		flyBehavior = new FlyWithWings();
		quackBehavior = new Squeak();
	}

	public void display() {
		System.out.println("I'm a duck model.");
	}

	public void changeBehavior() {
		setFlyBehavior(new FlyNoWay());
		setQuackBehavior(new MuteQuack());
	}

	public static void main(String[] args) {
		ADuck aDuck = new ADuck();
		aDuck.display();
		aDuck.swim();
		aDuck.performFly();
		aDuck.performQuack();
		aDuck.changeBehavior();
		aDuck.performFly();
		aDuck.performQuack();
	}
}
