
import java.util.Scanner;
import java.util.InputMismatchException;
/** ena programma pou o xrhsths dinei ena keimeno aperiorisths xwritikothtas kai auto ektupwnetai sthn othonh */

public class askish2 {
 public static void main( String[] args){
  try {
    System.out.println("Please write a text");
    Scanner input = new Scanner(System.in);
    String text = input.nextLine();
    System.out.println("Your text is: ");
    System.out.println(text);
} catch(InputMismatchException e){
	System.err.println("Please try again");
}
}
}
