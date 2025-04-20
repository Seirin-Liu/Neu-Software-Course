import java.util.Scanner;

public class Barrel {

    private int number;

    public int Barrel(){
        System.out.println("枪管售出数量：");
        Scanner scanner = new Scanner(System.in);
        number= scanner.nextInt();

        return number;
    }

    public int getNumber() { return number; }
    public void setNumber(int number) { this.number = number; }
}
