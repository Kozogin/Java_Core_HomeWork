package ua.lviv.lgs.t1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws Exception {
		File file = new File("serialize.txt");
		Employee employee = new Employee(0, "Petro Petrov", 15365.28);
		
		System.out.println(employee);
		Methods.serialize(file, employee);			
		System.out.println(Methods.deserealize(file));		
		
		List<Employee> employeeAll = new ArrayList<>();
			employeeAll.add(employee);
			employeeAll.add(new Employee(1, "Ivan Ivanov", 20000));
			employeeAll.add(new Employee(2, "Vasily Vasilenko", 20000));
			employeeAll.add(new Employee(3, "Andriy Andriyenko", 35000));
			employeeAll.add(new Employee(4, "Taras Tarasenko", 22000));
			employeeAll.add(new Employee(5, "Olena Orenko", 12500));
			employeeAll.add(new Employee(6, "Muroslava Ivanova", 40000));
			employeeAll.add(new Employee(7, "Ivanna Petrenko", 31000));
			employeeAll.add(new Employee(8, "Oleg Ivanov", 10000));
		
			Iterator<Employee> iterator = employeeAll.iterator();
			while(iterator.hasNext()) {
				Employee next = iterator.next();
				System.out.println(next);				
			}
			
			Methods.serialize(file, (Serializable)employeeAll);
			//Methods.serialize(file, employee, true);
		 System.out.println(Methods.deserealize(file));
		 System.out.println();
		 List<Employee> newEmployee = new ArrayList<Employee>();
		 newEmployee = (List<Employee>) Methods.deserealize(file); 
		 for(Employee p : newEmployee)
	            System.out.println(p);	 
     
	}

}
