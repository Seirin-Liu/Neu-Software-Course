package net.dp.adapter.iterenum;

import java.util.Enumeration;
import java.util.Iterator;

@SuppressWarnings("unchecked")
public class EnumerationIterator implements Iterator {
	Enumeration enumeration;
 
	public EnumerationIterator(Enumeration enumeration) {
		this.enumeration = enumeration;
	}
 
	public boolean hasNext() {
		return enumeration.hasMoreElements();
	}
 
	public Object next() {
		return enumeration.nextElement();
	}
 
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
