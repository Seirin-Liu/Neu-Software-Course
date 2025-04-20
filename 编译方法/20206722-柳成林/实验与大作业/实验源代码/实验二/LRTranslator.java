package Ex2;

import java.util.ArrayList;
import java.util.Stack;

public class LRTranslator {

	/**
	 * 待分析的字符串
	 */
	String string;

	/**
	 * 列标数组
	 */
    String[] colName = {"i", "+", "*", "(", ")", "#",  "E",  "T",  "F"};

	/**
	 * SLR(0)分析表，为空的地方均用""来填充
	 */
	private String[][] table = {
			{"i8",   "",     "",     "(9",   "",     "",     "E1", "T4", "F7"},
			{"",     "+2",   "",     "",     "",     "OK",   "",   "",   ""},
			{"i8",   "",     "",     "(9",   "",     "",     "",   "T3", "F7"},
			{"",     "r(1)", "*5",   "",     "r(1)", "r(1)", "",   "",   ""},
			{"",     "r(2)", "*5",   "",     "r(2)", "r(2)", "",   "",   ""},
			{"i8",   "",     "",     "(9",   "",     "",     "",   "",   "F6"},
			{"r(3)", "r(3)", "r(3)", "r(3)", "r(3)", "r(3)", "",   "",   ""},
			{"r(4)", "r(4)", "r(4)", "r(4)", "r(4)", "r(4)", "",   "",   ""},
			{"r(6)", "r(6)", "r(6)", "r(6)", "r(6)", "r(6)", "",   "",   ""},
			{"i8",   "",     "",     "(9",   "",     "",     "E10","T4", "F7"},
			{"",     "+2",   "",     "",     ")11",  "",     "",   "",   ""},
			{"r(5)", "r(5)", "r(5)", "r(5)", "r(5)", "r(5)", "",   "",   ""},
	};

	/**
	 * 产生式数组
	 */
	String[][] production = { //每一个数组第一个字符串是左边的非终结字符
			{"Z", "E"},
			{"E", "E", "+", "T","GEQ+"}, {"E","T"},
			{"T", "T", "*", "F","GEQ*"}, {"T","F"},
			{"F", "(","E",")"}, {"F","i","PUSH"}
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
	 * 前一个单词
	 */
	String lastW = ""; //因为在执行PUSH时已经读到了下一个单词，而LR中的PUSH不能像LL1那样压栈处理

	/**
	 * 当前状态
	 */
	int currentState;

	/**
	 * 生成临时变量的下标
	 */
	int cnt=0;

	public LRTranslator(String string) {
		this.string = string;
	}


	/**
	 * 主程序控制函数
	 *
	 */
	public void analysis() {
		System.out.println("LR翻译过程：");
		System.out.println("SYN                                     s\tw   SEM");

		proc(string);//将字符串转为单词序列
		//首先将#0压栈
		SYN.push("#0");
		//得到第一个单词
        w = words.pop();
        while(!words.isEmpty()||!SYN.isEmpty()) {
			String x = SYN.peek();  // 得到栈顶字符串
			currentState = Integer.parseInt(x.substring(1)); //取栈顶状态数字
			printSYN(); //输出一列结果
			String result = findTable(currentState,w);  //查表得到结果

			if (result.equals("")) {
				 //出错
				System.out.println("查找状态为空");
				error();
			} else if (result.equals("OK")) {
				 //完成，跳出while
				System.out.println("分析结束");
				break;
			} else if (result.startsWith("r(")) {
				 //R=r(j) 规约
				reduction(result);
			} else {
				// R=wi 状态转换
				SYN.push(result);  //移进语法栈
				lastW = w;  //记录当前字符
				w = words.pop();//读下一个字符
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
	 * 规约
	 * @param result 表里返回的结果
	 */
	public void reduction(String result){
		//result为  r(i) 格式
		int index = Integer.parseInt(result.split("\\(")[1].split("\\)")[0]);  //得到表达式的index
		String left = production[index][0];  //产生式最左边的非终结符
		String right = production[index][production[index].length-1]; //产生式最右边的符号，要判断是不是动作符号
		int flag = 0;
		if(right.startsWith("GEQ")||right.equals("PUSH")){
			flag = 1;
			//先执行动作符号，判断是哪种，并执行
			if (right.startsWith("GEQ")) {
				GEQ(right.substring(3));  //GEQ方法，需要传入生成式的算符
			}
			else if (right.equals("PUSH")) {
				SEM.push(String.valueOf(lastW));  //压入上一个单词到语义栈
			}
		}
		//接下来执行规约操作
		for (int i = 1; i < production[index].length-flag; i++) { //对产生式右侧的每一个字符串进行循环
			//不是动作符号，分析栈的栈顶要弹出一个，因为是规约过程，有几个对应的弹几个
			SYN.pop();
		}
		//规约之后，需要计算新的栈顶状态
		String x = SYN.peek();  // 得到栈顶字符串
		currentState = Integer.parseInt(x.substring(1)); //取栈顶状态数字
		result = findTable(currentState,left);
		SYN.push(result);  //当前状态遇到规约后的非终结符发生的状态变化
	}


	/**
	 *
	 * @param state 状态
	 * @param w 遇到的字符
	 * @return
	 */
	private String findTable(int state, String w) {
		// colName = {"i", "+", "*", "(", ")", "#",  "E",  "T",  "F"};
		int row = state, column = -1;
		if ((w.charAt(0) >= '0' && w.charAt(0) <= '9') ||
				(w.charAt(0) >= 'a' && w.charAt(0) <= 'z')) {
			column = 0;//字母和数字
		}else {
			//循环找列标
			for (int i = 0; i < colName.length; i++) {
				if (colName[i] .equals(w) ) {
					column = i ;
				}
			}
		}
		if(column == -1){
			error();
		}
		return table[row][column]; //返回查询到的状态
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
	 * 表达式四元式生成函数，传入运算符
	 */
	public void GEQ(String op) {
		 cnt++;
		 String word1 = SEM.pop();//从语义栈中取出两个单词
		 String word0 = SEM.pop();
		 String qtr = "(" + op + "," + word0 + "," + word1 + ",t" + cnt + ")";//生成四元式
		 SEM.push("t" + cnt);//向语义栈中压入tn
		 QT.add(qtr);
	}

	public void error() {
		System.out.println("语法错误");
		System.exit(0);
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
		System.out.print(currentState);
		System.out.print("\t"+w);
		System.out.print("\t");
		for (String s:SEM){
			System.out.print(s+" ");
		}
		System.out.println();
	}

}
