package ua.lviv.lgs.t1;

public class Animal {
	public static void main(String[] args) {
		
		Pet cow = () -> System.out.println("ί κξπξβΰ - Μσσσσ-Μσσσσ");
		Pet cat = () -> System.out.println("ί κ³ς - Μÿσσσ-Μÿσσσ");
		Pet dog = () -> System.out.println("ί οερ - Γΰσσσ-Γΰσσσ");
		
		cow.voice();
		cat.voice();
		dog.voice();
		
	}
}

interface Pet{
	void voice(); 	
}
