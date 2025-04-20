/**
 * ���봴������(��Ԫģʽ��
 */
package gamble;

import java.util.HashMap;
import java.util.Map;

public class JettonFactory {

	// ͨ����Ԫģʽ����Jettonʵ��
	private Map<Integer, Jetton> pool = new HashMap<Integer, Jetton>();

	// ����ģʽ������Ԫ����
	private static JettonFactory singleton = new JettonFactory();
	
	private JettonFactory() {
		
	}
	public static JettonFactory getInstance() {
		return singleton;
	}

	// ��Ԫ����
	public synchronized Jetton getJetton(int value) {
		if (pool.get(value) == null) {
			JettonConcrete jeach = new JettonConcrete(value);
			pool.put(value, jeach);
			return jeach;
		}
		return pool.get(value);
	}

	
}
