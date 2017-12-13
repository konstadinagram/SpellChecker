package java_addicts;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws Exception {
    Scanner input = new Scanner(System.in);
	System.out.println("Παρακαλώ, Πατήστε 1 για Ελληνικά");
	System.out.println("Please, Press 2 for English");
	int choice = input.nextInt();
	if (choice == 1) {
	  Greek greekobject = new Greek();
      greekobject.greekMenu();
	  greekobject.check(greekobject.getText(),greekobject.getDictionary());
	} else if (choice == 2) {
	  English englishobject = new English();
	  englishobject.englishMenu();
	  englishobject.check(englishobject.getText(),englishobject.getDictionary());
    }
  }
}
