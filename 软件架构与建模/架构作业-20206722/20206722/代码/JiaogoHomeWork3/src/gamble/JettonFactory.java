/**
 * 筹码创建工厂(享元模式）
 */
package gamble;

import java.util.HashMap;
import java.util.Map;

public class JettonFactory {

	// 通过享元模式管理Jetton实例
	private Map<Integer, Jetton> pool = new HashMap<Integer, Jetton>();

	// 单例模式管理享元工厂
	private static JettonFactory singleton = new JettonFactory();
	
	private JettonFactory() {
		
	}
	public static JettonFactory getInstance() {
		return singleton;
	}

	// 享元方法
	public synchronized Jetton getJetton(int value) {
		if (pool.get(value) == null) {
			JettonConcrete jeach = new JettonConcrete(value);
			pool.put(value, jeach);
			return jeach;
		}
		return pool.get(value);
	}

	
}
