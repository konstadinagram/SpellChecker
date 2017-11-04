import java.util.Scanner;

class SplitTest {
    public static void main(String[]args){
	Scanner input = new Scanner ( System.in );
	System.out.println(" Enter the text: ");
	String textSplit = input.nextLine();
    String s = "te";
	String[] b = textSplit.split(" +");
 	System.out.println("b: " + b.length);
        for(int i = 0; i < b.length; i++) {
            System.out.println("i " + b[i]);
        }
    }
}