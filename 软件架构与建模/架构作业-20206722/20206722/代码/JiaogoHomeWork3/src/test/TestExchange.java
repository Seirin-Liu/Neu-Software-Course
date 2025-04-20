package test;

import gamble.Cash;
import gamble.CashExchangeStrategy;
import gamble.JettonExchangStrategy;
import gamble.JettonFactory;
import gamble.Player;
import gamble.Strategy;


public class TestExchange {

	
	public static void main(String[] args) {
		JettonFactory jettonFactory=JettonFactory.getInstance();
	
		Player player=new Player();
		player.setCash(new Cash(0));
		player.getJettons().put(jettonFactory.getJetton(5),10);
		player.getJettons().put(jettonFactory.getJetton(10),5);
		player.getJettons().put(jettonFactory.getJetton(20),2);
		System.out.println("当前所有筹码：");
		player.printJettons();
		
		Strategy strategy=new JettonExchangStrategy();
		System.out.println("现有现金："+player.getCash().getValue());
		System.out.println("\n将所有筹码交换为现金：");
		strategy.Exchang(player.getJettons(), player.getCash());
		System.out.println("现有现金："+player.getCash().getValue());
		System.out.println("当前所有筹码：");
		player.printJettons();
		
		
		strategy=new CashExchangeStrategy();
		System.out.println("\n将所有现金转换为筹码：");
		strategy.Exchang(player.getJettons(), player.getCash());
		System.out.println("当前所有筹码：");
		player.printJettons();
		System.out.println("现有现金："+player.getCash().getValue());
		
		
		
		
		
		
		
	}
}
