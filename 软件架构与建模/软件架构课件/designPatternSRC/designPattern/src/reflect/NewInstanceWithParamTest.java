package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class NewInstanceWithParamTest {

	/**
	 * 
	 * ��̬���ɶ���
	1.���ĳ����Ĺ��캯��û�в�������ֱ�ӵ���newInstance������

	2.���ĳ����Ĺ��캯���в���������룺
	1��ָ������������
	2����ȡ��Ĺ��캯��
	3��ʹ��Constructor�ж����newInstance(Object[] args)��ָ��������
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
		
		//ָ����������
		Class[] params=new Class[3];
		params[0]=String.class;//.class���һ��������͡�ע�⣺����ǻ����������ͣ���ôҪʹ��.TYPE
							//����һ��������int������ʹ��params[0]=Integer.TYPE;
		params[1]=String.class;
		params[2]=String.class;
		
		//��ȡ��Ĺ��캯��
		Constructor constructor=c.getConstructor(params);
		
		//ʹ��Constructor�ж����newInstance(Object[] args)��ָ��������
		Object[] paramArgs=new Object[3];
		paramArgs[0]="jim";
		paramArgs[1]="2445135";
		paramArgs[2]="soft";
		
		Object o=constructor.newInstance(paramArgs);
		
		System.out.println(o);
		
		
	}

}
