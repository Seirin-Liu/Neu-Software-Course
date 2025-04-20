/**
 * Created by 谢东 on 2017/10/10.
 */
package Gamble.framework;

import Gamble.Jetton;

import java.util.ArrayList;

public abstract class Product {

    public abstract void setNumber(int number);
    public abstract ArrayList<Jetton> getJetton();
    public abstract void addJetton(Jetton jp);
    //public abstract Jetton getJetton();
    //public abstract void setJetton(Jetton jetton);
    public abstract int getNumber();
    public abstract int getWager();

}
