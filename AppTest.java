package gr.aueb.dmst.javaaddicts.SpellCheck;

import static org.junit.Assert.*;
import java.util.Scanner;
import org.junit.Test;

public class AppTest {
	@Test
	public void test() {
	public class AppTest extends TestCase {

	String gr_sentence = "Καλησπέρα παιδιά τι κάναιτε;";
	String en_sentence = "Goodmorning sunshine!I em very glad to see yoo today";
	String fr_sentence = "Bonjour mon diey!Tu es magnifique";
	String de_sentence = "sprechen Sie Deutsch?";
  
    /**
     *Run the tests
     *@Test
     */
    public void Test ()
    {
        Language lgr = new Language(gr_sentence,1);
        lgr.readDictionary();
	System.out.println(lgr.spellChecker(lgr.textToArray(gr_sentence)));
        Language len = new Language(en_sentence,2);
        len.readDictionary(len.getDictionary());
	System.out.printlnlen.spellChecker(len.textToArray(en_sentence)));
        Language lfr = new Language(fr_sentence,3); 
        lfr.readDictionary(lfr.getDictionary());
	System.out.println(lfr.spellChecker(lfr.textToArray(fr_sentence)));
        Language lde = new Language(de_sentence,4);
        lde.readDictionary(lde.getDictionary());
        System.out.println(lde.spellChecker(lde.textToArray(de_sentence)));
    }
}
