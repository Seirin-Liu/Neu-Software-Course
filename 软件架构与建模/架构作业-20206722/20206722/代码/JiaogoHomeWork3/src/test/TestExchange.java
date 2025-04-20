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
		System.out.println("��ǰ���г��룺");
		player.printJettons();
		
		Strategy strategy=new JettonExchangStrategy();
		System.out.println("�����ֽ�"+player.getCash().getValue());
		System.out.println("\n�����г��뽻��Ϊ�ֽ�");
		strategy.Exchang(player.getJettons(), player.getCash());
		System.out.println("�����ֽ�"+player.getCash().getValue());
		System.out.println("��ǰ���г��룺");
		player.printJettons();
		
		
		strategy=new CashExchangeStrategy();
		System.out.println("\n�������ֽ�ת��Ϊ���룺");
		strategy.Exchang(player.getJettons(), player.getCash());
		System.out.println("��ǰ���г��룺");
		player.printJettons();
		System.out.println("�����ֽ�"+player.getCash().getValue());
		
		
		
		
		
		
		
	}
}
