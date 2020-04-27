package ua.lviv.lgs;

public class Lambda {

	static Optimizate simply = (previous, next, breakTime) -> {
		if (next.getStartTime().compareTo(calcOperationTime(previous.getEndTime(), breakTime, 1)) == -1) {
			next = new Seance(next.getMovie(), calcOperationTime(previous.getEndTime(), breakTime, 1));
		}
		return next.getStartTime();
	};

	static Optimizate begin = (previous, next, breakTime) -> {
		next = new Seance(next.getMovie(), calcOperationTime(previous.getEndTime(), breakTime, 1));
		return next.getStartTime();
	};

	static Optimizate finish = (previous, next, breakTime) -> {
		next = new Seance
				(next.getMovie(), 
						calcOperationTime(
								calcOperationTime(previous.getStartTime(), breakTime, -1), 
								next.getMovie().getDuration(), -1));
		return next.getStartTime();
	};
	
	
	static Optimizate breakOptimizate = (previous, next, breakTime) -> {
		next = new Seance(next.getMovie(), calcOperationTime(previous.getEndTime(), breakTime, 1));
		return next.getStartTime();
	};
	

	static FirstSeance simplyOne = (next, open) -> {
		if (next.getStartTime().compareTo(calcOperationTime(open.getOpen(), new Time(0, 0), 1)) == -1) {
			next = new Seance(next.getMovie(), calcOperationTime(open.getOpen(), new Time(0, 0), 1));
		}
		return next;
	};
	
	static FirstSeance levelingFirst = (next, open) -> {
			next = new Seance(next.getMovie(), calcOperationTime(open.getOpen(), new Time(0, 0), 1));
		return next;
	};

	static FirstSeance levelingLast = (previous, close) -> {
		previous = new Seance
				(previous.getMovie(), 
						calcOperationTime(close.getClose(), previous.getMovie().getDuration(), -1));
		return previous;
	};

	public static Time calcOperationTime(Time changeTime, Time plusMinus, int sign) {
		int hour = 0;
		int min = 0;
		if (sign == 1) {
			hour = changeTime.getHour() + plusMinus.getHour();
			min = changeTime.getMin() + plusMinus.getMin();
			if (min > 59) {
				min -= 60;
				hour += 1;
			}
			if (hour > 23) {
				hour -= 24;
			}
		} else {
			hour = changeTime.getHour() - plusMinus.getHour();
			min = changeTime.getMin() - plusMinus.getMin();
			if (min < 0) {
				min += 60;
				hour -= 1;
			}
			if (hour < 0) {
				hour += 24;
			}
		}
		return new Time(hour, min);
	}

}

interface Optimizate {
	public Time landslide(Seance Previous, Seance Next, Time breakTime);
}

interface FirstSeance {
	public Seance getFirst(Seance first, Cinema cinema);
}