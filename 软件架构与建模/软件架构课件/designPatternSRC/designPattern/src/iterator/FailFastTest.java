package iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class FailFastTest {

	public static void main(String[] args) {
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("haha");
		arrayList.add("hehe");
		arrayList.add("xixi");
		
		Iterator<String> iterator = arrayList.iterator();
		
		//create a new thread to traverse using iterator.	
		new Thread(){
			public void run() {
				while(iterator.hasNext()){
					System.out.println(iterator.next());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
		
		//main thread try to change the aggregate: 
		//Fail-fast Iterator throws an exception
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		arrayList.add("wawa");
	}

}
