package ua.lviv.lgs.t0;

public class Person {
	protected int weight;
	protected int growth;
	
	public Person(int weight, int growth) {
		this.weight = weight;
		this.growth = growth;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getGrowth() {
		return growth;
	}

	public void setGrowth(int growth) {
		this.growth = growth;
	}

}
