package gr.aueb.dmst.javaaddicts.SpellCheck;

import java.io.File;
import java.util.Locale;
import java.util.Scanner;

public class English extends Language {
  /**This class checks english text
  * @author Konstantina Grammatopoulou
  */

  private static final Locale EN_LOCALE = new Locale("en" , "UK");

  public void englishMenu() {
    Scanner input = new Scanner(System.in);
    System.out.println("Please insert text for correction");
    String text = input.nextLine();
    setText(text);
  }
	
  @Override
  public File getFile() {
    file = PATH_OF_DICTIONARY_EN_FILE.toFile();
    return file;
  }
	
  @Override
  public void spellChecker() {
    for (int i = 0;i < textArray.length; i++) {
      System.out.println("Λέξη: " + textArray[i]);
      String wordLowerCase = textArray[i].toLowerCase(EN_LOCALE);
      if (this.dictionary.contains(textArray[i]) || (this.dictionary.contains(wordLowerCase))) {
        System.out.println("The word " + textArray[i] + " is right");
      } else {
        System.out.println("The word " + textArray[i] + " is wrong");
      }
    }
  }
}
