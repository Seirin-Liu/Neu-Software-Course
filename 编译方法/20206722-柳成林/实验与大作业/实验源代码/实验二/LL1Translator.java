package Ex2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class LL1Translator {
	/**
	 * 待分析的字符串
	 */
	String string;

	/**
	 * 非终结符号数组
	 */
	String[] VN = {"E", "E1", "T", "T1", "F"};

	/**
	 * 终结符号数组
	 */
    String[] VT = {"i", "+", "-", "*", "/", "(", ")", "#"};

	/**
	 * LL(1)分析表，为空的地方均用数字0来填充
	 */
	int[][] table = {
            {1, 0, 0, 0, 0, 1,  0, 0},  //E
            {0, 2, 3, 0, 0, 0,  4, 4},  //E'
            {5, 0, 0, 0, 0, 5,  0, 0},  //T
            {0, 8, 8, 6, 7, 0,  8, 8},  //T'
            {9, 0, 0 ,0, 0, 10, 0, 0}   //F
    };

	/**
	 * 产生式数组
	 */
	String[][] production = {//ε用&表示
            {"T", "E1"},
			{"+", "T", "GEQ+", "E1"}, {"-", "T", "GEQ-", "E1"}, {"&"},
            {"F", "T1"},
			{"*", "F", "GEQ*", "T1"}, {"/", "F", "GEQ/", "T1"}, {"&"},
            {"i", "PUSH"}, {"(", "E", ")"}
    };

	/**
	 * 分析栈
	 */
	Stack<String> SYN = new Stack<String>();

	/**
	 * 语义栈
	 */
	Stack<String> SEM = new Stack<String>();

	/**
	 * 四元式列表
	 */
    ArrayList<String> QT = new ArrayList<String>();

	/**
	 * 单词栈
	 */
	Stack<String> words = new Stack<String>();

	/**
	 * 当前单词
	 */
    String w = "";

	/**
	 * 当前分析栈弹出的内容
	 */
	String x = "";

	/**
	 * 生成临时变量的下标
	 */
	int cnt=0;


	public LL1Translator(String string) {
		this.string = string;
	}


	/**
	 * 语法制导翻译函数
	 *
	 */
	public void analysis() {
		System.out.println("LL1翻译过程：");
		System.out.println("SYN                                     x       w   SEM");

		proc(string);//将字符串转为单词序列
		//首先将#E压栈
		SYN.push("#");
        SYN.push("E");
		//得到第一个单词
        w = words.pop();
        while(!words.isEmpty()||!SYN.isEmpty()) {//从分析栈中弹出单词
        	 if (SYN.isEmpty()) {
                 error();
                 return;
             }
			 printSYN();
             x = SYN.pop(); //x是当前分析栈栈顶
			 if(x.startsWith("GEQ")) { //如果是GEQ，生成四元式
				 GEQ();
			 }
			 else if(x.startsWith("PUSH")){
				 //执行PUSH操作
				 SEM.push(x.substring(4));//压入语义栈
			 }
			 //如果是终结符，处理终结符，错误处理，读取下一个单词
			 else if(Arrays.asList(VT).contains(x) && !x.equals("#")){
				 dealVT();
			 }
			 //如果是非终结符，查表并将产生式右部逆序压栈
			 else if(Arrays.asList(VN).contains(x)){
				 dealVN();
			 }
         }//while
         if (w.equals("#")) {
        	 System.out.println("四元式：");
             for (String string : QT) {
                 System.out.println(string);
             }
         } else {
             error();
         }
        }

	/**
	 * 处理终结字符
	 * @return
	 */
	public void dealVT() {
	        switch (x) {
				case "i"://标识符或常数
					for (int i = 0; i < w.length(); i++) {
						if (!((w.charAt(i) >= '0' && w.charAt(i) <= '9')
								|| (w.charAt(i) >= 'a' && w.charAt(i) <= 'z'))) {
							error();
						}
					}
	                break;
	            case "+"://加减
					if(!w.equals("+")){
						error();
					}
					break;
				case "-"://加减
					if(!w.equals("-")){
						error();
					}
					break;
	            case "*"://乘除
					if(!w.equals("*")){
						error();
					}
					break;
				case "/"://乘除
					System.out.println(1);
					if(!w.equals("/")){
						error();
					}
					break;
	            case "(":
					if(!w.equals("(")){
						error();
					}
	                break;
	            case ")":
					if(!w.equals(")")){
						error();
					}
	                break;
	            default:
					error();
	        }
	        if (words.isEmpty()) {
				error();
	        }
	        w = words.pop();
	    }

	/**
	 * 处理非终结字符
	 * @return
	 */
	public void dealVN() {
		// TODO Auto-generated method stub
		int index=table[getRow()][getCol()]-1;//查LL1分析表
		if(index==-1) { //遇到了0，表中不存在这个转换
			error();
		}
		//查到,逆序压栈
	    for (int i = production[index].length - 1; i >= 0; i--) {
	        if (production[index][i].equals("&")) {
	            continue;
	        }
			if(production[index][i].equals("PUSH")){
				//将需要压栈的字符也压进去 w：当前单词
				SYN.push(production[index][i]+w);
			}
			else {
				SYN.push(production[index][i]);
			}
	    }
	}


	/**
	 * 得到列标
	 * @return
	 */
	public int getCol() {
		String w = this.w;
        if ((this.w.charAt(0) >= '0' && this.w.charAt(0) <= '9') || (this.w.charAt(0) >= 'a' && this.w.charAt(0) <= 'z')) {
            w = "i";
        }
        for (int i = 0; i < VT.length; i++) {
            if (w.equals(VT[i])) {
                return i;
            }
        }
        return 0;
	}

	/**
	 * 得到行标
	 * @return
	 */
	public int getRow() {
		 for (int i = 0; i < VN.length; i++) {
	            if (x.equals(VN[i])) {
	                return i;
	            }
	        }
	     return 0;
	}

	/**
	 * 将字符串转换为单词序列，相当于词法分析
	 * @param string
	 */
	public void proc (String string) {
		int i;
		for (i= string.length()-1; i>=0; i--) {
			String s = "";
			char ch = string.charAt(i);
			boolean flag = false;
			while (ch >= '0' && ch <= '9') {
				//多个数字相连
				flag = true;
				s = ch + s;
				i--;
				if (i < 0) {
					break;
				}
				ch = string.charAt(i);
			}
			if (flag) {
				i++;
				words.push(s);
			}
			else {
				words.push(ch + s);
			}
		}
	}

	/**
	 * 表达式四元式生成函数
	 */
	public void GEQ() {
		 cnt++;
		 String word1 = SEM.pop();//从语义栈中取出两个单词
		 String word0 = SEM.pop();
		 String op = x.substring(3);
		 String qtr = "(" + op + "," + word0 + "," + word1 + ",t" + cnt + ")";//生成四元式
		 SEM.push("t" + cnt);//向语义栈中压入tn
		 QT.add(qtr);
	}

	public void error() {
		System.out.println("语法错误");
		System.exit(0);

		int i ;
		for (i = 0; i<10; i++){
			System.out.println(i*4);
		}


	}

	/**
	 * 输出一行结果
	 */
	public void printSYN(){
		int length = 0;
		for (String s:SYN){
			length += s.length()+1;
			System.out.print(s+" ");
		}
		for(int i=0;i<40-length;i++){
			System.out.print(" ");
		}
		System.out.print(x);
		for(int i=0;i<8-x.length();i++){
			System.out.print(" ");
		}
		System.out.print(w);
		System.out.print("\t");
		for (String s:SEM){
			System.out.print(s+" ");
		}
		System.out.println();
	}

}
