package First;

import java.util.HashMap;

public class Client {

	public static void main(String[] args) {
		
		HashMap<String, Float> goods=new HashMap<>();
		
		goods.put("����",(float) 1.50);
		goods.put("����",(float) 3.50);
		
		Receipt receipt=new Time(new Tel(new SupaName(new ConcreteReceipt(goods))));
		receipt.print();
	}
}
