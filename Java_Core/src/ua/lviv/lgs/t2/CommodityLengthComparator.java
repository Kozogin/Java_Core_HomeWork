package ua.lviv.lgs.t2;

import java.util.Comparator;

public class CommodityLengthComparator implements Comparator<Commodity>{

	@Override
	public int compare(Commodity o1, Commodity o2) {		
		if(o1.getLength() > o2.getLength()) {
			return 1;
		} else if(o1.getLength() < o2.getLength()) {
			return -1;
		} else {			
		
			if(o1.getName().compareTo(o2.getName()) > 0) {
				return 1;
			} else if(o1.getName().compareTo(o2.getName()) < 0) {
				return -1;
			} else {
			
				if(o1.getWidth() > o2.getWidth()) {
					return 1;
				} else if(o1.getWidth() < o2.getWidth()) {
					return -1;
				} else {
					if(o1.getWeight() > o2.getWeight()) {
						return 1;
					} else if(o1.getWeight() < o2.getWeight()) {
						return -1;
					}
				}
			}
		}
		return 0;
	}
}
