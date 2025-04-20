package net.dp.decorator.coffee;

import net.dp.decorator.Beverage;

public class Espresso extends Beverage {

	public Espresso() {
		description = "Espresso";
	}

	public double cost() {
		return 1.99;
	}
}
