
import java.util.Scanner;
import java.util.InputMismatchException;
/** Eνα πρόγραμμα που ο χρήστης δίνει ένα κείμενο απεριοριστής χωριτηκότητας, και αυτό εκτυπώνεται στην οθόνη */

public class askish2 {
 public static void main( String[] args){
  try {
    System.out.println("dwse keimeno");
    Scanner input = new Scanner(System.in);
    String text = input.nextLine();
    System.out.println("emfanise to keimeno ");
    System.out.println(text);
} catch(InputMismatchException e){
	System.err.println("ksanadwse keimeno");
}
}
}