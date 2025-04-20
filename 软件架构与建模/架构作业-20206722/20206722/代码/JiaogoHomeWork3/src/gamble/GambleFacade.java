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
		System.out.println("1���������(����)");
		System.out.println("2���������(�����ʲ�)");
		System.out.println("3����ע(����)");
		System.out.println("4����ע(����)");
		System.out.println("5����ע(�����ʲ�)");
		System.out.println("6�������г���һ�Ϊ�ֽ�");
		System.out.println("============================");
		System.out.println("�����빦��: ");
	}

	public void start() {
		player.printInfo();
		menu();
		while (true) {
			@SuppressWarnings("resource")
			Scanner s = new Scanner(System.in);
			int k = s.nextInt();
			if (k <= 0 || k > 6) {
				System.out.println("��������ȷ������");
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

		System.out.println("����ɹ���\n");
		player.printInfo();

	}
	 public void assertBuyJettons() {
			HashMap<Jetton, Integer> jettons = new HashMap<>();
			
			Jetton assertJetton = new AssetAdapter(player.getAsserts().get(0));
			System.out.println("ʹ�������ʲ���"+player.getAsserts().get(0).getAssertName());
			player.getAsserts().remove(0);	
			jettons.put(assertJetton, 1);
			
			player.assertBuyJettons(jettons);
			System.out.println("����ɹ���\n");
			player.printInfo();
	 }
	 
	 public void jettonsBuyWager() {
			Wager wager = WagerFactory.getInstance().getWager();
			wager.getJettons().put(jettonFactory.getJetton(5), 2);
			wager.getJettons().put(jettonFactory.getJetton(10), 1);
			System.out.println("��ע���룺");
			wager.printJettons();
			System.out.println("��������������������");
			player.buyWager(wager.getJettons());
			System.out.println("��������������������");
			System.out.println("��ע����\n");
			player.printInfo();

	 }
	 
	 public void cashBuyWager() {
		 
		 player.buyWager(1000);
		 System.out.println("���ؽ���");
		 player.printInfo();
	 }
	 
	 public void assertBuyWager() {
		    Wager wager = WagerFactory.getInstance().getWager();
			HashMap<Jetton, Integer> jettons = new HashMap<>();
			Jetton assertJetton = new AssetAdapter(player.getAsserts().get(0));
			System.out.println("ʹ�������ʲ���"+player.getAsserts().get(0).getAssertName());
			player.getAsserts().remove(0);	
			jettons.put(assertJetton, 1);
			wager.setJettons(jettons);
		
			System.out.println("��ע���룺");
			wager.printJettons();
			player.assertBuyJettons(wager.getJettons());
			System.out.println("��������������������");
			System.out.println("��ע����\n");
			player.printInfo();
	 }
	 
	 public void jettonsExchangeCash() {
			Strategy strategy = new JettonExchangStrategy();

			System.out.println("\n�����г��뽻��Ϊ�ֽ�");
			strategy.Exchang(player.getJettons(), player.getCash());

			player.printInfo();
	 }
}
