package Ex1;

public class Main {

    public static void main(String[] args) {
//        String string = " begin\n " +
//                "int a := 243; \n" +
//                "end";
//        String string = "a:=5;\n" +
//                "b:=6;\n" +
//                "begin\n" +
//                "\tc:=a+b;\n" +
//                "end;\n";
//        String string = ";;";
        String string = "a!1;";
        System.out.println("字符串："+string);

        MyScanner myScanner = new MyScanner();
        myScanner.execute(string);
        myScanner.printResult();
    }


}
