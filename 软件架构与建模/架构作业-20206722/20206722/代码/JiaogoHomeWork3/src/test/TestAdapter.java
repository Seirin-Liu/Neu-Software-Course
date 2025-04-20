package test;

import java.util.ArrayList;

import gamble.Asset;
import gamble.AssetAdapter;
import gamble.Cash;
import gamble.Jetton;
import gamble.Player;

public class TestAdapter {

	
	public static void main(String[] args) {
		
		
		Player player = new Player();
		
		ArrayList<Asset> asserts = new ArrayList<Asset>();
		asserts.add(new Asset("iPhone12", 100));
		asserts.add(new Asset("iPhone11", 50));
		asserts.add(new Asset("iPhone10", 10));
		player.setAsserts(asserts);
		player.setCash(new Cash(10000));
		
		
		Jetton assetAdapter= new AssetAdapter(asserts.get(0));
		assetAdapter.getValue();

		
	}
}
