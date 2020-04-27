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
				System.out.println("Add Seance. Enter the day of week");
				String dayOfWeekCopy = cinema.scanString.get();
				schedule.copySeance(cinema, dayOfWeekCopy);
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
				System.out.println("        Enter principle of optimization \n"				
						+ "  Enter 1, to checking seances overlay \n"
						+ "  Enter 2, offset to sessions start \n"
						+ "  Enter 3, offset to sessions finish \n"
						+ "  Enter 4, breaks are equal");	
				
				switch (cinema.scanInt.get()) {
				case 1:
					schedule.overlayOptizate(cinema, movie, seance, Lambda.simply);					
					break;
				case 2:
					schedule.overlayOptizate(cinema, movie, seance, Lambda.begin);
					break;
				case 3:
					schedule.overlayOptizate(cinema, movie, seance, Lambda.finish);
					break;
				case 4:
					schedule.breaksOptizate(cinema, movie, seance);
					break;
				default:
					break;
				}
				
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
