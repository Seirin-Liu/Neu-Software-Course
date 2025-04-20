package templatemethod.compare;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		ComparableDuck[] ducks = {
				new ComparableDuck("haha",10),
				new ComparableDuck("hehe",5),
				new ComparableDuck("gaga", 20)
		};
		
		Arrays.sort(ducks);
		
		for(ComparableDuck duck : ducks){
			System.out.println(duck);
		}
		
		NonComparableDuck[] noComDucks = {
				new NonComparableDuck("haha",10),
				new NonComparableDuck("hehe",5),
				new NonComparableDuck("gaga", 20)
		};
		
		Arrays.sort(noComDucks); //You cannot sort objects which are not Comparable
		
		for(NonComparableDuck noComDuck : noComDucks){
			System.out.println(noComDuck);
		}

	}

}
