package ua.lviv.lgs.t2;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class MethodCommodity {
	Commodity commodity = new Commodity("", 0, 0, 0);

	Storage addCommodity = listCommodity -> {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name commodity: ");
		String name = sc.next();

		Scanner scInt = new Scanner(System.in);
		System.out.println("Enter length commodity: ");
		int length = scInt.nextInt();

		System.out.println("Enter width commodity: ");
		int width = scInt.nextInt();

		System.out.println("Enter weight commodity: ");
		int weight = scInt.nextInt();

		listCommodity.add(new Commodity(name, length, width, weight));
	};

	Storage removeCommodity = listCommodity -> {
		Iterator<Commodity> iterator = listCommodity.iterator();
		while (iterator.hasNext()) {
			commodity = iterator.next();
			System.out.println(commodity);
			System.out.println("Remote this position - enter Y, no - N (but else)");
			Scanner sc = new Scanner(System.in);
			if (sc.next().equalsIgnoreCase("Y")) {
				iterator.remove();
				System.out.println("Remoted");
			}
		}
	};

	Storage replaceCommodity = listCommodity -> {
		ListIterator<Commodity> listIterator = listCommodity.listIterator();
		while (listIterator.hasNext()) {
			commodity = listIterator.next();
			System.out.println(commodity);
			System.out.println("Replace this position - enter Y, no - N (but else)");
			Scanner sc = new Scanner(System.in);
			if (sc.next().equalsIgnoreCase("Y")) {
				listIterator.remove();
				
				System.out.println("Enter name commodity: ");
				String name = sc.next();

				Scanner scInt = new Scanner(System.in);
				System.out.println("Enter length commodity: ");
				int length = scInt.nextInt();

				System.out.println("Enter width commodity: ");
				int width = scInt.nextInt();

				System.out.println("Enter weight commodity: ");
				int weight = scInt.nextInt();

				listIterator.add(new Commodity(name, length, width, weight));
			}
		}
	};

	Storage showNElementCommodity = listCommodity -> {
		System.out.println("Enter N element for printing");
		Scanner scInt = new Scanner(System.in);
		int elementN = scInt.nextInt();
		int indexList = 0;

		Iterator<Commodity> iterator = listCommodity.iterator();
		while (iterator.hasNext()) {
			commodity = iterator.next();
			if (indexList == elementN) {
				System.out.println(commodity);
				System.out.println();
			}
			indexList++;
		}
	};

}

interface Storage {
	void operation(List<Commodity> listCommodity);
}
