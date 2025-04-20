package net.dp.acombining.adapter;

import net.dp.acombining.ducks.Quackable;

public class GooseAdapter implements Quackable {
	protected Goose goose;
 
	public GooseAdapter(Goose goose) {
		this.goose = goose;
	}
 
	public void quack() {
		goose.honk();
	}

	public String toString() {
		return "Goose pretending to be a Duck";
	}
}
