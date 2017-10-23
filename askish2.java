
import java.util.Scanner;
import java.util.InputMismatchException;
/** Eíá ðñüãñáììá ðïõ ï ÷ñÞóôçò äßíåé Ýíá êåßìåíï áðåñéïñéóôÞò ÷ùñéôçêüôçôáò, êáé áõôü åêôõðþíåôáé óôçí ïèüíç */

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
