package gr.aueb.dmst.javaaddicts.SpellCheck;

import java.io.File;
import java.util.Scanner;
import java.util.Locale;

class Swiss extends Language {
  private static final Locale S_LOCALE = new Locale("de" , "CH");

  public void swissMenu() {
    System.out.println("Παρακαλώ εισάγετε κείμενο για διόρθωση");
    Scanner input = new Scanner(System.in);
    String text = input.nextLine();
    setText(text);
  }

  @Override
  public File getFile() {
    file = ("C:\\Users\\a_tse\\Desktop\\swiss.zip");
    return file;
  }

  @Override
  public void spellChecker() {
    for (int i = 0;i < textArray.length; i++) {
      System.out.println("Λέξη: " + textArray[i]);
      String wordLowerCase = textArray[i].toLowerCase(S_LOCALE);
      if (this.dictionary.contains(textArray[i]) || (this.dictionary.contains(wordLowerCase))) {
        System.out.println("Η λέξη " + textArray[i] + " είναι σωστή");
      } else {
        System.out.println("Η λέξη " + textArray[i] + " είναι λάθος");
      }
    }
  }
}
