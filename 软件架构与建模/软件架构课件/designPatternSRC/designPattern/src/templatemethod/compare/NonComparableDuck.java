package templatemethod.compare;

public class NonComparableDuck {
	String name;
	int weight;
	
	public NonComparableDuck(String name, int weight) {
		super();
		this.name = name;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "DuckWithoutComparable [name=" + name + ", weight=" + weight + "]";
	}
}
