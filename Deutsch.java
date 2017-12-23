package gr.aueb.dmst.javaaddicts.SpellCheck;

import java.io.File;
import java.util.Scanner;
import java.util.Locale;

class Deutsch extends Language {
  private static final Locale D_LOCALE = new Locale("de" , "DE");

  public void deutschMenu() {
    System.out.println("Παρακαλώ εισάγετε κείμενο για διόρθωση");
    Scanner input = new Scanner(System.in);
    String text = input.nextLine();
    setText(text);
  }

  @Override
  public File getFile() {
    file = ("C:\\Users\\a_tse\\Desktop\\deutsch.zip");
    return file;
  }

  @Override
  public void spellChecker() {
    for (int i = 0;i < textArray.length; i++) {
      System.out.println("Λέξη: " + textArray[i]);
      String wordLowerCase = textArray[i].toLowerCase(D_LOCALE);
      if (this.dictionary.contains(textArray[i]) || (this.dictionary.contains(wordLowerCase))) {
        System.out.println("Η λέξη " + textArray[i] + " είναι σωστή");
      } else {
        System.out.println("Η λέξη " + textArray[i] + " είναι λάθος");
      }
    }
  }
}
