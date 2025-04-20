/**
 * Created by 谢东 on 2017/10/10.
 */
package Gamble;

import Gamble.Asset_Adapter.Jetton_Change;

public class Jetton implements Jetton_Change{
    private int number;//筹码数量
    private Jetton_Each value;//面值

    public Jetton(int number, Jetton_Each value) {
        this.number = number;
        this.value = value;
    }

    public Jetton_Each getFaceValue() {
        return value;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


}
