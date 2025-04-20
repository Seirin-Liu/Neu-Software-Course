package gamble;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;


public class Player {


    private Cash cash;
  
    private ArrayList<Asset> asserts;
    
    private HashMap<Jetton, Integer> jettons; //玩家的所有筹码 筹码对应个数
    
    
    
	public Player(Cash cash, ArrayList<Asset> asserts) {
		super();
		this.cash = cash;
		this.asserts = asserts;
		this.jettons =new HashMap<>();
	
	}
	
	
	public Player() {
		super();
		this.jettons =new HashMap<>();
	}


	public Cash getCash() {
		return cash;
	}
	public void setCash(Cash cash) {
		this.cash = cash;
	}
	public ArrayList<Asset> getAsserts() {
		return asserts;
	}
	public void setAsserts(ArrayList<Asset> asserts) {
		this.asserts = asserts;
	}
	public HashMap<Jetton, Integer> getJettons() {
		return jettons;
	}
	public void setJettons(HashMap<Jetton, Integer> jettons) {
		this.jettons = jettons;
	}

	
	public void buyWager(HashMap<Jetton, Integer> jettons) {
		
		 for(Entry<Jetton,Integer> e:jettons.entrySet()) { 	
			 	int i=this.jettons.get(e.getKey())-e.getValue();
			 	if(i>0) {
			 		this.jettons.put(e.getKey(),i);
			 	}
			 	else {
			 		this.jettons.remove(e.getKey());
			 	}
	        }
	}
	
	public void buyWager(int cashValue) {
		cash.setValue(cash.getValue()-cashValue);
		System.out.println("下注总额："+cashValue);
		
	}
	

	
	public void cashBuyJettons(HashMap<Jetton, Integer> jettons) {
		 for(Entry<Jetton,Integer> e:jettons.entrySet()) {
			 cash.setValue(cash.getValue()-e.getKey().getValue()*e.getValue());
			 if(this.jettons.get(e.getKey())!=null) {
			 	int i=this.jettons.get(e.getKey())+e.getValue();
			 	this.jettons.put(e.getKey(), i);	 	
			 }
			 else {
				 this.jettons.put(e.getKey(), e.getValue());
			 }
			 	
	        }
	}
	public void assertBuyJettons(HashMap<Jetton, Integer> jettons) {
		 for(Entry<Jetton,Integer> e:jettons.entrySet()) {
			 if(this.jettons.get(e.getKey())!=null) {
			 	int i=this.jettons.get(e.getKey())+e.getValue();
			 	this.jettons.put(e.getKey(), i);	 	
			 }
			 else {
				 this.jettons.put(e.getKey(), e.getValue());
			 }
			 	
	        }
	}
	
	
	public void printJettons() {
		int sum=0;
		System.out.println("筹码面值\t数量");
		 for(Entry<Jetton,Integer> e:jettons.entrySet()) {
	        	System.out.println(e.getKey().getValue()+"\t"+e.getValue());
	        	sum+=e.getValue()*e.getKey().getValue();
	        }
		 System.out.println("筹码总值："+sum);
		 
	}
	
	public void printAsserts() {
		System.out.println("有形资产        价值");
		for (Asset a:asserts) {
			System.out.println(a.getAssertName()+"\t"+a.getValue());
		}
	}
	
	public void printInfo() {
		System.out.println("*****************");
		System.out.println("   当前个人信息   ");
		System.out.println("当前所有现金：");
		System.out.println(cash.getValue());
		System.out.println("当前所有筹码：");
		printJettons();
		System.out.println("当前所有有形资产：");
		printAsserts();
		System.out.println("*****************");
	}
	


    

}
