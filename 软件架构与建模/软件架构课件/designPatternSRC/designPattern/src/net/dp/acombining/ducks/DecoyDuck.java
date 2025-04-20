package net.dp.acombining.ducks;

public class DecoyDuck implements Quackable {
	public void quack() {
		System.out.println("<< Silence >>");
	}
	
	 
	public String toString() {
		return "Decoy Duck";
	}
}
