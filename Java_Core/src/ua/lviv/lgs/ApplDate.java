package ua.lviv.lgs;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class ApplDate {

	public static void main(String[] args) {
				
		Date date = new Date();
	    System.out.println(date.toString());
	    
	    LocalDate ld = LocalDate.now();
	    System.out.println(ld);	
	    	    
	    LocalTime lt = LocalTime.now();
	    System.out.println(lt);	
	    
	    LocalDateTime ldt = LocalDateTime.now();
	    System.out.println(ldt);	
	    
	    System.out.println();
	    System.out.println(convertToLocalDateViaInstant(date));
	    
	    System.out.println(convertToLocalTimeViaInstant(date));
	    
	    System.out.println(convertToLocalDateTimeViaInstant(date));

	}
	
	public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
	    return dateToConvert.toInstant().atZone(ZoneId.systemDefault())
	      .toLocalDate();
	}
	
	public static LocalTime convertToLocalTimeViaInstant(Date date) {
	    return date.toInstant().atZone(ZoneId.systemDefault())
	      .toLocalTime();
	}
	
	public static LocalDateTime convertToLocalDateTimeViaInstant(Date date) {
	    return date.toInstant().atZone(ZoneId.systemDefault())
	      .toLocalDateTime();
	}
	

}
