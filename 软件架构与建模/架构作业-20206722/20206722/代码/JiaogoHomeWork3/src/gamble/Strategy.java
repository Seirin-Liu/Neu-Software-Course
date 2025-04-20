

package gamble;

import java.util.HashMap;


public interface Strategy {
    public abstract void Exchang(HashMap<Jetton, Integer> jettons, Cash cash);
    public abstract void Exchang(HashMap<Jetton, Integer> jettons, int cashValue);
}
