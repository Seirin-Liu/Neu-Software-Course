package test;

public class Test {

    public static String test(int Lock_num, int Stock_num, int Barrel_num, int num) {

            System.out.println("\n测试用例"+num+":");
            if(Barrel_num>90||Stock_num>80||Lock_num>70){
                System.out.println("输入值异常");
                return "输入值异常";
            }else if(Barrel_num<1||Stock_num<1|Lock_num<1){
                System.out.println("输入值异常");
                return "输入值异常";
            }
            int sum=Barrel_num*25+Lock_num*45+Stock_num*30;
            double commission=0;
            if (sum <= 1000) {
                commission = sum*0.1;
            }else if(sum<=1800){
                commission = (sum-1000)*0.15+100;
            }else {
                commission = (sum-1800)*0.2+220;
            }
            System.out.println("总的销售额为："+sum);
            System.out.println("佣金为"+commission);
            String s = sum+","+commission;
            return s;

    }


}
