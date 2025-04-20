package net.dp.acombining.decorator;

import net.dp.acombining.ducks.Quackable;

public class QuackCounter implements Quackable {
	protected Quackable duck;
	protected static int numberOfQuacks;

	public QuackCounter(Quackable duck) {
		this.duck = duck;
	}

	public void quack() {
		duck.quack();
		numberOfQuacks++;
	}

	public static int getQuacks() {
		return numberOfQuacks;
	}

	public String toString() {
		return duck.toString();
	}
}
