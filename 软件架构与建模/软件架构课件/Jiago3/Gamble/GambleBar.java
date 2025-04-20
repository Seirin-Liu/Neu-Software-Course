/**
 * Created by 谢东 on 2017/10/10.
 */
package Gamble;


import Gamble.Asset_Adapter.Assert;
import Gamble.Jetton_Flyweight.JettonFactory;

import Gamble.Strategy.CashExchange_Strategy;

import java.util.ArrayList;
import java.util.Scanner;

public class GambleBar {

    private ArrayList<Player> player = new ArrayList<Player>();
    private ArrayList<String> p =new ArrayList<String>();
    private Scanner scanner = new Scanner(System.in);
    private Jetton_Each je;
    private boolean a = true;
    /*初始的个人物品*/
    public  GambleBar(){
        p.add("Iphone");
        p.add("Watch");
        p.add("Watch");
    }

    public void addPlayer(){
        int value;
        Cash cash = new Cash(100);//游戏初始的钱为100
        Assert as = new Assert(cash,p);//财产初始化
        System.out.println("请输入用户名");
        String name = scanner.next();
        System.out.println("您的筹码面额");
        value = scanner.nextInt();
        // System.out.println("name:"+name+"  mmiane"+value);
        je = JettonFactory.getSingleton().getJetton(value);
        System.out.println("请输入筹码数量");
        value = scanner.nextInt();
        Jetton jetton = new Jetton(value,je);
        player.add(new Player(name,jetton,as));
    }

    public void start(){
        for (Player p:player) {
                p.showProperty();
                if (p.BuyWager()) {//购买赌注
                    System.out.println("-------------------");
                    System.out.println("现在赌注数为： " + p.getProduct().getNumber());
                    System.out.println("现在筹码数为： " + p.getJetton().getNumber());
                    System.out.println("赌注总价值为： " + p.getProduct().getWager());
                    System.out.println("--------------------");
                }
                p.Exchange();//非现金财产装换
                p.showProperty();
                System.out.println("-------------------");
                p.setStrategy(new CashExchange_Strategy());
                p.ExchangeToCash();
                p.showProperty();
                System.out.println("-------------------");
                System.out.println();
                System.out.println("是否退出：是/false  否/tuue");
                a = scanner.nextBoolean();
        }
    }

}
