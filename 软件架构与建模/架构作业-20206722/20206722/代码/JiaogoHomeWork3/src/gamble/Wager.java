
/**
 * ��ע
 */
package gamble;

import java.util.HashMap;
import java.util.Map.Entry;

public class Wager {

    private HashMap<Jetton, Integer> jettons=new HashMap<>();//��ע�����ĳ���
    private int sum=0;
    
	public HashMap<Jetton, Integer> getJettons() {
		return jettons;
	}

	public void setJettons(HashMap<Jetton, Integer> jettons) {
		this.jettons = jettons;
	}

	public Wager() {
		super();
	}
	

    public Wager(HashMap<Jetton, Integer> jettons) {
		super();
		this.jettons = jettons;
	}

	public int getSumValue(){
        sum = 0;
        for(Entry<Jetton,Integer> e:jettons.entrySet()) {
        	sum+=e.getValue()*e.getKey().getValue();
        }
        
        return sum;
    }
	
	public void printJettons() {
		int sum=0;
		System.out.println("������ֵ\t����");
		 for(Entry<Jetton,Integer> e:jettons.entrySet()) {
	        	System.out.println(e.getKey().getValue()+"\t"+e.getValue());
	        	sum+=e.getValue()*e.getKey().getValue();
	        }
		 System.out.println("��ע��ֵ��"+sum);
	}
	




}
