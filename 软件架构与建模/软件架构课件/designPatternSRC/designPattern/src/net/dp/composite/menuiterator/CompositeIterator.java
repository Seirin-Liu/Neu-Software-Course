package net.dp.composite.menuiterator;

import java.util.Iterator;
import java.util.Stack;

public class CompositeIterator implements Iterator<MenuComponent> {
	Stack<Iterator<MenuComponent>> stack = new Stack<Iterator<MenuComponent>>();

	public CompositeIterator(Iterator<MenuComponent> iterator) {
		stack.push(iterator);
	}

	public MenuComponent next() {
		if (hasNext()) {
			Iterator<MenuComponent> iterator = stack.peek();
			MenuComponent component = iterator.next();
			if (component instanceof Menu) {
				stack.push(component.createIterator());
			}
			return component;
		} else {
			return null;
		}
	}

	public boolean hasNext() {
		if (stack.empty()) {
			return false;
		} else {
			Iterator<MenuComponent> iterator = stack.peek();
			if (!iterator.hasNext()) {
				stack.pop();
				return hasNext();//递归调用，跳过所有叶子
			} else {
				return true;
			}
		}
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}
}
