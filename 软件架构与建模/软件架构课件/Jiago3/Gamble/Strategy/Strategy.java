/**
 * Created by 谢东 on 2017/10/10.
 */
package Gamble.Strategy;

import Gamble.Cash;
import Gamble.Jetton;

public interface Strategy {
    public abstract void Exchang(Jetton jetton, Cash cash);

}
