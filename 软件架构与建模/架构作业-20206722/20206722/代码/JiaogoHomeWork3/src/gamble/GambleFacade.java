package gamble;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class GambleFacade {

	private Player player;
	
	JettonFactory jettonFactory = JettonFactory.getInstance();
	WagerFactory wagerFactory=WagerFactory.getInstance();

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void menu() {
		System.out.println("============================");
		System.out.println("1、购买筹码(货币)");
		System.out.println("2、购买筹码(有形资产)");
		System.out.println("3、下注(筹码)");
		System.out.println("4、下注(货币)");
		System.out.println("5、下注(有形资产)");
		System.out.println("6、将所有筹码兑换为现金");
		System.out.println("============================");
		System.out.println("请输入功能: ");
	}

	public void start() {
		player.printInfo();
		menu();
		while (true) {
			@SuppressWarnings("resource")
			Scanner s = new Scanner(System.in);
			int k = s.nextInt();
			if (k <= 0 || k > 6) {
				System.out.println("请输入正确的命令");
			}
			switch (k) {
			case 1:
				cashBuyJettons();
				menu();
				break;
			case 2:				
				assertBuyJettons();
				menu();
				break;
			case 3:
				jettonsBuyWager();
				menu();
				break;
			case 4:
				cashBuyWager();
				menu();
				break;
			case 5:
				assertBuyWager();
				menu();
				break;
			case 6:
				jettonsExchangeCash();
				menu();
				break;
			}

		}

	}

	public static void main(String[] args) {

		GambleFacade gamble = new GambleFacade();
		Player player = new Player();
		ArrayList<Asset> asserts = new ArrayList<Asset>();
		asserts.add(new Asset("iPhone12", 100));
		asserts.add(new Asset("iPhone11", 50));
		asserts.add(new Asset("iPhone10", 10));
		player.setAsserts(asserts);
		player.setCash(new Cash(10000));
		gamble.setPlayer(player);
		gamble.start();

	}
	
	
	public void cashBuyJettons() {
		HashMap<Jetton, Integer> jettons = new HashMap<>();
		jettons.put(jettonFactory.getJetton(5), 10);
		jettons.put(jettonFactory.getJetton(10), 5);
		jettons.put(jettonFactory.getJetton(20), 2);
		player.cashBuyJettons(jettons);

		System.out.println("购买成功！\n");
		player.printInfo();

	}
	 public void assertBuyJettons() {
			HashMap<Jetton, Integer> jettons = new HashMap<>();
			
			Jetton assertJetton = new AssetAdapter(player.getAsserts().get(0));
			System.out.println("使用有形资产："+player.getAsserts().get(0).getAssertName());
			player.getAsserts().remove(0);	
			jettons.put(assertJetton, 1);
			
			player.assertBuyJettons(jettons);
			System.out.println("购买成功！\n");
			player.printInfo();
	 }
	 
	 public void jettonsBuyWager() {
			Wager wager = WagerFactory.getInstance().getWager();
			wager.getJettons().put(jettonFactory.getJetton(5), 2);
			wager.getJettons().put(jettonFactory.getJetton(10), 1);
			System.out.println("下注筹码：");
			wager.printJettons();
			System.out.println("——————————");
			player.buyWager(wager.getJettons());
			System.out.println("——————————");
			System.out.println("下注结束\n");
			player.printInfo();

	 }
	 
	 public void cashBuyWager() {
		 
		 player.buyWager(1000);
		 System.out.println("下载结束");
		 player.printInfo();
	 }
	 
	 public void assertBuyWager() {
		    Wager wager = WagerFactory.getInstance().getWager();
			HashMap<Jetton, Integer> jettons = new HashMap<>();
			Jetton assertJetton = new AssetAdapter(player.getAsserts().get(0));
			System.out.println("使用有形资产："+player.getAsserts().get(0).getAssertName());
			player.getAsserts().remove(0);	
			jettons.put(assertJetton, 1);
			wager.setJettons(jettons);
		
			System.out.println("下注筹码：");
			wager.printJettons();
			player.assertBuyJettons(wager.getJettons());
			System.out.println("——————————");
			System.out.println("下注结束\n");
			player.printInfo();
	 }
	 
	 public void jettonsExchangeCash() {
			Strategy strategy = new JettonExchangStrategy();

			System.out.println("\n将所有筹码交换为现金：");
			strategy.Exchang(player.getJettons(), player.getCash());

			player.printInfo();
	 }
}
