package net.dp.decorator.coffee;

import net.dp.decorator.Beverage;

public class HouseBlend extends Beverage {

	public HouseBlend() {
		description = "House Blend Coffee";
	}

	public double cost() {
		return .89;
	}
}
