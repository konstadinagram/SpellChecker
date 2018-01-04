/**
 * 
 */
package gr.aueb.dmst.javaaddicts.SpellChecker.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * @author User
 *
 */
public class Language {
		  private final char[] LATIN_ALPHABET = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		  private final char[] GREEK_ALPHABET = "αβγδεζηθικλμνξοπρστυφχψω".toCharArray();
		  protected String text;
		  private Path current_path;
		  private Locale current_locale;
		  private File file;
		  public String[] textArray;
		  public ArrayList<String> dictionary = new ArrayList<String>();
		  public ArrayList<String> wrongWords = new ArrayList<String>();
		public Object wordLowerCase;
		public ArrayList<String> toReturn = new ArrayList<String>();
		 /**@param text
		 * @param choice
		 */
		  public Language(String text , int choice) {
			this.text = text;
			if (choice == 1) {
			  current_locale = new Locale("el" , "GR");
			} else if (choice == 2) {
			  current_locale = new Locale("en" , "UK");
			} else if (choice == 3){
			  current_locale = new Locale("fr" , "FR");
			} else if (choice == 4) {
			  current_locale = new Locale("de" , "DE");
			} else if (choice == 5) {
			  current_locale = new Locale("it" , "IT");
			} else if (choice == 6) {
			  current_locale = new Locale("es" , "AR");
			} else if (choice == 7) {
			  current_locale = new Locale("nl" , "NL");
			} else if (choice == 8) {
			  current_locale = new Locale("da" , "DK");
			} else if (choice == 9) {
			  current_locale = new Locale("no" , "NO");
			}
			initialisePath(choice);
		   }
		  
		  private void initialisePath(int choice) {
			// this method initializes the Path of the dictionary
			if(choice == 1 ) {
			  current_path = Paths.get("C:\\Users\\ANNA\\Desktop\\Joe's stuff\\JAVA\\Ομαδική-Java\\el_GR.dic");
			} else if (choice == 2) {
			  current_path = Paths.get("C:\\Users\\ANNA\\Desktop\\Joe's stuff\\JAVA\\Ομαδική-Java\\ english3.txt");
		    } else if (choice == 3) {
			  current_path = Paths.get("C:\\Users\\User\\eclipse-workspace\\SpellCheck\\francais.txt");
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
			}
		}
		  
		public String getText() {
		  return text;
	    }

		public File getFile() {
		    // Path is converted to File
		    file = current_path.toFile();
		    return file;
		  }
		  
		  public void readFile(File file) {
				BufferedReader in;
				try {
					in = new BufferedReader(new InputStreamReader(new FileInputStream(getFile()), "UTF8"));
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
			}
		  
		  public String[] textToArray() {
			  text = text.replaceAll("[,.!-<>:;?]", " ");
			  textArray = text.split(" ");
			  return textArray;
		  }
		  
		  public void spellChecker(String word) {
		    if (!word.isEmpty()) {
			  String wordLowerCase = word.toLowerCase(current_locale);
			  if (!this.dictionary.contains(word) && (!this.dictionary.contains(wordLowerCase))) {
				  wrongWords.add(word);
			     printSuggestions(word);
			   }
		     }
		  }
		  
		  String printSuggestions(String input) {
		      StringBuilder sb = new StringBuilder();
		      ArrayList<String> print = makeSuggestions(input);
		      if (print.size() == 0) {
		          return "and I have no idea what word you could mean.\n";
		      }
		      sb.append("perhaps you meant:\n");
		      for (String s : print) {
		          sb.append("\n  -" + s);
		      }
		      return sb.toString();
		  }

		  private ArrayList<String> makeSuggestions(String input) {
		      ArrayList<String> toReturn = new ArrayList<String>();
		      toReturn.addAll(charAppended(input));
		      toReturn.addAll(charMissing(input));
		      toReturn.addAll(charsSwapped(input));
		      return toReturn;
		  }

		  private ArrayList<String> charAppended(String input) { 
		      ArrayList<String> toReturn = new ArrayList<String>();
		      char[] current_alphabet;
		      if (current_path == Paths.get("C:\\Users\\User\\eclipse-workspace\\SpellCheck\\el_GR.dic")) {
		        current_alphabet = this.GREEK_ALPHABET;
		      } else {
		    	current_alphabet = this.LATIN_ALPHABET;
		      }
		        for (char c : current_alphabet) {
		          String atFront = c + input;
		          String atBack = input + c;
		          if (dictionary.contains(atFront)) {
		              toReturn.add(atFront);
		          }
		          if (dictionary.contains(atBack)) {
		              toReturn.add(atBack);
		          }
		      }
		      return toReturn;
		  }

		  private ArrayList<String> charMissing(String input) {   
		      ArrayList<String> toReturn = new ArrayList<String>();

		      int len = input.length() - 1;
		      //try removing char from the front
		      if (dictionary.contains(input.substring(1))) {
		          toReturn.add(input.substring(1));
		      }
		      for (int i = 1; i < len; i++) {
		          //try removing each char between (not including) the first and last
		          String working = input.substring(0, i);
		          working = working.concat(input.substring((i + 1), input.length()));
		          if (dictionary.contains(working)) {
		              toReturn.add(working);
		          }
		      }
		      if (dictionary.contains(input.substring(0, len))) {
		          toReturn.add(input.substring(0, len));
		      }
		      return toReturn;
		  }

		  private ArrayList<String> charsSwapped(String input) {   
		      ArrayList<String> toReturn = new ArrayList<String>();

		      for (int i = 0; i < input.length() - 1; i++) {
		          String working = input.substring(0, i);// System.out.println("    0:" + working);
		          working = working + input.charAt(i + 1);  //System.out.println("    1:" + working);
		          working = working + input.charAt(i); //System.out.println("    2:" + working);
		          working = working.concat(input.substring((i + 2)));//System.out.println("    FIN:" + working); 
		          if (dictionary.contains(working)) {
		              toReturn.add(working);
		          }
		      }
		      return toReturn;
		  }
		}
