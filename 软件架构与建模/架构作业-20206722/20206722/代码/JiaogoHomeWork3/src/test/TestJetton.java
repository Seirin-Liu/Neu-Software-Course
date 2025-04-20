package test;

import gamble.JettonFactory;
import gamble.Player;
import gamble.Wager;
import gamble.WagerFactory;


public class TestJetton {

	public static void main(String[] args) {
		JettonFactory jettonFactory=JettonFactory.getInstance();
	
		Player player=new Player();
		player.getJettons().put(jettonFactory.getJetton(5),10);
		player.getJettons().put(jettonFactory.getJetton(10),5);
		player.getJettons().put(jettonFactory.getJetton(20),2);
		System.out.println("��ǰ���г��룺");
		player.printJettons();
		
		//�¶�ע��2��5����롢1��10�����
		Wager wager=WagerFactory.getInstance().getWager();
		wager.getJettons().put(jettonFactory.getJetton(5),2);
		wager.getJettons().put(jettonFactory.getJetton(10),1);
		System.out.println("��ע���룺");
		wager.printJettons();
		
		player.buyWager(wager.getJettons());
		System.out.println("��ע������");
		System.out.println("��ǰ���г��룺");
		player.printJettons();
		
		
		
		
	}
	
}
