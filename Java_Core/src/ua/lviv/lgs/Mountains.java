package ua.lviv.lgs;

public class Mountains {
	
	@MountansFielder("the highest peak")
	private String name;
	@MountansFielder("above sea level, m ")
	private int height;
	@MountansFielder("the location of the top")
	private String country;
	private boolean visit;
	
	public Mountains(String name, int height, String country, boolean visit) {
		super();
		this.name = name;
		this.height = height;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}	

	public boolean isVisit() {
		return visit;
	}

	public void setVisit(boolean visit) {
		this.visit = visit;
	}

	@Override
	public String toString() {
		return "Mountains [name=" + name + ", height=" + height + ", country=" + country + ", visit=" + visit + "]";
	}	

}
