package net.dp.strategy.quack;

public class MuteQuack implements QuackBehavior{
	public void quack(){
		System.out.println("<<Silence>>");
	}
}
