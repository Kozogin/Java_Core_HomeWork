package ua.lviv.lgs.t0;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Faction {

	
	MethodDeputy addDeputy = (deputyList) -> {
		System.out.println();
		Deputy deputy = new Deputy();

		System.out.println("Add detupy, enter weight:");
		Scanner sc = new Scanner(System.in);
		int parametrDeputy = sc.nextInt();
		deputy.setWeight(parametrDeputy);

		System.out.println("               , enter growth:");
		parametrDeputy = sc.nextInt();
		deputy.setGrowth(parametrDeputy);

		System.out.println("               , enter first name:");
		String nameDeputy = sc.next();
		deputy.setFirstName(nameDeputy);

		System.out.println("               , enter last name:");
		nameDeputy = sc.next();
		deputy.setLastName(nameDeputy);

		System.out.println("               , enter age:");
		parametrDeputy = sc.nextInt();
		deputy.setAge(parametrDeputy);

		System.out.println("     , enter 'Y' if a bribe taker, else if doesn't take bribe :");
		nameDeputy = sc.next();
		switch (nameDeputy.toUpperCase()) {
		case "Y":
			deputy.setGrafter(true);
			break;
		default:
			deputy.setGrafter(false);
			break;
		}

		deputyList.add(deputy);
	};
	
	MethodDeputy removeDeputy = (deputyList) -> {
		Iterator<Deputy> iterator = deputyList.iterator();
		while (iterator.hasNext()) {
			System.out.println("  \n Remove this deputy Y - yes, else no");
			System.out.println(iterator.next());
			Scanner sc = new Scanner(System.in);
			switch (sc.next().toUpperCase()) {
			case "Y":
				iterator.remove();
				break;
			default:
				break;
			}
		}
	};

	MethodDeputy allGrafter = (deputyList) -> {
		System.out.println("  \n List deputy bribe takers: ");		
		deputyList.stream().filter(d -> d.isGrafter()).peek(d -> System.out.println(d)).collect(Collectors.toList());
			
	};

	MethodDeputy biggerGrafter = (deputyList) -> {
		System.out.println(" \n biggest bribe: ");
		try {	
			Deputy biggerGrafter = deputyList.stream().max(new DeputyComparator()).get();
			System.out.println(biggerGrafter);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(" Err - no deputy bribe takers in this fraction");
		}

	};

	MethodDeputy allFraction = (deputyList) -> {
		System.out.println(" \n List deputy fraction: ");
		deputyList.forEach(System.out :: println);
	};
}

interface MethodDeputy{
	void method(List<Deputy> deputyList);
}
