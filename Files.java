import java.io.File;
import java.util.Scanner;

public class Files {
	private Scanner x;

/* ������� � ����� ������� �� ������ **/
	public void OpenFile() {
		try {
			x = new Scanner(new File("C:\\el_GR.dic"));
		} catch (Exception e) {
			System.out.println("Could not find File");
		}
	}

/* ������� � ����� �������� �� ������ **/
	public void ReadFile() {
		while(x.hasNext()) {
			String a = x.next();
			String b = x.next();
			String c = x.next();

			System.out.printf(" %s %s %s\n", a,b,c);
		}
	}

/* ������� � ����� ������� �� ������ **/
	public void CloseFile() {
		x.close();
	}
/* ������� ��������� ����� **/
	public static void Mistakes(String word) {
			System.out.println("The word" +word+ "is wrong");
		}
}




