package gr.aueb.dmst.javaaddicts.SpellCheck;

import java.io.File;
import java.util.Scanner;
import java.util.Locale;

class Norsk extends Language {
  private static final Locale N_LOCALE = new Locale("no" , "NO");

  public void norskMenu() {
    System.out.println("�������� �������� ������� ��� ��������");
    Scanner input = new Scanner(System.in);
    String text = input.nextLine();
    setText(text);
  }

  @Override
  public File getFile() {
    file = ("C:\\Users\\a_tse\\Desktop\\norsk.zip");
    return file;
  }

  @Override
  public void spellChecker() {
    for (int i = 0;i < textArray.length; i++) {
      System.out.println("����: " + textArray[i]);
      String wordLowerCase = textArray[i].toLowerCase(N_LOCALE);
      if (this.dictionary.contains(textArray[i]) || (this.dictionary.contains(wordLowerCase))) {
        System.out.println("� ���� " + textArray[i] + " ����� �����");
      } else {
        System.out.println("� ���� " + textArray[i] + " ����� �����");
      }
    }
  }
}
