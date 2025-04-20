package First;

import java.util.HashMap;
import java.util.Map.Entry;

public class ConcreteReceipt implements Receipt {

	private HashMap<String, Float> goods;//小票数据
	
	
	public ConcreteReceipt(HashMap<String, Float> goods) {
		super();
		this.goods = goods;
	}

	
	public HashMap<String, Float> getGoods() {
		return goods;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		String description="";
		float all = 0;
		for(Entry<String, Float> e:goods.entrySet()) {
			description+="\t"+e.getKey()+"  "+e.getValue()+"\n\n";
			all+=e.getValue();	
		}
		description+="\t合计："+all+"\n";
		System.out.println(description);
		
	}

}
