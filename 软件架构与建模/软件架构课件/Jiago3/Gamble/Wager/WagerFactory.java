/**
 * Created by 谢东 on 2017/10/10.
 */
package Gamble.Wager;

import Gamble.framework.Factory;
import Gamble.framework.Product;

import java.util.ArrayList;

public class WagerFactory extends Factory {

    private ArrayList<Wager> owners = new ArrayList<Wager>();

    protected Product creatWager(int number) {

        return new Wager(number);
    }

    @Override
    protected void registerWager(Product product) {
        owners.add((Wager) product);
    }

    public ArrayList<Wager> getWager() {
        return owners;
    }
}
