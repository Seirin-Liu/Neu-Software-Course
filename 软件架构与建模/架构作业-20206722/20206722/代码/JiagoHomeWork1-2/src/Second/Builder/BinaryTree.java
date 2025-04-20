package Second.Builder;

public class BinaryTree implements Tree {

	private int deep;
	int level = 1;
	private String content = "";

	public void setDeep(int deep) {
		this.deep = deep;
	}

	public BinaryTree(int deep) {
		super();
		this.deep = deep;
	}

	public BinaryTree() {
		super();
	}

	public void printTree() {

		System.out.println(content);

	}

	@Override
	public void buildTree() {
		// TODO Auto-generated method stub
		int i = 1;
		String val = "Level_1";

		if (i < Math.pow(2, deep)) {
			if (level > 1)
				val = val + "_" + (i % 2 == 0 ? 1 : 2);

			content = content + val + "\n";
			val = val.replace("Level_" + level, "Level_" + (level + 1));
			level++;
			String baseVal = val.trim();
			val = getMenuStr(val.length()) + baseVal;

			buildTree(val, 2 * i);
			buildTree(val, 2 * i + 1);

			level--;
		}
	}

	public void buildTree(String val, int i) {

		if (i < Math.pow(2, deep)) {
			if (level > 1)
				val = val + "_" + (i % 2 == 0 ? 1 : 2);
		
			content = content + val + "\n";
			val = val.replace("Level_" + level, "Level_" + (level + 1));
			level++;
			String baseVal = val.trim();
			val = getMenuStr(val.length()) + baseVal;

			buildTree(val, 2 * i);
			buildTree(val, 2 * i + 1);

			level--;
		}

	}

	private String getMenuStr(int n) {
		String spaces = "";
		for (int i = 0; i < n; i++)
			spaces += " ";
		return spaces;
	}

}
