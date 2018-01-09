package Language;

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
import java.util.Arrays;

import javax.swing.JOptionPane;

public class Language {
  private final char[] GREEK_ALPHABET = "αβγδεζηθικλμνξοπρστυφχψω".toCharArray();
  String text;
  String textArray[];
  public ArrayList<String> dictionary = new ArrayList<String>();
  public ArrayList<String> totalSuggestions = new ArrayList<String>();
  private Path current_path;
  private File file;

 /**@param text
 * @param choice
 */
 /**
 * @param text
 * @param current_locale
 */
  public Language(String text, int choice) {
    this.text=text;
    initialisePath(choice);
  }
  private void initialisePath(int choice) {
    //if(choice == 1 ) {
    current_path = Paths.get("C:\\Users\\User\\eclipse-workspace\\SpellChecker\\el_GR.dic");
    /*} else if (choice == 2) {
current_path = Paths.get("C:\\Users\\User\\eclipse-workspace\\SpellChecker\\english3.txt");
} else if (choice == 3) {
current_path = Paths.get("C:\\Users\\User\\eclipse-workspace\\SpellChecker\\francais.txt");
} else if (choice == 4) {
current_path = Paths.get("C:\\Users\\User\\eclipse-workspace\\SpellChecker\\deutsch.txt");
} else if (choice == 5) {
current_path = Paths.get("C:\\Users\\User\\eclipse-workspace\\SpellChecker\\italiano.txt");
} else if (choice == 6) {
current_path = Paths.get("C:\\Users\\User\\eclipse-workspace\\SpellChecker\\espanol.txt");
} else if (choice == 7) {
current_path = Paths.get("C:\\Users\\User\\eclipse-workspace\\SpellChecker\\nederlands.txt");
} else if (choice == 8) {
current_path = Paths.get("C:\\Users\\User\\eclipse-workspace\\SpellChecker\\dansk.txt");
} else if (choice == 9) {
current_path = Paths.get("C:\\Users\\User\\eclipse-workspace\\SpellChecker\\norsk.txt");
}*/

  }
  public String getText() {
    return text;
  }
  
  private void setText(String text) {
    this.text=text;	
  }

public File getDictionary() {
// Path is converted to File
    file = current_path.toFile();
    return file;
  }
 
  public void readDictionary(File file) {
    BufferedReader in;
    try {
      in = new BufferedReader(new InputStreamReader(new FileInputStream(getDictionary()), "UTF8"));
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

  public String[] textToArray(String text) {
    isFormatted(text);
    textArray = text.split(" ");
    return textArray;
  }

  public String isFormatted(String text) {
    return text.replaceAll("[,.!-<>:;?]", " ");
  }

  public String spellChecker(String[] textArray) {
    if (textArray.length != 0) {
      for (String word: textArray) {
        String wordLowerCase = word.toLowerCase();
        if (!this.dictionary.contains(word) && (!this.dictionary.contains(wordLowerCase))) {
          returnAllSuggestions(word);
        } else if (word.isEmpty()) {
          //if the user has inserted more than one WhiteSpace between two words
          continue;
        }
      }
    }
    setText(Arrays.toString(textArray));
    return Arrays.toString(textArray);
  }

  String returnAllSuggestions(String wrongWord) {
    StringBuilder stringBuilder = new StringBuilder();
    ArrayList<String> suggestions = addAllSuggestions(wrongWord);
    if (suggestions.isEmpty()) {
      return "No suggestions available \n";
    }
    stringBuilder.append("Suggestions Available:\n");
    int counter = -1;
    for (String suggestion : suggestions) {
      counter++;
      stringBuilder.append("\n  -" + suggestion);
      int choice = JOptionPane.showConfirmDialog(null, "Maybe you meant:" + suggestion, "The word " 
                  + wrongWord + " is wrong", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
      if (choice == JOptionPane.YES_OPTION) {
        this.textArray[counter + 1] = suggestion;
        counter = -1;
        break;
      }
    }
    return stringBuilder.toString();
  }

  private ArrayList<String> addAllSuggestions(String wrongWord) {
    totalSuggestions.addAll(charisAppended(wrongWord));
    totalSuggestions.addAll(charisMissing(wrongWord));
    totalSuggestions.addAll(charsareSwapped(wrongWord));
    return totalSuggestions;
  }

  private ArrayList<String> charisAppended(String wrongWord) { 
    ArrayList<String> suggestionsAppended = new ArrayList<String>();
    for (char character : GREEK_ALPHABET) {
      String wrongWordWithCharacterFront = character + wrongWord;
      String wrongWordWithCharacterBack = wrongWord + character;
      if (dictionary.contains(wrongWordWithCharacterFront)) {
        suggestionsAppended.add(wrongWordWithCharacterFront);
      }
      if (dictionary.contains(wrongWordWithCharacterBack)) {
        suggestionsAppended.add(wrongWordWithCharacterBack);
      }
    }
    return suggestionsAppended;
  }

  private ArrayList<String> charisMissing(String wrongWord) {   
    ArrayList<String> suggestionsMisssing = new ArrayList<String>();

    int length = wrongWord.length() - 1;
    //check if dictionary contains the wrong word without the first character
    if (dictionary.contains(wrongWord.substring(1))) {
      suggestionsMisssing.add(wrongWord.substring(1));
    }
    for (int i = 1; i < length; i++) {
      //removing all characters between the first and last one
      String right = wrongWord.substring(0, i);
      right = right.concat(wrongWord.substring((i + 1), wrongWord.length()));
      if (dictionary.contains(right)) {
        suggestionsMisssing.add(right);
      }
    }
    if (dictionary.contains(wrongWord.substring(0, length))) {
      suggestionsMisssing.add(wrongWord.substring(0, length));
    }
    return suggestionsMisssing;
  }

  private ArrayList<String> charsareSwapped(String wrongWord) {   
    ArrayList<String> suggestionsSwapped = new ArrayList<String>();

    for (int i = 0; i < wrongWord.length() - 1; i++) {
      String right = wrongWord.substring(0, i);
      right = right + wrongWord.charAt(i + 1); 
      right = right + wrongWord.charAt(i);
      right = right.concat(wrongWord.substring((i + 2))); 
      if (dictionary.contains(right)) {
        suggestionsSwapped.add(right);
      }
    }
    return suggestionsSwapped;
  }
}