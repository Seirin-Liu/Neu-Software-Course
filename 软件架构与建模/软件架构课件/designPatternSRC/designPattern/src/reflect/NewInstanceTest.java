package reflect;

public class NewInstanceTest {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		Class c=Class.forName("reflect.People");
		Object o=c.newInstance();
		System.out.println(o);
	}

}
