package Second.Builder;

public class Test {

	public static void main(String[] args) {
		Builder treeBuilder=new TreeBuilder("BinaryTree");
		Director director=new Director(treeBuilder);
		director.construct(5);
		Tree tree=treeBuilder.getResult();
		tree.printTree();
	}
}
