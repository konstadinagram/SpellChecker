package gr.aueb.dmst.javaaddicts.SpellCheck;

import static org.junit.Assert.*;
import java.util.Scanner;
import org.junit.Test;

public class AppTest {

	@Test
	public void test() {
		Scanner input = new Scanner(System.in);
	    System.out.println("Παρακαλώ, Πατήστε 1 για Ελληνικά");
	    System.out.println("Please, Press 2 for English");
	    int choice = input.nextInt();
	    assert (choice == 1) || (choice == 2);
	    if (choice == 1) {
	      Greek gr = new Greek();
	      gr.setText("Καλοιμερα είμαι η Κωσταντίνα και είμαι καλά");
	      gr.readFileAndSplitText(gr.getFile());
	      gr.spellChecker();
	      gr.setText("Καλησπέρα");
	      gr.readFileAndSplitText(gr.getFile());
	      gr.spellChecker();
	    } else if (choice == 2) {
	      English en = new English();
	      en.setText("Helo my name is Susan.I'm forteen and I life in Germany.My hobbys are go to discos,sometimes I hear music in the radio.In the summer I go bathing in a lake.I haven't any brothers or sisters.We take busses to scool.I visit year nain at my school.My birthday is on Friday.I hope I will buy a new guitar.");
	      en.readFileAndSplitText(en.getFile());
	      en.spellChecker();
	      en.setText("Day");
	      en.readFileAndSplitText(en.getFile());
	      en.spellChecker();
	    }
	}

}
