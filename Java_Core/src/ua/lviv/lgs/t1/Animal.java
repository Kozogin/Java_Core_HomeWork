package ua.lviv.lgs.t1;

public class Animal {
	public static void main(String[] args) {
		
		Pet cow = () -> System.out.println("� ������ - �����-�����");
		Pet cat = () -> System.out.println("� �� - �����-�����");
		Pet dog = () -> System.out.println("� ��� - �����-�����");
		
		cow.voice();
		cat.voice();
		dog.voice();
		
	}
}

interface Pet{
	void voice(); 	
}
