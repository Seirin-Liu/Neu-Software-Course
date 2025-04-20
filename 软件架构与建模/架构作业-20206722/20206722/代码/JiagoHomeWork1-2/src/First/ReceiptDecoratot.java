package First;

public abstract class ReceiptDecoratot implements Receipt {

	public Receipt receipt;
	
	@Override
	public void print() {
		
	}

	public ReceiptDecoratot(Receipt receipt) {
		super();
		this.receipt = receipt;
	}
	
	
}
