package Ex1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.pow;

public class MyScanner {

    //状态转换矩阵，
    int aut[][] = {
            {0, 0, 0, 0, 0, 0, 0,  0},
            {0,2, 0, 0, 0,  8, 9,  15},
            {0,2, 3, 5, 11, 0, 0,  11},
            {0,4, 0, 0, 0,  0, 0,  0},
            {0,4, 0, 5, 11, 0, 0,  11},
            {0,7, 0, 0, 6,  0, 0,  0},
            {0,7, 0, 0, 0,  0, 0,  0},
            {0,7, 0, 0, 11, 0, 0,  11},
            {0,8, 0, 0, 0,  8, 0,  12},
            {0,0, 0, 0, 0,  0, 10, 14},
            {0,0, 0, 0, 0,  0, 0,  13},
            {0,0, 0, 0, 0,  0, 0,  0},
            {0,0, 0, 0, 0,  0, 0,  0},
            {0,0, 0, 0, 0,  0, 0,  0},
            {0,0, 0, 0, 0,  0, 0,  0},
            {0,0, 0, 0, 0,  0, 0,  0},};
    //关键字表
    String[] keywords = {"program","begin","end","var","while","do","repeat"
            ,"until","for","to","if","then","else",};
    //界符表
    String[] delimiters = { ";",":", "(", ")", ",", ":=", "+", "-", "*", "/",
            ">", ">=", "==", "<", "<="};
    int num_key = 13;   int num_del = 15;

    String[] identifiers = new String[50]; //符号表
    Double[] constants = new Double[20];
    int num_ide = 0, num_con = 0; //标识符和常量的个数

    //其他变量
    Token[] tokens = new Token[100]; //Token数组
    int i_token=0,num_token=0;  //Token计数器和Token个数
    int state = 0; //当前状态
    int n,p,m,e,a,t; // 尾数值、指数值、小数位数、指数符号、类型
    double num; //常数值
    String w = ""; //源程序缓冲区
    int i_w = 0; //源程序指针

    String strTOKEN = "";   //当前已经识别出的单词

    //定义map
    List<ColMap> col1 = new ArrayList<>(Arrays.asList(
            new ColMap[]{new ColMap("0123456789",1),
            new ColMap(".",2),
            new ColMap("Ee",3),
            new ColMap("+-",4)}));
    List<ColMap> col2 = new ArrayList<>(Arrays.asList(
            new ColMap[]{new ColMap("abcdefghijklmnopqrstuvwxyz",5),
            new ColMap("0123456789",1)}));
    List<ColMap> col3 = new ArrayList<>(Arrays.asList(new ColMap[]{new ColMap(";:(),+-*/=><",6)}));
    List<ColMap> ptr;

    /**
     * 查状态表返回下一个状态
     * @param s 当前状态
     * @param ch 当前字符
     * @return 返回next状态
     */
    public int find(int s ,char ch){
        int col = 7;
        // 遍历map数组, 由此根据状态表得到下一状态
        if (ch == 0) {
            return aut[s][col];
        }
        // 对map遍历，如果map中的字符串中含有该字符，返回该map的col
        for (ColMap cm : ptr){
            if (cm.str.contains(ch + "")){     //搜索找出第一个匹配
                col =cm.col;
                break;
            }
        }
        return aut[s][col]; //下一个状态
    }

    /**
     *状态转换执行
     * @param state 状态
     */
    public void act(int state){
        if(state == 1){
            //起始状态
            System.out.print("\n");
        }
        System.out.print("state:"+state +" -> ");
        int value;
        switch (state)
        {
            case 1:
                n=0;m=0;p=0;t=0;e=1;num=0; //其它变量初始化
                strTOKEN = "";
                break;
            case 2:
                n=10*n+w.charAt(i_w)-48;
                break;
            case 3:
                t=1;
                break;
            case 4:
                n=10*n+w.charAt(i_w)-48; m++;
                break;
            case 5:
                t=1;
                break;
            case 6:
                if (w.charAt(i_w)=='-') {e=-1;}
                break;
            case 7:
                p=10*p+w.charAt(i_w)-48;
                break;
            case 8:
                strTOKEN+=w.charAt(i_w);  //将ch中的符号拼接到strTOKEN的尾部；
                break;
            case 9:
                strTOKEN+=w.charAt(i_w);  //将ch中的符号拼接到strTOKEN的尾部；
                break;
            case 10:
                strTOKEN+=w.charAt(i_w); //将ch中的符号拼接到strTOKEN的尾部；
                break;
            case 11:num=n*pow(10,e*p-m);           //计算常数值
                tokens[i_token++] = new Token(2,insertConstant(num));
                num_token++;
                break;
            case 12:
                value=reserveKey(strTOKEN);                   //查关键字表
                if (value != -1) {
                    tokens[i_token++] = new Token(3,value);
                }   //生成关键字Token
                else {
                    tokens[i_token++] = new Token(1,insertIdentifier(strTOKEN));
                }    //生成标识符Token
                num_token++;
                break;
            case 13:
                value=reserveDel(strTOKEN);                    //查界符表
                if (value != -1) {
                    tokens[i_token++] = new Token(4,value); //生成界符Token
                }
                else {
                    //单界符
                    i_w--;
                    strTOKEN = strTOKEN.substring(0,strTOKEN.length()-1);
                    value=reserveDel(strTOKEN);                 //查界符表
                    tokens[i_token++] = new Token(4,value); //生成界符Token
                }
                num_token++;
                break;
            case 14:
                value=reserveDel(strTOKEN);                   //查界符表
                if(value != -1){
                    tokens[i_token++] = new Token(4,value);  //生成界符Token
                    num_token++;
                }
                //如果不是界符，什么都不做，或者输出异常，这里选择输出
                else {
                    System.err.println("不存在该界符："+strTOKEN+w.charAt(i_w)+" 词法错误");
                    System.exit(0);
                }
                break;
        }
    }

    /**
     * 执行扫描器
     * @param string 待扫描的字符串
     */
    public void execute(String string){
        w = string;
        w += "\0";
        while (i_w <w.length()){
            while (w.charAt(i_w)==' '){ //空字符处理
                i_w++;
            }
            if (w.charAt(i_w) >= 'A' && w.charAt(i_w) <= 'z') { //字母
                ptr = col2;
            }
            else if (w.charAt(i_w) >= '0' && w.charAt(i_w) <= '9') { //数字
                ptr = col1;
            }
            else if (col3.get(0).str.indexOf(w.charAt(i_w)) != -1) {
                // 界符打头
                ptr = col3;
            }
            else {
                //其他符号,词法错误
                System.err.println("词法错误："+ w.charAt(i_w));
                System.exit(0);
            }
            i_w--;
            state = 1;
            // 这个循环用于识别一个单词
            while(state != 0){ //执行Act
                act(state);
                if (state >= 11 && state <= 14){
                    break;
                }
                i_w++;
                if(i_w <w.length()) {
                    state = find(state, w.charAt(i_w));
                }
                else {
                    break;
                }
            }
            // 发生了词法错误, 即该词无法被识别成一个 Ex1.Token
            if (state == 0) {
                System.err.println("词法错误："+ strTOKEN+w.charAt(i_w));
                System.exit(0);
            }
        }
    }


    /**
     * 输出结果
     */
    public void printResult(){
        int i;
        System.out.println();
        System.out.print("\n关键词表：");
        List<Integer> values = new ArrayList<>();
        for (i=0;i<num_token;i++){
            if(tokens[i].code == 3){
                if(values.contains(tokens[i].value)){
                    continue;
                }
                else {
                    System.out.print(keywords[tokens[i].value] + "  ");
                    values.add(tokens[i].value);
                }

            }
        }
        System.out.println();
        System.out.print("界符表：");
        values = new ArrayList<>();
        for (i=0;i<num_token;i++){
            if(values.contains(tokens[i].value)){
                continue;
            }
            else {
                System.out.print(delimiters[tokens[i].value] + "  ");
                values.add(tokens[i].value);
            }
        }
        System.out.println();
        System.out.print("token表：");
        for (i=0;i<num_token;i++){
            System.out.print(tokens[i]+"  ");
        }
        System.out.println();
        System.out.print("常数表：");
        for (i=0;i<num_con;i++){
            System.out.print(constants[i]+"  ");
        }
        System.out.println();
        System.out.print("标识符表：");
        for (i=0;i<num_ide;i++){
            System.out.print(identifiers[i]+"  ");
        }
    }



    /**
     * 查找关键词表
     * @param str
     * @return 0：不在表中 i：表中的位置
     */
    public int reserveKey(String str){
        int i;
        for (i=0;i<num_key;i++){
            if (keywords[i].equals(str)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 查找界符表
     * @param str
     * @return 0：不在表中 i：表中的位置
     */
    public int reserveDel(String str){
        int i;
        for (i=0;i<num_del;i++){
            if (delimiters[i].equals(str)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 将标识符字符串插入标识符表
     * @param str
     * @return i 表中的位置
     */
    int insertIdentifier(String str) {
        int i;
        for (i = 0; i < num_ide; i++){
            if (identifiers[i].equals(str)){
                return i;
            }
        }
        identifiers[i] = str;
        num_ide++;
        return i;
    }


    /**
     * 将常数插入常数表中
     * @param num
     * @return i 表中的位置
     */
    public int insertConstant(double num) {
        int i;
        for (i = 0; i < num_con; i++){
            if (num == constants[i]){
                return i;
            }
        }
        constants[i] = num;
        num_con++;
        return i;
    }




}
