
package Second.Composite;

public class Test {

	public static void main(String[] args) {
		
		Component menu1=new Menu("1��Ŀ¼",1);
		menu1.add(new Node("��ֵ�ѧϰ����.pdf"));
		menu1.add(new Node("������ѧϰ����.pdf"));	
		Component menu1_1=new Menu("����Ŀ¼1",2);
		menu1_1.add(new Node("ѧϰ����.ppt"));
		Component menu1_1_1=new Menu("����Ŀ¼",3);
		menu1_1_1.add(new Node("ѧϰ����.doc"));
		menu1_1.add(menu1_1_1);
		menu1.add(menu1_1);
		Component menu1_2=new Menu("����Ŀ¼2",2);
		menu1_2.add(new Node("ѧϰ����.ppt"));
		menu1_2.add(new Node("ѧϰ����.ppt"));
		menu1.add(menu1_2);
		menu1.add(new Node("ѧϰ����.pdf"));
		menu1.add(new Node("1.png"));
		menu1.add(new Node("2.png"));
		menu1.print();
		
	}
}
