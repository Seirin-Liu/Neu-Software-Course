package observer.baby.observer.builtin;

public class Test {

	public static void main(String[] args) {
		Father f = new Father();
		Baby b = new Baby();
		Baby b2 = new Baby();

		b.addObserver(f);
		b2.addObserver(f);
		b.cry();	
		b2.cry();
	}
}
