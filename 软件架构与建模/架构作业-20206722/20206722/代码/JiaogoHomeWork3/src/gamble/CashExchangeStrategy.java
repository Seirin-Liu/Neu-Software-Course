/**
 * 货币转换算法
 */
package gamble;

import java.util.HashMap;


/**
 * 将cash转换为筹码
 * @author Seirin
 *
 */
public class CashExchangeStrategy implements Strategy {

	@Override
	public void Exchang(HashMap<Jetton, Integer> jettons, Cash cash) {
		// TODO Auto-generated method stub
		JettonFactory jettonFactory=JettonFactory.getInstance();
		if(cash.getValue()>=5) {
		jettons.put(jettonFactory.getJetton(5), cash.getValue()/5);
		if(cash.getValue()-5*cash.getValue()/5>0) {
		jettons.put(jettonFactory.getJetton(1), cash.getValue()-5*cash.getValue()/5);}
		cash.setValue(0);
		}
			
	}

	@Override
	public void Exchang(HashMap<Jetton, Integer> jettons, int cashValue) {
		// TODO Auto-generated method stub
		JettonFactory jettonFactory=JettonFactory.getInstance();
		if( cashValue>=5) {
		jettons.put(jettonFactory.getJetton(5),  cashValue/5);
		if(cashValue-5* cashValue/5>0) {
		jettons.put(jettonFactory.getJetton(1),  cashValue-5* cashValue/5);}
		}
	}
}
