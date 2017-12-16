/**
 * 
 */
package gr.aueb.dmst.javaaddicts.SpellCheck;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author User
 *
 */
public class AppTest {

	@Test
	public void test() throws Exception {
		Greek ob = new Greek();
		ob.greekMenu();
		String gr_sentence="Καλοιμερα είμαι καλά";
	    ob.check(gr_sentence , ob.getDictionary());
	    String en_sentence="Good morning my name ar Alex";
		English o = new English();
		o.englishMenu();
		o.check(en_sentence , o.getDictionary());
	}

}
