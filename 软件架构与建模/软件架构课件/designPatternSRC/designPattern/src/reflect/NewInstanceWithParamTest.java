package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class NewInstanceWithParamTest {

	/**
	 * 
	 * 动态生成对象：
	1.如果某个类的构造函数没有参数，则直接调用newInstance方法。

	2.如果某个类的构造函数有参数，则必须：
	1）指定参数的类型
	2）获取类的构造函数
	3）使用Constructor中定义的newInstance(Object[] args)来指定参数。
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws NoSuchMethodException 
	 * @throws SecurityException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		Class c=Class.forName("reflect.People");
		
		//指定参数类型
		Class[] params=new Class[3];
		params[0]=String.class;//.class获得一个类的类型。注意：如果是基本数据类型，那么要使用.TYPE
							//比如一个参数是int，则需使用params[0]=Integer.TYPE;
		params[1]=String.class;
		params[2]=String.class;
		
		//获取类的构造函数
		Constructor constructor=c.getConstructor(params);
		
		//使用Constructor中定义的newInstance(Object[] args)来指定参数。
		Object[] paramArgs=new Object[3];
		paramArgs[0]="jim";
		paramArgs[1]="2445135";
		paramArgs[2]="soft";
		
		Object o=constructor.newInstance(paramArgs);
		
		System.out.println(o);
		
		
	}

}
