package observer.baby.first;

public class Test {

	public static void main(String[] args) {
		Father f = new Father();
		Baby b = new Baby();
		f.setBaby(b);
		f.observeBaby();
		b.cry();	
	}
}
