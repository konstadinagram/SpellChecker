package gr.aueb.dmst.javaaddicts.SpellCheck;

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

class Language {

	/**
	 * 
	 */
 
  protected ArrayList<String> dictionary = new ArrayList<String>();
  private static Path path;
  protected static final Path PATH_OF_DICTIONARY_GR_FILE = Paths.get("C:\\Users\\User\\"
  + "eclipse-workspace\\SpellCheck\\el_GR.dic"); 
  protected static final Path PATH_OF_DICTIONARY_EN_FILE =  Paths.get("C:\\Users\\User\\"
  + "eclipse-workspace\\SpellCheck\\english3.txt");
  protected static String text;
  protected static String[] textArray;
  protected static File file;
	
  public String getText() {
    return text;
  }
  
  public static void setText(String text) {
    Language.text = text;
  }
	
  public ArrayList<String> getDictionary() {
    return dictionary;
  }
	
  public void setDictionary(ArrayList<String> dictionary) {
    this.dictionary = dictionary;
  }
	
  public File getFile() {
  // TODO Auto-generated method stub
    file = path.toFile();
    return file;
  }
	
  public void readFileAndSplitText(File file) {
    BufferedReader in;
    try {
      in = new BufferedReader(
      new InputStreamReader(
      new FileInputStream(getFile()), "UTF8"));
      String wordAddedToList;
      while ((wordAddedToList = in.readLine()) != null) {
        dictionary.add(wordAddedToList);
      }
      in.close();
    } catch (UnsupportedEncodingException e) {
    // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (FileNotFoundException e) {
    // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
    // TODO Auto-generated catch block
      e.printStackTrace();
    }
    text = text.replaceAll("[,.!-<>:;]"," ");
    textArray = text.split(" ");
  }
	
  public void spellChecker() {
    for (int i = 0;i < textArray.length; i++) {
      System.out.println("Λέξη: " + textArray[i]);
      System.out.println(this.dictionary.contains(textArray[i]));
    }
  }
}
