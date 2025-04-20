package observer.baby.observer.standard;

public class Test {

	public static void main(String[] args) {
		Father f = new Father();
		Baby b = new Baby();
		Baby b2 = new Baby();
		b.attach(f);
		b2.attach(f);
		b.cry();	
		b2.cry();
	}
}
