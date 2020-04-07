package ua.lviv.lgs;

import java.io.File;
import java.io.IOException;

public class Application {

	public static void main(String[] args) throws IOException {
		Mountains peak = new Mountains("Goverla", 2061, "Ukraine", true);
			
			String content = Method.getAnnotation(Mountains.class);
			System.out.println(content);
			
			File file = new File("mountansFielder.txt");
			Method.writeAnnotation(file, content);
			
			System.out.println(
					Method.readAnnotation(file, 1000));
		

	}

	
}
