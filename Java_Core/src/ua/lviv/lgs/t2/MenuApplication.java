package ua.lviv.lgs.t2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MenuApplication {
	public static void main(String[] args) {
		
		MethodCommodity methodCommodity = new MethodCommodity();		
		List<Commodity> listCommodity = new ArrayList<>();
		
		listCommodity.add(new Commodity("Ship", 20, 8, 260));
		listCommodity.add(new Commodity("Plane", 20, 8, 250));
		listCommodity.add(new Commodity("Plane", 21, 8, 360));
		listCommodity.add(new Commodity("Ship", 20, 9, 1250));
		listCommodity.add(new Commodity("Car", 20, 8, 150));
		listCommodity.add(new Commodity("Car", 21, 9, 300));
		listCommodity.add(new Commodity("Ship", 20, 7, 350));
		listCommodity.add(new Commodity("Motorcycle", 21, 10, 250));
		listCommodity.add(new Commodity("Track", 20, 8, 250));
		listCommodity.add(new Commodity("Ship", 21, 6, 210));
		listCommodity.add(new Commodity("Ship", 21, 8, 350));		
		
		while(true) {
			menu();
			Scanner sc = new Scanner(System.in);
			
			switch (sc.next()) {
			case "1":
				methodCommodity.addCommodity.operation(listCommodity);
				print(listCommodity);
				break;
			case "2":
				methodCommodity.removeCommodity.operation(listCommodity);
				print(listCommodity);
				break;
			case "3":
				methodCommodity.replaceCommodity.operation(listCommodity);
				print(listCommodity);
				break;
			case "4":
				print(listCommodity);
				//Collections.sort(listCommodity, new CommodityNameComparator());
				listCommodity = listCommodity.stream()
						.sorted(new CommodityNameComparator()).collect(Collectors.toList());
				print(listCommodity);
				break;
			case "5":
				print(listCommodity);
				//Collections.sort(listCommodity, new CommodityLengthComparator());
				listCommodity = listCommodity.stream()
						.sorted(new CommodityLengthComparator()).collect(Collectors.toList());
				print(listCommodity);
				break;
			case "6":
				print(listCommodity);
				//Collections.sort(listCommodity, new CommodityWidthComparator());
				listCommodity = listCommodity.stream()
						.sorted(new CommodityWidthComparator()).collect(Collectors.toList());
				print(listCommodity);
				break;
			case "7":
				print(listCommodity);
				//Collections.sort(listCommodity, new CommodityWeightComparator());
				listCommodity = listCommodity.stream()
						.sorted(new CommodityWeightComparator()).collect(Collectors.toList());
				print(listCommodity);
				break;
			case "8":
				methodCommodity.showNElementCommodity.operation(listCommodity);
				break;
			case "9":
				System.exit(0);
				break;
			default:
				break;
			}			
		}		
	}
	
	public static void menu() {
		System.out.println("   Add commodity,                    enter 1");
		System.out.println("   Remote commodity,                 enter 2");
		System.out.println("   Replace commodity,                enter 3");
		System.out.println("   Sort by Name,                     enter 4");
		System.out.println("   Sort by Length,                   enter 5");
		System.out.println("   Sort by Width,                    enter 6");
		System.out.println("   Sort by Weight,                   enter 7");
		System.out.println("   Print N element collection,       enter 8");
		System.out.println("   Exit,                             enter 9");
		
	}
	
	public static void print(List<Commodity> listCommodity) {		
		listCommodity.forEach(System.out :: println);
		System.out.println();
	}

}
