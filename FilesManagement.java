/*
 * FilesManagement.java
 * export https://github.com/konstadinagram/java2
 * Copyright (C) 2018 Java Addicts
 */

package gr.aueb.dmst.javaaddicts.SpellChecker.common;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.file.Paths;

import javax.swing.JMenu;
import javax.swing.JOptionPane;

/**
* This class accepts UTF-8 text files to
* correct their text. If a file is not a text file,
* or not UTF-8 encoded it throws the appropriate exception
* @version 1.0.0 5 Jan 2018
* @author Java Addicts
*/

public class FilesManagement {
	
  /**The text of a File as null,so we know when a file has nothing inside*/
  protected static String textOfFile = "";
  /**The file input*/
  private static File file;
  /**The charsets accepted*/
  private static final String[] CHARSETS_AVAILABLE = {"UTF-8", "windows-1253", "ISO-8859-7"};
  
  /**
   * The Constructor of the Class initialises the file input
   * and its path
   * @param File file
   * @param String pathName
  **/		
  public FilesManagement(File file , String pathName) {
    Paths.get(pathName);
    FilesManagement.file = file;
	fileAcceptance();
  }
  
  /**
   * This method reads its file input to return its text
   * @return String text
  **/	
  public String fileAcceptance() {
    Charset charset = detectCharset(file , CHARSETS_AVAILABLE);
    if (charset != null) {
      try {
        BufferedReader in = new BufferedReader(new InputStreamReader(
            new FileInputStream(file), charset));
        String wordRead;
        while ((wordRead = in.readLine()) != null) {
          textOfFile = textOfFile + wordRead;
        }
        in.close();
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else {
      JOptionPane.showMessageDialog(null , "Unrecognized " 
          + " charset" , "ERROR" , JOptionPane.ERROR_MESSAGE);
      return null;
    }
    return textOfFile;
  }
  
  /**
   * Method that detects the charset of the file and checks if
   * it is the same with each one of all the charsets available
   * @param File file
   * @param String[] charsets
   * @return Charset
  **/		
  public static Charset detectCharset(File f , String[] charsets) {
    Charset charset = null;
    for (String charsetName : charsets) {
      charset = detectCharset(file , Charset.forName(charsetName));
      if (charset != null) {
        break;
      }
    }
    return charset;
  }
  
  /**
   * Method that detects the charset of the file and checks if
   * it is the same with one of all the charsets available
   * @param File file
   * @param String[] charsets
   * @return Charset
  **/	
  private static Charset detectCharset(File file , Charset charset) {
    //Charset Detection
    try {
      BufferedInputStream input = new BufferedInputStream(new FileInputStream(file));
      CharsetDecoder decoder = charset.newDecoder();
      decoder.reset();
      byte[] buffer = new byte[512];
      boolean identified = false;
      while ((input.read(buffer) != -1) && (!identified)) {
        identified = identify(buffer , decoder);
      }
      input.close();
      if (identified) {
        return charset;
      } else {
        return null;
      }
    } catch (Exception e) {
      return null;
    }
  }
  
  /**
   * Method that identifies the charset of the file and decodes
   * it by using bytes
   * @param byte[]
   * @param CharsetDecoder
   * @return boolean
  **/	
  private static boolean identify(byte[] bytes , CharsetDecoder decoder) {
    try {
      decoder.decode(ByteBuffer.wrap(bytes));
    } catch (CharacterCodingException e) {
      return false;
    }
    return true;
  }
}
