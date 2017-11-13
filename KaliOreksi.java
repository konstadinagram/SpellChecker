import java.io.*;
import java.io.OutputStreamWriter;

public class KaliOreksi {
	public static void main (String args[]) {
		try {
		PrintWriter out = new PrintWriter( new OutputStreamWriter(System.out,"cp737"),true);
		System.out.println("μητσι;");

	} catch(UnsupportedEncodingException e) {
		System.err.println("Wrong");
	}
}
}