package ua.lviv.lgs.t3;

public class Frog{
	
	Amphibia eat = () -> System.out.println("ам-ам");
	Amphibia sleep = () -> System.out.println("хрр-хрр");
	Amphibia swim = () -> System.out.println("плюх-плюх");
	Amphibia walk = () -> System.out.println("раз-два");

}

interface Amphibia{
	void action(); 	
}