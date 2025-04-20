package observer.baby.second;

public class Test {

	public static void main(String[] args) {
		Father f = new Father();
		Mother m = new Mother();
		Baby b = new Baby();
		f.setBaby(b);
		m.setBaby(b);
		f.observeBaby();
		m.observeBaby();
		b.cry();	
	}
}
