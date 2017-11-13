import java.io.*;
//import java.io.PrintReader;
import java.io.OutputStreamWriter;
import java.io.Reader;

public class KaliOreksi {
	public static void main (String args[]) {
		try {
		PrintWriter out = new PrintWriter( new OutputStreamWriter(System.out,"cp737"),true);

		Reader reader = new InputStreamReader(System.in, "cp737");

		//String test = reader.read();
		int i;
		char c;

	String f = "";

		while((i = reader.read())!=-1) {

		            // int to character
		            c = (char)i;
f+=c;
		            // print char
		            //System.out.println("Character Read: "+c);
         }

         System.out.println("DIAVASA: "+f);

		//PrintWriter in = new PrintReader(new InputStreamReader(System.in,"cp737"),true);
		System.out.println("μητσι;");

	} catch(Exception e) {
		System.err.println("Wrong");
	}
}
}