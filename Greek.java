/**
 * 
 */
package java_addicts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Greek {
  protected static String text;
  protected ArrayList<String> dictionary = new ArrayList<String>();
  private Path path = Paths.get("C:\\Users\\User\\"
		  + "eclipse-workspace\\check_gr\\el_GR.dic");
  protected static File file;
  
  public static void greekMenu() throws Exception {
	  Scanner input = new Scanner(System.in);
	  System.out.println("Παρακαλώ εισάγετε κείμενο για διόρθωση");
	  String text = input.nextLine();
	  setText(text);
  }

  public Path getPath() {
    return path;
  }

  public void setPath(Path path) {
    this.path = path;
  }

  public ArrayList<String> getDictionary() {
    return dictionary;
  }

  public void setDictionary(ArrayList<String> dictionary) {
    this.dictionary = dictionary;
  }

  public static String getText() {
    return text;
  }

  public static void setText(String text) {
    Greek.text = text;
  }
  
  public File getFile() { 
    return file;
  }
  
  /*This method reads the file with all the greek words
   * then, puts the words in an ArrayList, splits the text
   * given by the user, based on punctuation and checks if
   * each word is correct
   */
  public void check(String text , ArrayList<String> dictionary) throws Exception {
    file = path.toFile();
    BufferedReader in = new BufferedReader(
 	new InputStreamReader(
        new FileInputStream(file), "UTF8"));
    String str;
	while ((str = in.readLine()) != null) {
     dictionary.add(str);
	}
 	text = text.replaceAll("[,.!-<>:;]"," ");
    String[] textArray = text.split(" ");
	System.out.println("Αριθμός Λέξεων: " + textArray.length);
    for (int i = 0;i < textArray.length; i++) {
      if (dictionary.contains(textArray[i].toLowerCase())) {
 	    System.out.println("Η λέξη "+textArray[i] +" είναι σωστή");
    } else {
 		System.out.println("Η λέξη " +textArray[i] +" είναι λάθος");
 	  }
	}
  }
}
