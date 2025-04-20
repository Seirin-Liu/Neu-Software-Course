package First;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time  extends ReceiptDecoratot{

	public Time(Receipt receipt) {
		super(receipt);
		// TODO Auto-generated constructor stub
	}

	public void print() {
		receipt.print();
		addTime();
	}
	
	public void addTime() {
		    Date date = new Date();
	        String strDateFormat = "yyyy-MM-dd HH:mm";
	        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
	        //System.out.println("       **********    ");
	        System.out.println("     "+sdf.format(date)); 
	}
}
