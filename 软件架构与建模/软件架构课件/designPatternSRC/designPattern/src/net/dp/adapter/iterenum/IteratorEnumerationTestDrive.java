package net.dp.adapter.iterenum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;

public class IteratorEnumerationTestDrive {
	@SuppressWarnings("unchecked")
	public static void main (String args[]) {
		ArrayList l = new ArrayList(Arrays.asList(args));
		Enumeration enumeration = new IteratorEnumeration(l.iterator());
		while (enumeration.hasMoreElements()) {
			System.out.println(enumeration.nextElement());
		}
	}
}
