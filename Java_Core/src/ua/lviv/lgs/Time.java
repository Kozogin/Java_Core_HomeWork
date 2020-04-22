package ua.lviv.lgs;

import java.io.Serializable;

public class Time implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int hour;
	private int min;
	
	public Time(int hour, int min) {
		super();
		try {
			
		if(hour < 0 || hour > 23) {
			throw new WrongInputTimeException("incorrect session time input -> hour(0-23), you entered " + hour);
		} else {
			this.hour = hour;
		}
		if(min < 0 || min > 59) {
			throw new WrongInputTimeException("incorrect session time input -> min(0-59), you entered " + min);
		} else {
			this.min = min;
		}	
		} catch(WrongInputTimeException e) {
			e.printStackTrace();			
		} 
	}
	
	

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	@Override
	public String toString() {
		if(min < 10) {
			return " " + hour + ":0" + min + " ";
		}
		return " " + hour + ":" + min + " ";
	}

}

class WrongInputTimeException extends Exception{
		
	private static final long serialVersionUID = 1L;
	private String parametr;

	public WrongInputTimeException(String parametr) {
		super(parametr);
		this.parametr = parametr;
	}

	public String getParametr() {
		return parametr;
	}
}