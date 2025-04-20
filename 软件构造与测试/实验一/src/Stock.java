import java.util.Scanner;

public class Stock {

    private int number;

    public int Stock(){
        System.out.println("枪托售出数量：");
        Scanner scanner = new Scanner(System.in);
        number= scanner.nextInt();

        return number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
