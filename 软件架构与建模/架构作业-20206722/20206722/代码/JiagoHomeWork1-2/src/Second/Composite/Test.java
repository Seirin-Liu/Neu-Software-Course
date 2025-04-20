
package Second.Composite;

public class Test {

	public static void main(String[] args) {
		
		Component menu1=new Menu("1级目录",1);
		menu1.add(new Node("奇怪的学习资料.pdf"));
		menu1.add(new Node("正常的学习资料.pdf"));	
		Component menu1_1=new Menu("二级目录1",2);
		menu1_1.add(new Node("学习资料.ppt"));
		Component menu1_1_1=new Menu("三级目录",3);
		menu1_1_1.add(new Node("学习资料.doc"));
		menu1_1.add(menu1_1_1);
		menu1.add(menu1_1);
		Component menu1_2=new Menu("二级目录2",2);
		menu1_2.add(new Node("学习资料.ppt"));
		menu1_2.add(new Node("学习资料.ppt"));
		menu1.add(menu1_2);
		menu1.add(new Node("学习资料.pdf"));
		menu1.add(new Node("1.png"));
		menu1.add(new Node("2.png"));
		menu1.print();
		
	}
}
