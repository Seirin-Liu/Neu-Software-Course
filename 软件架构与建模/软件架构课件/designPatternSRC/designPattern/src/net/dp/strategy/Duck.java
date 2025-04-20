package net.dp.strategy;

import net.dp.strategy.fly.FlyBehavior;
import net.dp.strategy.quack.QuackBehavior;

public abstract class Duck {
	protected FlyBehavior flyBehavior;
	protected QuackBehavior quackBehavior;
	
	public abstract void display();
	
	public void performFly(){
		flyBehavior.fly();
	}

	public void performQuack(){
		quackBehavior.quack();
	}
	
	public void swim(){
		System.out.println("All ducks float, even decoys!");
	}

	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}

	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}
}
