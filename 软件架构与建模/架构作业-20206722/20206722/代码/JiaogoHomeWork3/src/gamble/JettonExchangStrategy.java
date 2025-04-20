/**
 * 筹码转换算法
 */
package gamble;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * 将筹码转换为cash
 * @author Seirin
 *
 */
public class JettonExchangStrategy implements Strategy {

    
	@Override
	public void Exchang(HashMap<Jetton, Integer> jettons, Cash cash) {
		// TODO Auto-generated method stub
		int sum=0;
		for(Entry<Jetton,Integer> e:jettons.entrySet()) {
        	sum+=e.getValue()*e.getKey().getValue();
        	
        }
		cash.setValue(cash.getValue()+sum);
		jettons.clear();
	}

	@Override
	public void Exchang(HashMap<Jetton, Integer> jettons, int cashValue) {
		// TODO Auto-generated method stub
		for(Entry<Jetton,Integer> e:jettons.entrySet()) {
        	cashValue+=e.getValue()*e.getKey().getValue();
        }
	}


}
