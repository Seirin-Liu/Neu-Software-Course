/**
 * Created by 谢东 on 2017/10/10.
 */
package Gamble.Wager;

import Gamble.Jetton;
import Gamble.framework.Product;

import java.util.ArrayList;

public class Wager extends Product {

    private int number;
    private ArrayList<Jetton> jetton =new ArrayList<Jetton>();
    //private  Jetton jetton;

    public Wager( int number) {
        this.number = number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

//    public Jetton getJetton() {
//        return jetton;
//    }
//
//    public void setJetton(Jetton jetton) {
//        this.jetton = jetton;
//    }
    public void addJetton(Jetton jp){
        jetton.add(jp);

    }

    public ArrayList<Jetton> getJetton() {
        return jetton;
    }

    public int getWager(){
        int sum = 0;
        for (Jetton j:jetton) {
            sum += j.getNumber()*j.getFaceValue().getFace_value();
        }
        return sum;
    }

    public int getNumber() {
        return number;
    }
}
