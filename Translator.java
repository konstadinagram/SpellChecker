/*
 * Translator.java
 * export https://github.com/konstadinagram/java2
 * Copyright (C) 2018 Java Addicts
 */

package gr.aueb.dmst.javaaddicts.SpellChecker.common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JOptionPane;

/**
 * This class translates a text
 * This class takes a text , its language, and the language
 * wanted for translation and then returns the text given
 * in the second language
 *Imported Library for this class: https://www.whatsmate.net/translation-api.html
 *free use for up to 10 times
 * @version 1.0.0 5 Jan 2018
 * @author Java Addicts
 */

public class Translator {
  /**Language of text given*/
  protected static String language;
  /**Language for Translation*/
  protected static String translationLanguage;
  /**Text for Translation*/
  protected static String text;
  /**Access to Google Translate*/
  private static final String CLIENT_ID = "FREE_TRIAL_ACCOUNT";
  private static final String CLIENT_SECRET = "PUBLIC_SECRET";
  private static final String ENDPOINT = "http://api.whatsmate.net/v1/translation/translate";
  private final String[] LANGUAGES_TR = {"Ελληνικά", "English",
		    "Francais", "Deutsch", "Italiano", "Espanol"};
  

  public Translator(int languageNumber , int translationLanguageNumber , String text) {
    //TODO: If you have your own Premium account credentials, put them down here:
    Translator.language = LANGUAGES_TR[languageNumber];
	Translator.translationLanguage = LANGUAGES_TR[translationLanguageNumber];
	Translator.text = text;
    try {
      Translator.translate(language , translationLanguage , text);
    } catch (Exception e) {
	  // Exception Handled
      e.printStackTrace();
    }
  }
  /**
  * Sends out a translate message via WhatsMate WA Gateway.
  */
  
  public static void translate(String fromLang , String toLang , String text) throws Exception {
  //The translation method
    String builder = new StringBuilder()
            .append("{")
            .append("\"fromLang\":\"")
            .append(fromLang)
            .append("\",")
	        .append("\"toLang\":\"")
	        .append(toLang)
	        .append("\",")
            .append("\"text\":\"")
	        .append(text)
	        .append("\"")
	        .append("}")
	        .toString();
    URL url = new URL(ENDPOINT);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setDoOutput(true);
    conn.setRequestMethod("POST");
    conn.setRequestProperty("X-WM-CLIENT-ID", CLIENT_ID);
    conn.setRequestProperty("X-WM-CLIENT-SECRET", CLIENT_SECRET);
    conn.setRequestProperty("Content-Type", "application/json");
    java.io.OutputStream output = conn.getOutputStream();
    output.write(builder.getBytes());
    output.flush();
    output.close();
    int statusCode = conn.getResponseCode();
    BufferedReader br = new BufferedReader(new InputStreamReader(
            (statusCode == 200) ? conn.getInputStream() : conn.getErrorStream()
    ));
    String translatedText;
    while ((translatedText = br.readLine()) != null) {
      JOptionPane.showMessageDialog(null, translatedText, "Translation",
    		  JOptionPane.INFORMATION_MESSAGE);
	}
    conn.disconnect();
  }
}
