package First;

public class Tel extends ReceiptDecoratot {

	public Tel(Receipt receipt) {
		super(receipt);
		// TODO Auto-generated constructor stub
	}

	public void print() {
		
		receipt.print();
		addTel();
		
	}
	
	public void addTel() {
		
		System.out.println("    ----------------    ");
		System.out.println("       Tel:8888888    ");
		
	}
}
