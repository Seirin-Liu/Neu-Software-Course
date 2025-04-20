package Second.Builder;

public class TreeBuilder extends Builder {

	private Tree  tree ;
	
	public TreeBuilder(String name) {
		super();
		if(name.equals("BinaryTree")) {
		this.tree =new BinaryTree();}
		if(name.equals("LeftTree")) {
			this.tree=new LeftTree();
		}
	}

	@Override
	Tree getResult() {
		// TODO Auto-generated method stub
		return tree;
	}

	
	@Override
	void setDeep(int deep) {
		// TODO Auto-generated method stub
		tree.setDeep(deep);
	}


	@Override
	void buildeTree() {
		// TODO Auto-generated method stub
		tree.buildTree();
	}


	

	
}
