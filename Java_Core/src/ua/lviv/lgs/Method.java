package ua.lviv.lgs;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Field;

public class Method {
	
	public static String getAnnotation(Class<?> customClass) {
		
		StringBuilder content = new StringBuilder();
		for (Field field: customClass.getDeclaredFields()) {			
			if(field.getAnnotation(MountansFielder.class) instanceof MountansFielder) {	
			try {
			content.append(field.getName());
			content.append(" --> ");
			content.append(field.getAnnotation(MountansFielder.class).value());
			content.append((char) 10);
			} catch (NullPointerException e){		
			}
		}	
		}		
		return content.toString();				
	}
		
	public static void writeAnnotation(File file, String data) throws IOException {
		Writer wr = new FileWriter(file);
		wr.write(data);
		wr.close();
	}
	
	public static String readAnnotation(File file, int arraySize) throws IOException {
		Reader wr = new FileReader(file);		
		char [] array = new char [arraySize];
		wr.read(array);
		wr.close();
		StringBuilder sb = new StringBuilder();
		for (char c : array) {
			sb.append(c);
		}		
		return sb.toString();		
	}
	

}
