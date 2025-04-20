package Second.Composite;



public class Node extends Component{


	public Node(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
		System.out.print(this.getName()+"\n");
	}

	

}
