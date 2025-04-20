package Second.Builder;

public class Director {

	Builder builder=null;

	public Director(Builder builder) {
		super();
		this.builder = builder;
	}
	 
	 public void construct(int deep) {
		 builder.setDeep(deep);
		 builder.buildeTree();
	 }
}
