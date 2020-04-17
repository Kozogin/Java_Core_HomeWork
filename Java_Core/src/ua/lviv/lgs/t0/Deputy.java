package ua.lviv.lgs.t0;

import java.util.Comparator;
import java.util.Scanner;

public class Deputy extends Person{
	
	private String  firstName;
	private String  lastName;
	private int     age;
	private boolean grafter;
	private int     bribe;
	
	public Deputy() {
		super(0, 0);
		this.firstName = "";
		this.lastName =  "";
		this.age =       0;
		this.grafter =   false;
	}
	
	public Deputy(int weight, int growth, String firstName, String lastName, int age, boolean grafter) {
		super(weight, growth);
		this.firstName = firstName;
		this.lastName =  lastName;
		this.age =       age;
		this.grafter =   grafter;
	}
	
	public void takeBribe() {
		if(!grafter) {
			System.out.println("This detupy doesn't take bribe");
		} else {
			System.out.println("Enter the bribe amount for the deputy: ");
			Scanner scInt = new Scanner(System.in);
			int bribeSum = scInt.nextInt();			
			if(bribeSum > 5000) {
				System.out.println("Police will be detained deputy");
			} else {
				this.bribe += bribeSum;
			}
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isGrafter() {
		return grafter;
	}

	public void setGrafter(boolean grafter) {
		this.grafter = grafter;
	}

	public int getBribe() {
		return bribe;
	}

	public void setBribe(int bribe) {
		if(grafter) {
			this.bribe = bribe;
		}
	}

	@Override
	public String toString() {
		return "Person [weight=" + weight + ", growth=" + growth + "]" + "Deputy [firstName=" + 
					firstName + ", lastName=" + lastName + ", age=" + age + ", grafter=" + 
					grafter + ", bribe=" + bribe + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bribe;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deputy other = (Deputy) obj;
		if (bribe != other.bribe)
			return false;
		return true;
	}		

}

class DeputyComparator implements Comparator<Deputy> {

	@Override
	public int compare(Deputy o1, Deputy o2) {
		if (o1.getBribe() > o2.getBribe()) {
			return 1;
		} else if (o1.getBribe() < o2.getBribe()) {
			return -1;
		}
		return 0;
	}
}
