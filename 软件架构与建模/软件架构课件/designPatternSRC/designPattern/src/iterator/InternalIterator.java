package iterator;

import java.util.List;
import java.util.Arrays;

public class InternalIterator {
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Tom", "Jim", "Marry") ;	
		
		list.forEach(name -> System.out.println(name));
		//Internal Iteration
		//Java 8 way to create a stream and then iterate internally
		//¡°->¡±: Lambda Expressions
	}
}
