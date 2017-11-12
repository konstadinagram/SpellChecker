import java.util.*;
public class Main{
	/**the user chooses language and enters the text*/
	public static void main (String[] args) {

		Scanner input =  new Scanner(System.in);
		String language;
		do {
			System.out.println("Please choose Language.");
		    language = input.nextLine();
		    switch (language) {
		    case "English" :
		       English englishobject = new English();
		    break;
		    case  "Greek" :
				Greek greekobject = new Greek();

		    break;
		    default :
			    System.out.println("Please choose between English or Greek");

		    }
		} while (language == "English" || language == "Greek");


		boolean continueLoop = true;
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

        }while (continueLoop == true);

	}

}


