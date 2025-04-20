package gamble;



public class WagerFactory {

    public  Wager getWager() {

        return new Wager();
    }
    
    private static WagerFactory wagerFactory=new WagerFactory();
    
    private  WagerFactory() {
		
	}
    
	public static WagerFactory getInstance() {
	
		return wagerFactory;
	}


   
}
