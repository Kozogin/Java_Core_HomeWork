package ua.lviv.lgs;

public class SubMenu {
	
	
	
	public static void seansesMenuMethod(Cinema cinema, Movie movie, Seance seance, Schedule schedule) {
				
		boolean again = true;
		while(again) {
			App.seansesMenu();
			switch (cinema.scanInt.get()) {
			case 0:
				again = false;
				break;
			case 1:
				schedule.showSeance();
				break;
			case 2:				
				schedule.addSeance(cinema, movie, seance);
				break;
			case 3:
				schedule.remoteSeance(cinema);
				break;
			case 4:
				//schedule.copySeanse(cinema);
				break;
			case 5:
				cinema.showSeance();
				break;
			case 6:
				System.out.println("Add Seance. Enter the day of week");
				String dayOfWeek = cinema.scanString.get();
				cinema.addSeance(schedule, dayOfWeek);
				break;
			case 7:
				System.out.println("Remove Seance. Enter the day of week");
				String dayOfWeekRemove = cinema.scanString.get();
				cinema.removeSeance(schedule, dayOfWeekRemove);
				break;
			case 8:
				//optimize
				break;
			default:
				break;
			}
		}
		
	}
	
	public static void movieMenuMethod(Cinema cinema, Schedule schedule) {	
		boolean again = true;
		while(again) {
			App.movieMenu();
			switch (cinema.scanInt.get()) {
			case 0:
				again = false;
				break;
			case 1:
				cinema.showMovie();
				break;
			case 2:
				cinema.addMovie();
				break;
			case 3:
				cinema.removeMovie(schedule);
				break;
			default:
				break;
			}
		}
	}
	
	public static void optionsMenuMethod(Cinema cinema) {	
		boolean again = true;
		while(again) {
			App.optionsMenu();
			switch (cinema.scanInt.get()) {
			case 0:
				again = false;
				break;
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			default:
				break;
			}
		}
	}
	
	

}
