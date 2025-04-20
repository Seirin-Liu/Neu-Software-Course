/**
 * Created by 谢东 on 2017/10/10.
 */
package Gamble.Asset_Adapter;


import Gamble.Cash;

import java.util.ArrayList;


public class Assert {

    private Cash csah;
    private ArrayList<String> property = new ArrayList<String>();

    public Assert(Cash csah, ArrayList<String> property) {
        this.csah = csah;
        this.property = property;
    }

    public Assert() {
    }

    public void addProperty(String thing){
        property.add(thing);
    }

    public void removeProperty(String thing){
        property.remove(thing);
    }

    public void setProperty(ArrayList<String> property) {
        this.property = property;
    }


    public void setCsah(Cash csah) {
        this.csah = csah;
    }

    public Cash getCsah() {

        return csah;
    }
    public ArrayList<String> getProperty() {
        return property;
    }


    //返回总资产
    public double getSum_Assert(){
        double sum = 0;

        return sum;

    }
}
