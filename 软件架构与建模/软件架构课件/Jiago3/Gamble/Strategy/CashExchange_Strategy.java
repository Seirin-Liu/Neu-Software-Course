/**
 * Created by 谢东 on 2017/10/10.
 */
package Gamble.Strategy;

import Gamble.Cash;
import Gamble.Jetton;

public class CashExchange_Strategy implements Strategy {

    @Override
    public void Exchang(Jetton jetton, Cash cash) {
        cash.setMoney(cash.getMoney()+jetton.getNumber()*40);
        jetton.setNumber(0);//兑换后重置jetton的数量
    }
}
