package test;

import java.util.ArrayList;

import gamble.Asset;
import gamble.Cash;
import gamble.GambleFacade;

import gamble.Player;

public class TestFacade {

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
}
