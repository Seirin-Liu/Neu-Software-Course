package First;

/**
 * ��������
 * @author Seirin
 *
 */
public class SupaName extends ReceiptDecoratot{

	public SupaName(Receipt receipt) {
		super(receipt);
		// TODO Auto-generated constructor stub
	}

	public void print() {
		addName();
		receipt.print();
	}
	
	public void addName() {
		System.out.println("\t������ѧ����\t\n");
		System.out.println("------------------------");
		System.out.println("    ----------------    ");
		
	}
	
}
