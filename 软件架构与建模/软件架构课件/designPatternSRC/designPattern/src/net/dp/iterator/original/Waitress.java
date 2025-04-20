package net.dp.iterator.original;

import java.util.ArrayList;
import java.util.Iterator;

public class Waitress {
	ArrayList<MenuItem> menus;

	public Waitress(ArrayList<MenuItem> menus) {
		this.menus = menus;
	}

	public void printMenu() {
		Iterator<MenuItem> menuIterator = menus.iterator();
		while (menuIterator.hasNext()) {
			Menu menu = (Menu) menuIterator.next();
			printMenu(menu.createIterator());
		}
	}

	void printMenu(Iterator<MenuItem> iterator) {
		while (iterator.hasNext()) {
			MenuItem menuItem = iterator.next();
			System.out.print(menuItem.getName() + ", ");
			System.out.print(menuItem.getPrice() + " -- ");
			System.out.println(menuItem.getDescription());
		}
	}
}
