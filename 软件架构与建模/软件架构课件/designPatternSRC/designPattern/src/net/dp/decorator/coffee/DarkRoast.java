package net.dp.decorator.coffee;

import net.dp.decorator.Beverage;

public class DarkRoast extends Beverage {

	public DarkRoast() {
		description = "DarkRoast";
	}

	public double cost() {
		return .99;
	}
}

