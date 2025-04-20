package net.dp.decorator.flovoring;

import net.dp.decorator.Beverage;
import net.dp.decorator.CondimentDecorator;

public class Mocha extends CondimentDecorator {
	Beverage beverage;

	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}

	public double cost() {
		return .20 + beverage.cost();
	}
}
