import java.util.Scanner;
//* this method separates the sentence*/

public static splitText() {
	
    private static Scanner input;
        Scanner input = new Scanner ( System.in );
	System.out.println(" Enter the text: ");
	String textSplit = input.nextLine();
	String[] b = textSplit.split(" +");
 	System.out.println("b: " + b.length);
        for(int i = 0; i < b.length; i++) {
            System.out.println("i " + b[i]);
     }
}
