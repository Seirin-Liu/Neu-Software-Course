package decorator.javaio;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class inputStreamToReader {

	public static void main(String[] args) throws IOException {
		FileInputStream in = new FileInputStream("test.dat");
		BufferedReader bufferedReader = 
				new BufferedReader(new InputStreamReader(in));
		String string;
		while((string=bufferedReader.readLine())!=null)
			System.out.println(string);
		
		bufferedReader.close();
		in.close();
	}

}
