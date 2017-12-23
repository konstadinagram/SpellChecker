package gr.aueb.dmst.javaaddicts.SpellCheck;

import java.io.File;
import java.util.Scanner;
import java.util.Locale;

class Espanol extends Language {
  private static final Locale E_LOCALE = new Locale("es" , "AR");

  public void espanolMenu() {
    System.out.println("�������� �������� ������� ��� ��������");
    Scanner input = new Scanner(System.in);
    String text = input.nextLine();
    setText(text);
  }

  @Override
  public File getFile() {
    file = ("C:\\Users\\a_tse\\Desktop\\espanol.zip");
    return file;
  }

  @Override
  public void spellChecker() {
    for (int i = 0;i < textArray.length; i++) {
      System.out.println("����: " + textArray[i]);
      String wordLowerCase = textArray[i].toLowerCase(E_LOCALE);
      if (this.dictionary.contains(textArray[i]) || (this.dictionary.contains(wordLowerCase))) {
        System.out.println("� ���� " + textArray[i] + " ����� �����");
      } else {
        System.out.println("� ���� " + textArray[i] + " ����� �����");
      }
    }
  }
}
