/**
 * Created by 谢东 on 2017/10/10.
 */
package Gamble.Asset_Adapter;

import Gamble.Cash;

import java.util.ArrayList;
import java.util.Iterator;

public class Assert_Adapter extends Assert implements Jetton_Change {

    private String change;

    public Assert_Adapter(Cash csah, ArrayList<String> property, String change) {
        super(csah, property);
        this.change = change;
    }

    public Assert_Adapter(String change) {
        this.change = change;
    }

    @Override
    public int getNumber() {
       int temp = 0;
        Iterator<String> it = super.getProperty().iterator();
        while (it.hasNext()){
            if(it.next().equals(change)){
                temp += 1000;
                it.remove();
            }
        }

        return temp;
    }

}
