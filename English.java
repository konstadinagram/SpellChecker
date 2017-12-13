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

/**This class checks english text
 * @author Konstantina Grammatopoulou
 */
class English extends Greek{
  private static Path path = Paths.get("C:\\Users\\User\\"
  + "eclipse-workspace\\CheckIt\\english3.txt");
  private static String text;
  private static ArrayList<String> dictionary = new ArrayList<String>();
  private static File file;
  
  public void englishMenu() throws Exception {
	  Scanner input = new Scanner(System.in);
	  System.out.println("Please insert text for correction");
	  String text = input.nextLine();
	  setText(text);
  }
  
  /*This method reads the file with all the english words
   * then, puts the words in an ArrayList, splits the text
   * given by the user, based on punctuation and checks if
   * each word is correct
   */
  @Override
  public void check(String text , ArrayList <String> dictionary) throws Exception {
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
	System.out.println("Number of words: " + textArray.length);
    for (int i = 0;i < textArray.length; i++) {
      if (dictionary.contains(textArray[i].toLowerCase())) {
 	    System.out.println("The word is Correct");
    } else {
 		System.out.println("The word is wrong");
 	  }
	}
  }
}
