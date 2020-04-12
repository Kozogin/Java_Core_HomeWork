package ua.lviv.lgs.t1;

public class Animal {
	public static void main(String[] args) {
		
		Pet cow = () -> System.out.println("I am cow - Mu-muuu");
		Pet cat = () -> System.out.println("I am cat - Mau-mau");
		Pet dog = () -> System.out.println("I am dog - Gav-gav");
		
		cow.voice();
		cat.voice();
		dog.voice();
		
	}
}

interface Pet{
	void voice(); 	
}
