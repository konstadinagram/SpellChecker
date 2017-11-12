package dmst_java_addicts;

import java.util.*;
public class Main{
	/**the user chooses language and enters the text*/
	public static void main (String[] args) {

		Scanner input =  new Scanner(System.in);
		String language;
		boolean continueLoop = true;
		System.out.println("Please choose Language.");
		do {
			language = input.nextLine();
		    switch (language) {
		    case "English" :
		       English englishobject = new English();
		       continueLoop = false;
		    break;
		    case  "Greek" :
				Greek greekobject = new Greek();
				continueLoop = false;
			break;
		    default :
			    System.out.println("Please choose between English or Greek");

		    }
		} while (continueLoop);


		continueLoop = true;
		do {
            try {
                System.out.println("Please write a text");

                String text = input.nextLine();
                continueLoop = false;
            }
            catch(InputMismatchException e) {

        	    System.err.printf("%nException: %s%n",e);
        	    System.err.println("Invalid type.You must enter text.Please try again");
            }

        }while (continueLoop);

	}

}
