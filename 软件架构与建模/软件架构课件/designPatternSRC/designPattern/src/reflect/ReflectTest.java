package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class ReflectTest {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		//People p=new People();
		//People p1=new People();
//		Class c=p.getClass();
//		Class c1=p1.getClass();
//		if(c==c1)
//			System.out.println("They are same!");
		
		Scanner sc=new Scanner(System.in);
		
		Class c=Class.forName(sc.next());

		System.out.println(c.getName());
		
		int m=c.getModifiers();
		System.out.println(Modifier.toString(m));
		
		Field[] fields=c.getDeclaredFields();
		for(Field f: fields){
			System.out.println(Modifier.toString(f.getModifiers()));
			System.out.println(f.getType().getName());
			System.out.println(f.getName());
		}
		
		Method[] methords=c.getDeclaredMethods();
		for(Method me: methords){
			System.out.println(Modifier.toString(me.getModifiers()));
			System.out.println(me.getReturnType().getName());
			System.out.println(me.getName());
		}
		
	}

}
