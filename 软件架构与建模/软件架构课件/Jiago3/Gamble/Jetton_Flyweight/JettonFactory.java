/**
 * Created by 谢东 on 2017/10/10.
 */
package Gamble.Jetton_Flyweight;



import Gamble.Jetton_Each;

import java.util.HashMap;
import java.util.Map;

public class JettonFactory {

    //管理Jetton实例
    private Map<Integer,Jetton_Each> pool = new HashMap<Integer, Jetton_Each>();

    //Singleton
    private static JettonFactory singleton = new JettonFactory();

    //获得单例
    public static JettonFactory getSingleton(){
        return singleton;
    }

    //Test USE
    public void showSize(){
        System.out.println("总共有："+pool.size()+"个对象");
    }

   // 共享实例
    public synchronized Jetton_Each getJetton(int value){
       if(pool.get(value)==null){
            Jetton_Each jeach = new Jetton_Each(value);
            pool.put(value,jeach);
            return  jeach;
       }
           return pool.get(value);
    }
}
