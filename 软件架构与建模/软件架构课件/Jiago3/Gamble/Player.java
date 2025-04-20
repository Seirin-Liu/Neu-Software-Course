/**
 * Created by 谢东 on 2017/10/10.
 */
package Gamble;

import Gamble.Asset_Adapter.Assert;
import Gamble.Asset_Adapter.Assert_Adapter;
import Gamble.Asset_Adapter.Jetton_Change;
import Gamble.Strategy.Strategy;
import Gamble.Wager.WagerFactory;
import Gamble.framework.*;

import java.util.Iterator;
import java.util.Scanner;

public class Player {

    private String name;
    private Strategy strategy;
    private Jetton jetton;
    private Assert as;
    private Product product;

    public Player(String name, Jetton jetton, Assert as) {

        this.name = name;
        this.jetton = jetton;
        this.as = as;
    }

    public String getName() {
        return name;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public Jetton getJetton() {
        return jetton;
    }

    public Assert getAs() {
        return as;
    }

    public Product getProduct() {
        return product;
    }

    //非现金财产装换
    public void Exchange(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要兑换的东西");
        String things = scanner.next();
        Jetton_Change jp = new Assert_Adapter(as.getCsah(),as.getProperty(),things);
        if(jp.getNumber() != 0) {
            jetton.setNumber(jetton.getNumber() + (jp.getNumber() / jetton.getFaceValue().getFace_value()));
            System.out.println("转换成功");
            System.out.println("当前筹码数为：" + jetton.getNumber());
        }
        else{
            System.out.println("您没有该物品，装换失败！！！");
        }
    }

    //购买赌注
    public boolean BuyWager(){
        if(jetton.getNumber()>0) {
            Factory fc = new WagerFactory();
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入压注数量");
            int num_of_wager = scanner.nextInt();//获取当前键入的
            if(num_of_wager<jetton.getNumber()){
                product = fc.create(num_of_wager);
                Jetton jt = new Jetton( num_of_wager,jetton.getFaceValue());
                product.addJetton(jt);
                jetton.setNumber(jetton.getNumber() - jt.getNumber());
                System.out.println("压注 "+num_of_wager+" 成功！");
                return  true;
            }
            else {
                System.out.println("压注失败！！");
                return false;
            }

        }
        else{
            System.out.println("压注失败！！");
            return false;
        }

    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    //筹码兑换现金
    public void ExchangeToCash(){
        System.out.println("兑换前： "+as.getCsah().getMoney());
        strategy.Exchang(jetton,as.getCsah());
        System.out.println("兑换后： "+as.getCsah().getMoney());

    }

    public void showProperty(){
        System.out.println("尊敬的"+name+"您的财产如下");
        System.out.println("现金:"+as.getCsah().getMoney());
        System.out.println("面额为 "+jetton.getFaceValue().getFace_value()+"的筹码 "+jetton.getNumber()+" 个");
        if(product!=null){
            System.out.println("赌注： "+product.getWager() );
        }

        System.out.println("其他物品：");
        Iterator<String> it = as.getProperty().iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }



}
