package templatemethod.compare;

public class ComparableDuck implements Comparable<ComparableDuck> {
	String name;
	int weight;
	
	public ComparableDuck(String name, int weight) {
		super();
		this.name = name;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "DuckWithoutComparable [name=" + name + ", weight=" + weight + "]";
	}

	@Override
	public int compareTo(ComparableDuck o) {
		if(this.weight > o.weight)
			return 1;
		else if(this.weight < o.weight)
			return -1;
		
		return 0; //this.weight == o.weight
	}
	
}
