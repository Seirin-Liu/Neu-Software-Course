/**
 * Created by 谢东 on 2017/10/10.
 */
package Gamble.framework;

public abstract class Factory {

    public final Product create(int number){
            Product p =creatWager(number);
            registerWager(p);
            return p;
    }
    protected abstract Product creatWager(int number);
    protected abstract void registerWager(Product product);
}
