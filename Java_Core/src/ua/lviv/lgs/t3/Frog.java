package ua.lviv.lgs.t3;

public class Frog{
	
	Amphibia eat = () -> System.out.println("��-��");
	Amphibia sleep = () -> System.out.println("���-���");
	Amphibia swim = () -> System.out.println("����-����");
	Amphibia walk = () -> System.out.println("���-���");

}

interface Amphibia{
	void action(); 	
}