package Ex2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String str;
        Scanner sc=new Scanner(new FileReader("src/Ex2/String.txt"));
        //按行读取并分析
        while (sc.hasNext()) {
            str = sc.nextLine();
            System.out.println(str);
            //生成 translator
            LRTranslator lrTranslator = new LRTranslator(str);
            lrTranslator.analysis(); //执行分析操作
            System.out.println();
//            //生成 translator
//            LL1Translator ll1Translator =new LL1Translator(str); //在构造方法里传入待分析的字符串
//            ll1Translator.analysis(); //执行分析操作
        }
    }
}
