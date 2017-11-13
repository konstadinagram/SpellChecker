import java.io.File;
import java.util.Scanner;

public class Files {
	private Scanner x;

/* This method opens one File **/
	public void OpenFile() {
		try {
			x = new Scanner(new File("C:\\el_GR.dic"));
		} catch (Exception e) {
			System.out.println("Could not find File");
		}
	}

/* This method reads the file from OpenFile **/
	public void ReadFile() {
		while(x.hasNext()) {
			String a = x.next();
			String b = x.next();
			String c = x.next();

			System.out.printf(" %s %s %s\n", a,b,c);
		}
	}

/* This method close the previous File **/
	public void CloseFile() {
		x.close();
	}
/* This method prints the wrong words **/
	public static void Mistakes(String word) {
			System.out.println("The word" +word+ "is wrong");
		}
}




