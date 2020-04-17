package ua.lviv.lgs.t1;

import java.util.Comparator;

public class StarNameComparator implements Comparator<Star>{

	@Override
	public int compare(Star o1, Star o2) {
		return o1.getName().compareTo(o2.getName()) > 0 ? 1 : -1;
	}
}
