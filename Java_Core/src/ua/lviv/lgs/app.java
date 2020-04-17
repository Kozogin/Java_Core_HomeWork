package ua.lviv.lgs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class app {

	public static void main(String[] args) {
				
		VerkhovnaRada.getInstance();		
		
		Deputy deputy = new Deputy();
		Faction faction = new Faction();
		
		//List<Deputy> deputyList = new ArrayList<Deputy>();		
		List<List<Deputy>> deputyList2D = new ArrayList<>();				
		List<String> fractionDeputy = new ArrayList<String>();		
		
		VerkhovnaRada verkhovnaRada = VerkhovnaRada.getInstance();
		
		while(true) {
			menu();
			Scanner sc = new Scanner(System.in);
			switch (sc.next()) {
			case "1":
				verkhovnaRada.addFraction.transform(fractionDeputy,deputyList2D,faction, deputy);
				break;
			case "2":
				verkhovnaRada.removeFraction.transform(fractionDeputy,deputyList2D,faction, deputy);
				break;
			case "3":
				verkhovnaRada.allPrintFraction.transform(fractionDeputy,deputyList2D,faction, deputy);
				break;
			case "4":
				verkhovnaRada.clearWhichFractionDeputy.transform(fractionDeputy,deputyList2D,faction, deputy);
				break;
			case "5":
				verkhovnaRada.whichPrintFractionDeputy.transform(fractionDeputy,deputyList2D,faction, deputy);
				break;
			case "6":
				verkhovnaRada.addwhichFractionDeputy.transform(fractionDeputy,deputyList2D,faction, deputy);
				break;
			case "7":
				verkhovnaRada.remoteWhichFractionDeputy.transform(fractionDeputy,deputyList2D,faction, deputy);
				break;
			case "8":
				verkhovnaRada.allGrafterWhichFractionDeputy.transform(fractionDeputy,deputyList2D,faction, deputy);
				break;
			case "9":
				verkhovnaRada.biggerGrafterWhichFractionDeputy.transform(fractionDeputy,deputyList2D,faction, deputy);
				break;
			default:
				break;
			}			
		}
	}
	
	public static void menu() {
		System.out.println();
		System.out.println("     Enter 1 to add a fraction ");
		System.out.println("     Enter 2 to remote a specific fraction ");
		System.out.println("     Enter 3 to print all fraction ");
		System.out.println("     Enter 4 to clean a specific fraction ");
		System.out.println("     Enter 5 print a specific fraction ");
		System.out.println("     Enter 6 to add a deputy to the fraction");
		System.out.println("     Enter 7 to remote the deputy from the fraction ");
		System.out.println("     Enter 8 to print list a bribe taker");
		System.out.println("     Enter 9 to print biggest bribe taker");
		
	}
}
