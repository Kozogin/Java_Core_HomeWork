package ua.lviv.lgs.t1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class Methods {	
	
	public static void serialize(File file, Serializable object) throws IOException {
		
		OutputStream os = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(os);		
		oos.writeObject(object);
		oos.flush();		
		oos.close();
		os.close();		
	}
		
	public static Serializable deserealize(File file) throws Exception {
		InputStream is = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(is);		
		Serializable object = (Serializable) ois.readObject();
		ois.close();
		is.close();
		return object;
	}	

}
