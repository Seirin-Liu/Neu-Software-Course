package Second.Composite;


public abstract class Component {

	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Component(String name) {
		super();
		this.name = name;
	}

	public  void add(Component menuComponent) {
		
	}
	public  void remove(Component menuComponent) {
		
	}
	public abstract void print();
}
