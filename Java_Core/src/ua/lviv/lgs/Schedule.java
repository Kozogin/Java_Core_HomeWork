package ua.lviv.lgs;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Schedule implements Serializable {

	private static final long serialVersionUID = 4L;
	Set<Seance> seanses = new TreeSet<>();

	public Schedule() {
	}

	public Schedule(Set<Seance> seanses) {
		super();
		this.seanses = seanses;
	}

	public void addSeance(Cinema cinema, Movie movie, Seance seance) {
		
		if(cinema.moviesLibrary.size() != 0) {
			cinema.showMovie();
			System.out.println("Enter id movie for seance: ");
			int idMovie = cinema.scanInt.get();
				if(!(idMovie < 1 || idMovie > cinema.moviesLibrary.size())){
					System.out.println("Enter start seance hour: ");
					int hour = cinema.scanInt.get();
					System.out.println("Enter start seance min: ");
					int min = cinema.scanInt.get();
					Movie movieSelect = cinema.moviesLibrary.get(idMovie - 1);
					seance = new Seance(movieSelect, new Time(hour, min));
					seanses.add(seance);
				} else {
					System.out.println("Here is no movie with this number ");
				}
		} else {
			System.out.println("No film. At first add film");
		}
	}

	public void showSeance() {		
			int id = 0;
			for (Seance seance : seanses) {
				id++;
				System.out.println(id + " : " + seance);
			}
		
	}	

	public void remoteSeance(Cinema cinema) {
		if (seanses.size() != 0) {
			showSeance();
			System.out.println("Remove, Enter id seance to remove:");
			int idSeance = cinema.scanInt.get();
			if (seanses.size() >= idSeance) {
				int id = 0;
				Iterator<Seance> iterator = seanses.iterator();
				while (iterator.hasNext()) {
					iterator.next();
					id++;
					if (id == idSeance) {
						iterator.remove();
					}
				}
			} else {
				System.out.println("Here is no movie with this number ");
			}
		} else {
			System.out.println("No Seances");
		}
	}
	
	public void copySeance() {
		//////
	}

	public void setSeanses(Set<Seance> seanses) {
		this.seanses = seanses;
	}

	public Set<Seance> getSeances() {
		return seanses;
	}

	@Override
	public String toString() {
		return "seanses: " + seanses;
	}

}
