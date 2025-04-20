package net.dp.acombining.composite;

import java.util.ArrayList;
import java.util.Iterator;

import net.dp.acombining.ducks.Quackable;

public class Flock implements Quackable {
	protected ArrayList<Quackable> quackers = new ArrayList<Quackable>();

	public void add(Quackable quacker) {
		quackers.add(quacker);
	}

	public void quack() {
		Iterator<Quackable> iterator = quackers.iterator();
		while (iterator.hasNext()) {
			Quackable quacker = iterator.next();
			quacker.quack();
		}
	}

	public String toString() {
		return "Flock of Quackers";
	}
}
