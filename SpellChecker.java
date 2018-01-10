/*
 * SpellChecker.java
 * export https://github.com/konstadinagram/java2
 * Copyright (C) 2018 Java Addicts
 */

package gr.aueb.dmst.javaaddicts.SpellChecker.views;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextComponent;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gr.aueb.dmst.javaaddicts.SpellChecker.common.FilesManagement;
import gr.aueb.dmst.javaaddicts.SpellChecker.common.Language;
import gr.aueb.dmst.javaaddicts.SpellChecker.common.Translator;
import java.io.File;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * This class is the main class of the project
 * and is responsible for the GUI.
 * Finally, it creates the objects responsible for
 * the other functions of the program.
 * @version 1.0.0 5 Jan 2018
 * @author Java Addicts
 */

public class SpellChecker extends JFrame {
  /**Index of Selected Language Of The Text Given*/
  public int selectedLanguageNumber;
  /**JComponents*/
  protected JPanel panelText;
  protected JPanel panelChoice;
  protected JComboBox<String> comboBox;
  protected JTextArea txtrPleaseInsertYour;
  protected TextComponent textArea;
  /**Locale of text*/
  protected static Locale locale;
  /**The text*/
  protected String text;
  /**The dictionary*/
  protected File file;
  /**Object of Language class for Correction*/
  protected Language language;
  /**JComponents*/
  private JPanel contentPane;
  private JMenu mnNewMenu;
  private JMenu mnHelp;
  /**Languages Available*/
  private final String[] LANGUAGES_AV = {"Ελληνικά", "English",
    "Francais", "Deutsch", "Italiano", "Espanol"};
  private int selectedTranslationLanguageNumber;
  
  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (Throwable e) {
      e.printStackTrace();
    }
    EventQueue.invokeLater(new Runnable() {
      public void run() {
          try {
	        SpellChecker frame = new SpellChecker();
		    frame.setVisible(true);
	      } catch (Exception e) {
	        e.printStackTrace();
	      }
	    }
	  });
  }

  /**
  *Create the frame.
  */
  public SpellChecker() {
    setIconImage(Toolkit.getDefaultToolkit().getImage(SpellChecker.class.getResource("/"
        + "gr/aueb/dmst/javaaddicts/SpellChecker/resources/"
        +  "26696419_1766412253402577_1444108092_n.png")));
    setTitle("SpellChecker");
    initialize();
  }
  
  /**
   * This method initializes the JComponents
   * and adds their actions
   * @param File file
   * @param String[] charsets
   * @return Charset
  **/	
  private void initialize() {
    //This method initializes the Components
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 550, 357);
    JMenuBar menuBar = new JMenuBar();
    setJMenuBar(menuBar);	
    mnNewMenu = new JMenu("File");
    menuBar.add(mnNewMenu);
    JMenuItem mntmExit = new JMenuItem("Exit");
    mntmExit.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
	      int ret = JOptionPane.showConfirmDialog(null , "Are " 
                    + " you sure you want to exit?");
          if (ret == JOptionPane.YES_OPTION) {
		    //Shut down program
		    System.exit(0);
		  }
	    }
	});
    
	mnNewMenu.add(mntmExit);	
    mnHelp = new JMenu("Help");
	menuBar.add(mnHelp);
	JMenuItem mntmAbout = new JMenuItem("About");
	mntmAbout.addActionListener(new ActionListener() {
	  public void actionPerformed(ActionEvent e) {
	    JOptionPane.showMessageDialog(null,"Check spelling "
	      + "mistakes in 9 Languages", "About Us", JOptionPane.INFORMATION_MESSAGE);
	  }
	});
	
    mnHelp.add(mntmAbout);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    contentPane.setLayout(new CardLayout(0, 0));
    setContentPane(contentPane);
    final JPanel panelChoice = new JPanel();
    contentPane.add(panelChoice, "name_516559441566739");
    panelChoice.setLayout(null);
    final JPanel panelFile = new JPanel();
    contentPane.add(panelFile , "name_34573075047060");
    panelFile.setLayout(null);
	final JPanel panelText = new JPanel();
    contentPane.add(panelText, "name_516559441566739");
	panelText.setLayout(null);
    final JComboBox<String> comboBox = new JComboBox<String>();
	comboBox.setModel(new DefaultComboBoxModel<String>(LANGUAGES_AV));
    comboBox.setSelectedIndex(0);
	comboBox.setBounds(212, 79, 150, 20);
    panelChoice.add(comboBox);
	comboBox.addActionListener(new ActionListener() {
	  public void actionPerformed(ActionEvent e) {
	    isSelectedLanguageNumber(comboBox.getSelectedIndex()+1);
	  }
	});	  	  
    JLabel lblWelcomeToSpellChecker = 
	  DefaultComponentFactory.getInstance().createTitle("Welcome to SpellChecker!");
    lblWelcomeToSpellChecker.setFont(new Font("Sylfaen", Font.BOLD, 17));
	lblWelcomeToSpellChecker.setBounds(164, 11, 231, 29);
    panelChoice.add(lblWelcomeToSpellChecker);
	JLabel lblPleaseChooseLanguage = new JLabel("Please Choose Language:");
    lblPleaseChooseLanguage.setBounds(33, 75, 166, 29);
    panelChoice.add(lblPleaseChooseLanguage);
    JLabel lblWhatToDo = new JLabel("What to do want to correct?");
    lblWhatToDo.setBounds(33, 158, 150, 20);
    panelChoice.add(lblWhatToDo);
    JRadioButton rdbtnText = new JRadioButton("Text");
    rdbtnText.setBounds(212, 157, 109, 23);
    panelChoice.add(rdbtnText);
    JRadioButton rdbtnFile = new JRadioButton("File");
    rdbtnFile.setBounds(212, 211, 109, 23);
    panelChoice.add(rdbtnFile);
    rdbtnText.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
	        panelChoice.setVisible(false);
		    panelFile.setVisible(false);
		    panelText.setVisible(true);
	      }
        });
    rdbtnFile.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
	        panelChoice.setVisible(false);
		    panelText.setVisible(false);
		    panelFile.setVisible(true);
          }
	});
		  		  
    JButton btnOpenFile = new JButton("Open File...");
    btnOpenFile.setBounds(10, 11, 89, 23);
	panelFile.add(btnOpenFile);
    btnOpenFile.addActionListener(new ActionListener() {
	  public void actionPerformed(ActionEvent e) {
	    JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(null);
		chooser.setFileFilter(new FileNameExtensionFilter("TEXT FILES", "txt", "text"));
		file = chooser.getSelectedFile();
		chooser.approveSelection();
		try {
		  if (JFileChooser.APPROVE_SELECTION != null) {
		    FilesManagement fileM = new FilesManagement(file,file.getAbsolutePath());
		    text = fileM.fileAcceptance();
		    language = new Language(text,selectedLanguageNumber);
		    language.readDictionary();
		    language.spellChecker(language.textToArray(text));
		  }
	    } catch (NullPointerException exception) {
	      exception.getMessage();
	    } 
	  }
    });
    final JTextArea txtrPleaseInsertYour = new JTextArea();
    txtrPleaseInsertYour.setFont(new Font("Arial", Font.PLAIN , 14));
    txtrPleaseInsertYour.setWrapStyleWord(true);
    txtrPleaseInsertYour.setText("Please Insert Your Text Here");
    txtrPleaseInsertYour.setBounds(10, 11, 504, 78);
    panelText.add(txtrPleaseInsertYour);
    final JLabel lblPleaseChooseNext = new JLabel("Do you want to translate your text?");
    lblPleaseChooseNext.setBounds(10, 191, 198, 23);
    lblPleaseChooseNext.setVisible(false);
    panelText.add(lblPleaseChooseNext);
    final JRadioButton rdbtnNo = new JRadioButton("No");
    JButton btnEnter = new JButton("Enter");
    btnEnter.setToolTipText("Please Press When Text is Added");
    btnEnter.setBounds(425, 129, 89, 23);
    panelText.add(btnEnter);
    rdbtnNo.setBounds(299, 191, 109, 23);
    rdbtnNo.setVisible(false);
    panelText.add(rdbtnNo);
    final JRadioButton rdbtnGoogleTranslate = new JRadioButton("Yes");
    rdbtnGoogleTranslate.setToolTipText("Translate your text");
    rdbtnGoogleTranslate.setBounds(235, 191, 109, 23);
    rdbtnGoogleTranslate.setVisible(false);
    panelText.add(rdbtnGoogleTranslate);
    final JPanel panelTranslation = new JPanel();
    contentPane.add(panelTranslation, "name_253511096489750");
    panelTranslation.setLayout(null);
    panelTranslation.setVisible(false);
    JLabel lblNewLabel = new JLabel("Please Choose Language For Translation:");
    lblNewLabel.setBounds(10, 88, 217, 23);
    panelTranslation.add(lblNewLabel); 
    JComboBox<String> comboBoxTranslation = new JComboBox<String>();
    comboBoxTranslation.setModel(new DefaultComboBoxModel<String>(LANGUAGES_AV));
    comboBoxTranslation.setSelectedIndex(0);
    comboBoxTranslation.setBounds(237, 89, 155, 20);
    panelTranslation.add(comboBoxTranslation);
    btnEnter.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          try {
            language = new Language(txtrPleaseInsertYour.getText(),selectedLanguageNumber);
            language.readDictionary();
            boolean corrected = language.spellChecker(language.textToArray(
            txtrPleaseInsertYour.getText()));
            if (corrected == true) {
              txtrPleaseInsertYour.setEditable(false);
              lblPleaseChooseNext.setVisible(true);
              rdbtnGoogleTranslate.setVisible(true);
              rdbtnNo.setVisible(true);
            }
          } catch (StringIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null , "You haven't inserted any text", 
                    "Error", JOptionPane.ERROR_MESSAGE);
          }
        }
      });  
    rdbtnNo.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        int choice = JOptionPane.showConfirmDialog(null, "Do you" 
            + " want to exit?", "Thank you for Using SpellChecker", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
          System.exit(0);
        }
      }
    });
    rdbtnGoogleTranslate.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
    	  panelText.setVisible(false);
    	  panelChoice.setVisible(false);
    	  panelFile.setVisible(false);
    	  panelTranslation.setVisible(true);
      }
	});
    comboBoxTranslation.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    	  if (selectedLanguageNumber != selectedTranslationLanguageNumber) {
    	    Translator translator = new Translator(selectedLanguageNumber,
    	    		selectedTranslationLanguageNumber,txtrPleaseInsertYour.getText());
    	  } else {
    	    JOptionPane.showMessageDialog(null, "You cannot translate in the same " 
    	    	    +" language.Please choose a different one.","Error" , JOptionPane.ERROR_MESSAGE);
    	  }
    	}
    });  
    }

  public void setText(String text) {
    this.text = text;
  }
  
  public void isSelectedLanguageNumber(int selectedLanguageNumber) {
    this.selectedLanguageNumber = selectedLanguageNumber;
  }
  
  public void isSelectedTranslationLanguageNumber(int selectedTranslationLanguageNumber) {
    this.selectedTranslationLanguageNumber = selectedTranslationLanguageNumber;
  }
}
