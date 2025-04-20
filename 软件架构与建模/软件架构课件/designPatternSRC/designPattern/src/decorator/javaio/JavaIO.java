package decorator.javaio;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PushbackInputStream;

public class JavaIO {
	public static void main(String[] args) throws FileNotFoundException {
		// Open an InputStream.
		FileInputStream in = new FileInputStream("test.dat");
		// Create a buffered InputStream.
		BufferedInputStream bin = new BufferedInputStream(in);
		// Create a buffered, data InputStream.
		DataInputStream dbin = new DataInputStream(bin);
		// Create an unbuffered, data InputStream.
		DataInputStream din = new DataInputStream(in);
		// Create a buffered, pushback, data InputStream.
		PushbackInputStream pbdbin = new PushbackInputStream(dbin);
	}
}
