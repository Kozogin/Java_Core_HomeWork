package ua.lviv.lgs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class VerkhovnaRada {
	
	private static VerkhovnaRada verkhovnaRada;
	
	
	private VerkhovnaRada() {}
	
	public static synchronized VerkhovnaRada getInstance() {
		if (verkhovnaRada == null) {
			verkhovnaRada = new VerkhovnaRada();
		}
		return verkhovnaRada;
	}
		
		Apparatus addFraction = (fractionDeputy,deputyList2D,faction, deputy) -> {
			System.out.println(" \n to add fraction:");		
			Scanner sc = new Scanner(System.in);
			String factionName = sc.next();
			if(fractionDeputy.stream().noneMatch(factionName :: equalsIgnoreCase)) {
				fractionDeputy.add(factionName);
				deputyList2D.add(new ArrayList<Deputy>());
			} else {
				System.out.println("Such a faction already exists");
			}
		};
		
		Apparatus removeFraction = (fractionDeputy,deputyList2D,faction, deputy) -> {
			System.out.println(" \n To delete a fraction, enter a name for the fraction:");		
			Scanner sc = new Scanner(System.in);
			String factionName = sc.next();
			Iterator<String> iterator = fractionDeputy.iterator();
			int indexFaction = 0;
			while(iterator.hasNext()) {
				if(iterator.next().equalsIgnoreCase(factionName)) {
					iterator.remove();
					System.out.println(indexFaction);
					deputyList2D.remove(indexFaction);
				}				
				indexFaction++;
			}
		};
		
		Apparatus allPrintFraction = (fractionDeputy,deputyList2D,faction, deputy) -> {
			System.out.println(" \n All fraction:");			
			fractionDeputy.forEach(System.out :: println);
		};
		
		Apparatus whichPrintFractionDeputy = (fractionDeputy,deputyList2D,faction, deputy) -> {
			allPrintFraction.transform(fractionDeputy,deputyList2D,faction, deputy);
			
			System.out.println(" \n Enter the name of the fraction for which fraction to output:");		
			Scanner sc = new Scanner(System.in);
			String factionName = sc.next();
			
			Iterator<String> iterator = fractionDeputy.iterator();
			int indexFaction = 0;
			while(iterator.hasNext()) {
				if(iterator.next().equalsIgnoreCase(factionName)) {
					faction.allFraction.method(deputyList2D.get(indexFaction));
				}				
				indexFaction++;
			}
		};
		
		Apparatus addwhichFractionDeputy = (fractionDeputy,deputyList2D,faction, deputy) -> {
			allPrintFraction.transform(fractionDeputy,deputyList2D,faction, deputy);
			
			System.out.println(" \n which faction to add deputy, enter the name of the faction:");		
			Scanner sc = new Scanner(System.in);
			String factionName = sc.next();
			
			Iterator<String> iterator = fractionDeputy.iterator();
			int indexFaction = 0;
			while(iterator.hasNext()) {
				if(iterator.next().equalsIgnoreCase(factionName)) {
					faction.addDeputy.method(deputyList2D.get(indexFaction));
					int indexLastDeputy = deputyList2D.get(indexFaction).size() - 1;
					//Deputy deputyWishBribe;
					deputy = ((Deputy) deputyList2D.get(indexFaction).get(indexLastDeputy));					
					deputy.takeBribe();
					System.out.println(deputy);
					deputyList2D.get(indexFaction).remove(indexLastDeputy);
					deputyList2D.get(indexFaction).add(deputy);
				}				
				indexFaction++;
			}			
		};
		
	Apparatus remoteWhichFractionDeputy = (fractionDeputy, deputyList2D, faction, deputy) -> {
		allPrintFraction.transform(fractionDeputy,deputyList2D,faction, deputy);

		System.out.println(" \n Enter the faction name from which faction to remove the deputy:");
		Scanner sc = new Scanner(System.in);
		String factionName = sc.next();

		Iterator<String> iterator = fractionDeputy.iterator();
		int indexFaction = 0;
		while (iterator.hasNext()) {
			if (iterator.next().equalsIgnoreCase(factionName)) {
				faction.removeDeputy.method(deputyList2D.get(indexFaction));
			}
			indexFaction++;
		}
	};
		
	Apparatus clearWhichFractionDeputy = (fractionDeputy, deputyList2D, faction, deputy) -> {
		allPrintFraction.transform(fractionDeputy,deputyList2D,faction, deputy);

		System.out.println(" \n Enter the faction name from which faction to remove the deputy:");
		Scanner sc = new Scanner(System.in);
		String factionName = sc.next();

		Iterator<String> iterator = fractionDeputy.iterator();
		int indexFaction = 0;
		while (iterator.hasNext()) {
			if (iterator.next().equalsIgnoreCase(factionName)) {
					deputyList2D.get(indexFaction).clear();
			}
			indexFaction++;
		}
	};

	Apparatus allGrafterWhichFractionDeputy = (fractionDeputy, deputyList2D, faction, deputy) -> {
		allPrintFraction.transform(fractionDeputy,deputyList2D,faction, deputy);

		System.out.println(" \n Enter the faction name from which faction to take the bribes of deputies:");
		Scanner sc = new Scanner(System.in);
		String factionName = sc.next();

		Iterator<String> iterator = fractionDeputy.iterator();
		int indexFaction = 0;
		while (iterator.hasNext()) {
			if (iterator.next().equalsIgnoreCase(factionName)) {
				faction.allGrafter.method(deputyList2D.get(indexFaction));
			}
			indexFaction++;
		}
	};

	Apparatus biggerGrafterWhichFractionDeputy = (fractionDeputy, deputyList2D, faction, deputy) -> {
		System.out.println();
		allPrintFraction.transform(fractionDeputy,deputyList2D,faction, deputy);

		System.out.println("From which faction to derive the biggest bribe of the deputy, enter the name of the faction:");
		Scanner sc = new Scanner(System.in);
		String factionName = sc.next();

		Iterator<String> iterator = fractionDeputy.iterator();
		int indexFaction = 0;
		while (iterator.hasNext()) {
			if (iterator.next().equalsIgnoreCase(factionName)) {
				faction.biggerGrafter.method(deputyList2D.get(indexFaction));
			}
			indexFaction++;
		}
	};
	
}

interface Apparatus{
	void transform(List<String> fractionDeputy, List<List<Deputy>> deputyList2D, 
			Faction faction, Deputy deputy);
}
 