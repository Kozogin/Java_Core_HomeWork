package ua.lviv.lgs.t1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SetApplication {

	public static void main(String[] args) {
		
		Set<Star> setStar = new HashSet<>();
		
		setStar.add(new Star("Procion", 0.38, 11.4));
		setStar.add(new Star("Betelgeyse", 0.5, 530));
		setStar.add(new Star("Kanopus", -0.72, 310));
		setStar.add(new Star("Proksima", -0.27, 4.3));
		setStar.add(new Star("Capella", 0.03, 42.2));
		setStar.add(new Star("Rigel", 0.12, 530));
		setStar.add(new Star("Arktur", -0.05, 37.6));
		setStar.add(new Star("Vega", 0.03, 25));
		setStar.add(new Star("Sun", -26.72, 0.0000158));
		setStar.add(new Star("Sirius", -1.46, 8.6));		
		setStar.add(new Star("Sirius", 1.46, 18.6));
				
		setStar.forEach(System.out :: println);
		System.out.println();
		
		List<Star> listStarSort = new ArrayList<>(setStar);
		
		//Collections.sort(listStarSort, new StarNameComparator());
		listStarSort = setStar.stream().sorted(new StarNameComparator()).collect(Collectors.toList());
		listStarSort.forEach(System.out :: println);
		System.out.println();
		
		//Collections.sort(listStarSort, new StarBrightnessComparator());
		listStarSort = setStar.stream().sorted(new StarBrightnessComparator()).collect(Collectors.toList());
		listStarSort.forEach(System.out :: println);
		System.out.println();
		
		//Collections.sort(listStarSort, new StarDistanceComparator());
		listStarSort = setStar.stream().sorted(new StarDistanceComparator()).collect(Collectors.toList());
		listStarSort.forEach(System.out :: println);
		System.out.println();
		
		//Collections.sort(listStarSort);
		listStarSort = setStar.stream().sorted().collect(Collectors.toList());
		listStarSort.forEach(System.out :: println);
		System.out.println();
	}
}
	
