package ua.lviv.lgs;

import java.io.File;
import java.io.Serializable;

public class App {
	
	public static void main(String[] args) throws Exception{
		
		Cinema cinema = new Cinema();
		Hall hall = new Hall();		
		Movie movie = new Movie();
		Schedule schedule = new Schedule();
		Seance seance = new Seance();
				
		File file = new File("cinema.txt");
		File file2 = new File("cinema2.txt");		
		
		
		Schedule scheduleNotNul = (Schedule)FileWriteRead.readObject(file);
		if(scheduleNotNul != null) {
			schedule = scheduleNotNul;
		} else {
			schedule = new Schedule();
		}
		Hall hallNotNul = (Hall) FileWriteRead.readObject(file2);
		if(hallNotNul != null) {
			hall = hallNotNul;
			cinema.setOpen(hall.getOpenHall());
			cinema.setClose(hall.getCloseHall());
			cinema.setSchedules(hall.getSchedulesHall());
			cinema.setMoviesLibrary(hall.getMoviesLibraryHall());
		} else {
			hall = new Hall();
		}
						
		while(true) {
			mainMenu();			
			switch (cinema.scanInt.get()) {
			case 0:
				System.out.println("NOW");
				
				break;
			case 1:
				SubMenu.seansesMenuMethod(cinema, movie, seance, schedule);
				break;
			case 2:
				SubMenu.movieMenuMethod(cinema, schedule);
				break;
			case 3:					
				hall.objcCreate(cinema);
				System.out.println(hall);
				FileWriteRead.writeObject(file,(Serializable) schedule);
				FileWriteRead.writeObject(file2,(Serializable) hall);
				System.out.println("all information saved");
				break;
			case 4:
				SubMenu.optionsMenuMethod(cinema);
				break;
			case 5:
				System.exit(0);
				break;
			default:
				break;
			}
		}
	}
	
	public static void mainMenu() {
		System.out.println();
		System.out.println("                  MAIN MENU ");
		System.out.println("	NOW:                Enter 0 ");
		System.out.println("	Seances menu:       Enter 1 ");
		System.out.println("	Movie   menu:       Enter 2 ");
		System.out.println("	Save All:           Enter 3 ");
		System.out.println("	Options:            Enter 4 ");
		System.out.println("	Exit:               Enter 5 ");
	}
	
	public static void seansesMenu() {
		System.out.println();
		System.out.println("                 SEANCES MENU ");
		System.out.println("	Main Menu:                   Enter 0 ");
		System.out.println("	Show seances:                Enter 1 ");
		System.out.println("	Add seances:                 Enter 2 ");
		System.out.println("	Remove seances:              Enter 3 ");
		System.out.println("	Copy seances by the day:     Enter 4 ");		
		System.out.println("	Show seances   by the day:   Enter 5 ");
		System.out.println("	Add seances    by the day:   Enter 6 ");
		System.out.println("	Remove seances by the day:   Enter 7 ");		
		System.out.println("	Optimize seance:             Enter 8 ");		
	}
	
	public static void movieMenu() {
		System.out.println();
		System.out.println("                 MOVIE MENU ");
		System.out.println("	Main Menu:          Enter 0 ");
		System.out.println("	Show movie:         Enter 1 ");
		System.out.println("	Add movie:          Enter 2 ");
		System.out.println("	Remove movie:       Enter 3 ");	
	}
	
	public static void optionsMenu() {
		System.out.println();
		System.out.println("                 OPTION ");
		System.out.println("Main Menu:                              Enter 0 ");
		System.out.println("Open and Close:                         Enter 1 ");
		System.out.println("Enter guaranteed break between seanses: Enter 2 ");
		System.out.println("Teknical break, Time:                   Enter 3 ");		
	}

}

