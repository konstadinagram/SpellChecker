package dmst_java_addicts;

import java.io.File;
import java.util.Scanner;

public class English {
	private static Scanner x;
	//* this method separates the sentence*/
	 public static void splitText(String text) {
		String[] b = text.split(" +");
	 	System.out.println("b: " + b.length);
	        for(int i = 0; i < b.length; i++) {
	            System.out.println("i " + b[i]);
	            check(b[i]);
	        }
	 }
	public static void check(String word) {
		try {
			x = new Scanner(new File("C:\\english3.txt"));
			while (x.hasNextLine()) {
				if (word == x.next()) {
					System.out.println("the word is included");
				} else {
					System.out.println("the word is  not included");
				}
			}
		
		} catch (Exception e) {
			System.out.println("Could not find File");
		}
		
	}

}