package gr.aueb.dmst.javaaddicts.SpellCheck;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
  private static Scanner input;

  public static void main(String[] args) {
    input = new Scanner(System.in);
    System.out.println("Παρακαλώ, Πατήστε 1 για Ελληνικά");
    System.out.println("Please, Press 2 for English");
    try {
      int choice = input.nextInt();
      if (choice == 1) {
        Greek gr = new Greek();
        gr.greekMenu();
        gr.readFileAndSplitText(gr.getFile());
        gr.spellChecker();
      } else if (choice == 2) {
        English en = new English();
        en.englishMenu();
        en.readFileAndSplitText(en.getFile());
        en.spellChecker();
      }
    } catch(IllegalArgumentException e) {
    	e.getCause();
    }
  }   
}
