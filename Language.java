/*
 * Language.java
 * export https://github.com/konstadinagram/java2
 * Copyright (C) 2018 Java Addicts
 */
package gr.aueb.dmst.javaaddicts.SpellChecker.common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
* This class is responsible for the correction
* of a text given. Furthermore, it proposes
* suggestions for any mispelled words.
* @version 1.0.0 5 Jan 2018
* @author Java Addicts
*/

public class Language {
  /**The dictionary as ArrrayList*/
  public ArrayList<String> dictionary = new ArrayList<String>();
  /**The suggestions for the wrong words*/
  public ArrayList<String> totalSuggestions = new ArrayList<String>();
  /**The text as String and as Array*/
  String text;
  String[] textArray;
  /**The characters used for correction*/
  private final char[] GREEK_ALPHABET = "αβγδεζηθικλμνξοπρστυφχψω".toCharArray();
  private final char[] LATIN_ALPHABET = "abcdefgijklmnopqrstuvwxyz".toCharArray();
  private char[] currentAlphabet;
  private Path current_path;
  private File file;
  
  /**
   * The constructor of Language class initialises the text,
   * its language and the file of dictionary to be chosen
   * @param text
   * @param choice
  **/
  public Language(String text, int choice) {
    this.text = text;
	initialisePath(choice);
	chooseAlphabet(choice);
  }
  
  private void chooseAlphabet(int choice) {
    if ( choice == 1) {
	  this.currentAlphabet = GREEK_ALPHABET;
	} else {
	  this.currentAlphabet = LATIN_ALPHABET;
	}
}

/**
   * Initialisation of the proper path
   * @param choice
  **/
  private void initialisePath(int choice) {
    if(choice == 1 ) {
      current_path = Paths.get("C:\\Users\\User\\eclipse-workspace\\SpellChecker2\\el_GR.dic");
    } else if (choice == 2) {
      current_path = Paths.get("C:\\Users\\User\\eclipse-workspace\\SpellChecker2\\english3.txt");
    } else if (choice == 3) {
      current_path = Paths.get("C:\\Users\\User\\eclipse-workspace\\SpellChecker2\\francais.txt");
    } else if (choice == 4) {	
      current_path = Paths.get("C:\\Users\\User\\eclipse-workspace\\SpellChecker2\\deutsch.txt");
    } else if (choice == 5) {	
      current_path = Paths.get("C:\\Users\\User\\eclipse-workspace\\SpellChecker2\\italiano.txt");
    } else if (choice == 6) {	
      current_path = Paths.get("C:\\Users\\User\\eclipse-workspace\\SpellChecker2\\espanol.txt");
    }
  }
  public String getText() {
    return text;
  }
  /**
   *Initialisation of the Dictionary File
   * @return the File of the Dictionary
  **/
  public File getDictionary() {
    // Path is converted to File
    this.file = current_path.toFile();
	  return file;
  }
  
  /**
   * Reading the Dictionary File and turning it into an
   * ArrayList with the proper exceptions
   * @param Dictionary File
  **/	  
  public void readDictionary() {
    BufferedReader in;
    try {
      in = new BufferedReader(new InputStreamReader(
			  new FileInputStream(getDictionary()), "UTF8"));
      String wordAddedToList;
      while ((wordAddedToList = in.readLine()) != null) {
        dictionary.add(wordAddedToList);
      }
      in.close();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  /**
   * Turning a text from a String Variable to an Array
   * and replacing punctuation with whitespace
   * @param String text
   * @return String[] textArray
  **/	  
  public String[] textToArray(String text) {
    text = text.replaceAll("[,.!-<>:;?]", " ");
    this.textArray = text.split(" ");
    return textArray;
  }
  
  /**
   * This method checks if an array with words is correct
   * by checking each word inside it. 
   * It also counts the mistakes inside it.
   * @param String[] textArray
   * @return boolean textIsCorrected
  **/		  
  public boolean spellChecker(String[] textArray) {
    boolean corrected = false;
    int numberOfMistakes=0;
    if (textArray.length != 0) {
      for (String word: textArray) {
        String wordLowerCase = word.toLowerCase();
        if (!this.dictionary.contains(word) 
        		&& (!this.dictionary.contains(wordLowerCase))) {
          returnAllSuggestions(word);
          numberOfMistakes++;
		} else if (word.isEmpty()) {
		  //if there is more than one WhiteSpace between 2 words
          continue;
		}
      }
      if (numberOfMistakes == 0) {
	    JOptionPane.showMessageDialog(null , "Your text is fine!You are good to go!");
		corrected = true;
	  }
    }
    return corrected;
  }
  
  /**
   * This method returns all the suggestions for a misspelled
   * word as an ArrayList
   * @param String wrong Word
   * @see a Window with the Suggestions available
   * @return StringBuilder as a String
  **/		  
  String returnAllSuggestions(String wrongWord) {
    StringBuilder stringBuilder = new StringBuilder();
    ArrayList<String> suggestions = addAllSuggestions(wrongWord);
    if (suggestions.isEmpty()) {
      JOptionPane.showMessageDialog(null , "No suggestions" 
        + "Available for the word: " + wrongWord);
	} else {
      stringBuilder.append("Suggestions Available:\n");
      for (String suggestion : suggestions) {
        stringBuilder.append("\n  -" + suggestion);
      }
      JOptionPane.showMessageDialog(null ,  stringBuilder , "The" 
        + " word " + wrongWord + " is wrong" , JOptionPane.ERROR_MESSAGE);
    }
    return stringBuilder.toString();
  }
  
  /**
   * This method adds all the suggestions for each category of a misspelled
   * word in an ArrayList
   * @param String wrong Word
   * @see a Window with the Suggestions available
   * @return StringBuilder as a String
  **/		  
  private ArrayList<String> addAllSuggestions(String wrongWord) {
    totalSuggestions.addAll(charisAppended(wrongWord));
    totalSuggestions.addAll(charisMissing(wrongWord));
    totalSuggestions.addAll(charsareSwapped(wrongWord));
    return totalSuggestions;
  }
  
  /**
   * This method returns all the suggestions for a misspelled
   * word for appended characters as an ArrayList
   * @param String wrong Word
   * @see a Window with the Suggestions available
   * @return ArrayList suggestionsAppended
  **/	
  private ArrayList<String> charisAppended(String wrongWord) { 
    ArrayList<String> suggestionsAppended = new ArrayList<String>();
    for (char character : currentAlphabet) {
      String wrongWordWithCharacterFront = character + wrongWord;
      String wrongWordWithCharacterBack = wrongWord + character;
      if (dictionary.contains(wrongWordWithCharacterFront)) {
        suggestionsAppended.add(wrongWordWithCharacterFront);
	  }
      if (dictionary.contains(wrongWordWithCharacterBack)) {
        suggestionsAppended.add(wrongWordWithCharacterBack);
      }
    }
  return suggestionsAppended ;
  }
  
  /**
   * This method returns all the suggestions for a misspelled
   * word for missing characters as an ArrayList
   * @param String wrong Word
   * @see a Window with the Suggestions available
   * @return ArrayList suggestionsMissing
  **/	
  private ArrayList<String> charisMissing(String wrongWord) {   
    ArrayList<String> suggestionsMisssing = new ArrayList<String>();
    int length = wrongWord.length() - 1;
    //check if dictionary contains the wrong word without the first character
    if (dictionary.contains(wrongWord.substring(1))) {
      suggestionsMisssing.add(wrongWord.substring(1));
    }
    for (int i = 1; i < length; i++) {
      //removing all characters between the first and last one
      String possibleRight = wrongWord.substring(0 , i);
      possibleRight = possibleRight.concat(wrongWord.substring((i + 1) , wrongWord.length()));
      if (dictionary.contains(possibleRight)) {
        suggestionsMisssing.add(possibleRight);
      }
    }
    if (dictionary.contains(wrongWord.substring(0 , length))) {
      suggestionsMisssing.add(wrongWord.substring(0 , length));
    }
  return suggestionsMisssing;
  }
  
  /**
   * This method returns all the suggestions for a misspelled
   * word for swapped characters as an ArrayList
   * @param String wrong Word
   * @see a Window with the Suggestions available
   * @return ArrayList suggestionsSwapped
  **/	
  private ArrayList<String> charsareSwapped(String wrongWord) {   
    ArrayList<String> suggestionsSwapped = new ArrayList<String>();
	for (int i = 0; i < wrongWord.length() - 1; i++) {
	  String possibleRright = wrongWord.substring(0, i);
	  possibleRright = possibleRright + wrongWord.charAt(i + 1); 
	  possibleRright = possibleRright + wrongWord.charAt(i);
	  possibleRright = possibleRright.concat(wrongWord.substring((i + 2))); 
	  if (dictionary.contains(possibleRright)) {
	    suggestionsSwapped.add(possibleRright);
	  }
	}
  return suggestionsSwapped ;
  }
}
