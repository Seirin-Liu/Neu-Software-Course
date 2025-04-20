public class Main {
    public static void main(String[] args) {
        while(true) {
            int barrelNumber, stockNumber, lockNumber;
            Lock lock = new Lock();
            Stock stock = new Stock();
            Barrel barrel = new Barrel();
            barrelNumber = barrel.Barrel();
            lockNumber = lock.Lock();
            stockNumber = stock.Stock();

            if (barrelNumber > 0 && barrelNumber <= 90 && stockNumber > 0 && stockNumber <= 70 && lockNumber > 0 && lockNumber <= 80) {
                System.out.println("输入正确");
                System.out.println("销售商的总销售额为：");
                int sum_money = barrelNumber * 25 + stockNumber * 45 + lockNumber * 30;
                System.out.println(sum_money);
                double commission = 0;
                if (sum_money <= 1000) {
                    commission = sum_money * 0.1;
                } else if (sum_money <= 1800) {
                    commission = (sum_money - 1000) * 0.15 + 100;
                } else {
                    commission = (sum_money - 1800) * 0.2 + 100 + 120;
                }
                System.out.println("佣金为：" + commission);
            } else {
                System.out.println("输入值异常");
            }
        }


    }
}
