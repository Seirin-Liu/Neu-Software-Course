import java.util.Scanner;

public class Lock {

    public int number;

    public int Lock(){
        System.out.println("枪机售出数量：");
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
