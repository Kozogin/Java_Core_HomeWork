package ua.lviv.lgs.t3;

public class Frog{
	
	Amphibia eat = () -> System.out.println("nam-nam");
	Amphibia sleep = () -> System.out.println("hrr-hrr");
	Amphibia swim = () -> System.out.println("plyh-plyh");
	Amphibia walk = () -> System.out.println("one-two");

}

interface Amphibia{
	void action(); 	
}