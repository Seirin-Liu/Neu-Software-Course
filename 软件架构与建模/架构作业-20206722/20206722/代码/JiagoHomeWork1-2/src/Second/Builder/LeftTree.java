package Second.Builder;

public class LeftTree implements Tree {

	private int deep;
	private String content="";

	int level = 1;

	public int getDeep() {
		return deep;
	}

	public LeftTree(int deep) {
		super();
		this.deep = deep;
	}

	public LeftTree() {
		super();
	}

	@Override
	public void setDeep(int deep) {
		// TODO Auto-generated method stub
		this.deep = deep;
	}
	
	@Override
	public void buildTree() {
		// TODO Auto-generated method stub
		int i;
		String val = "Level";
		for (i = 1; i <= deep; i++) {
			val = val + "_" + 1;
			val = val.replace("Level_" + (i - 1), "Level_" + (i));

			content = content + getMenuStr(i) +val+"\n";
		}
	}
	
	@Override
	public void printTree() {
		// TODO Auto-generated method stub
		System.out.println(content);

	}
	
	private String getMenuStr(int n) {
		String spaces = "";
		if(n==1) {
			return spaces;
		}
		spaces+=getMenuStr(n-1);
		for (int i = 1; i < n; i++)
			spaces += "  ";
		spaces += "     ";
		return spaces;
	}

}
