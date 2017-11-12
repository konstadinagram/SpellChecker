import java.io.File;
import java.util.Scanner;

public class Files {
	private Scanner x;

/* Μέθοδος η οποία ανοίγει το αρχείο **/
	public void OpenFile() {
		try {
			x = new Scanner(new File("C:\\el_GR.dic"));
		} catch (Exception e) {
			System.out.println("Could not find File");
		}
	}

/* Μέθοδος η οποία διαβάζει το αρχείο **/
	public void ReadFile() {
		while(x.hasNext()) {
			String a = x.next();
			String b = x.next();
			String c = x.next();

			System.out.printf(" %s %s %s\n", a,b,c);
		}
	}

/* Μέθοδος η οποία κλείνει το αρχείο **/
	public void CloseFile() {
		x.close();
	}
/* Μέθοδος εκτύπωσης λαθών **/
	public static void Mistakes(String word) {
			System.out.println("The word" +word+ "is wrong");
		}
}




