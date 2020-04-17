package ua.lviv.lgs.t1;

import java.util.Comparator;

public class StarBrightnessComparator implements Comparator<Star>{

	@Override
	public int compare(Star o1, Star o2) {
		if(o1.getBrightness() > o2.getBrightness()) {
			return 1;
		} else if(o1.getBrightness() < o2.getBrightness()) {
			return -1;
		} else {
			return o1.getName().compareTo(o2.getName()) > 0 ? 1 : -1;
		}		
	}
}
