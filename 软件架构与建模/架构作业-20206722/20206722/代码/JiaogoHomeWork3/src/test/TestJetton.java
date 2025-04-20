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
		System.out.println("当前所有筹码：");
		player.printJettons();
		
		//下赌注：2个5块筹码、1个10块筹码
		Wager wager=WagerFactory.getInstance().getWager();
		wager.getJettons().put(jettonFactory.getJetton(5),2);
		wager.getJettons().put(jettonFactory.getJetton(10),1);
		System.out.println("下注筹码：");
		wager.printJettons();
		
		player.buyWager(wager.getJettons());
		System.out.println("下注结束：");
		System.out.println("当前所有筹码：");
		player.printJettons();
		
		
		
		
	}
	
}
