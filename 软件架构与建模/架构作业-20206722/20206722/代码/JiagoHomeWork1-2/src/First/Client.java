package First;

import java.util.HashMap;

public class Client {

	public static void main(String[] args) {
		
		HashMap<String, Float> goods=new HashMap<>();
		
		goods.put("±ý¸É",(float) 1.50);
		goods.put("¿ÉÀÖ",(float) 3.50);
		
		Receipt receipt=new Time(new Tel(new SupaName(new ConcreteReceipt(goods))));
		receipt.print();
	}
}
