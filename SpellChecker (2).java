package gr.aueb.dmst.javaaddicts.SpellChecker.views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.TextComponent;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import gr.aueb.dmst.javaaddicts.SpellChecker.common.Language;
import javax.swing.JScrollBar;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.JCheckBox;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.swing.JFormattedTextField;
import javax.swing.Box;

public class SpellChecker extends JFrame {

  private JPanel contentPane;
  protected JPanel panelText;
  protected JPanel panelChoice;
  protected static Locale locale;
  protected String text;
  protected static ArrayList <String> textList = new ArrayList <String>();
  public static int selectedLanguageNumber;
  protected Language language;
  private static final String[] LANGUAGES_AV = {"Ελληνικά", "English", "Francais", "Deutsch", "Italiano", "Espanol", "Netherlands", "Dansk", "Norsk"};
  protected JComboBox comboBox;
  protected JTextArea txtrPleaseInsertYour;
  protected TextComponent textArea;
  private JMenu mnNewMenu;
  private JMenu mnHelp;
  protected File file;
  private JTextArea jTextArea_1;

	/**
	 * Launch the application.
	 */
    public static void main(String[] args) {
	  try {
	    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		  }
	  catch(Throwable e) {
		e.printStackTrace();
		  }
		EventQueue.invokeLater(new Runnable() {
    public void run() {
      try {
		SpellChecker frame = new SpellChecker();
		frame.setVisible(true);
		  }
      catch(Exception e) {
		e.printStackTrace();
		  }
		}
	});
}

	/**
	 * Create the frame.
	 */
    public SpellChecker() {
	    setIconImage(Toolkit.getDefaultToolkit().getImage(SpellChecker.class.getResource("/gr/aueb/dmst/javaaddicts/SpellChecker/resources/26696419_1766412253402577_1444108092_n.png")));
	    setTitle("SpellChecker");
	    initialize();
	}
	
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
	  int ret = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?");
	  if(ret==JOptionPane.YES_OPTION) {
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
	    OptionPane.showMessageDialog(null,"Check spelling mistakes in 9 Languages", "About Us", JOptionPane.INFORMATION_MESSAGE);
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
	    contentPane.add(panelFile, "name_34573075047060");
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
		  
		  
	    JLabel lblWelcomeToSpellChecker = DefaultComponentFactory.getInstance().createTitle("Welcome to SpellChecker!");
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
		  
		  
	    rdbtnFile.addActionListener(new ActionListener() {
  	public void actionPerformed(ActionEvent arg0) {
 	    panelChoice.setVisible(false);
  	    panelText.setVisible(false);
	    panelFile.setVisible(true);
  			}
      });
		  
	    JTextArea textArea_1 = new JTextArea();
	    textArea_1.setBounds(10, 55, 504, 222);
	    panelFile.add(textArea_1);
	    panelFile.setVisible(false);
		  
	    JButton btnOpenFile = new JButton("Open File...");
	    btnOpenFile.addActionListener(new ActionListener() {
  	public void actionPerformed(ActionEvent e) {
  	    JFileChooser chooser = new JFileChooser();
  	    chooser.showOpenDialog(null);
  	    chooser.setFileFilter(new FileNameExtensionFilter("TEXT FILES", "txt", "text"));
  	    file = chooser.getSelectedFile();
  	    String filename = file.getAbsolutePath();
  	    chooser.approveSelection();
	  if(JFileChooser.APPROVE_SELECTION != null) {
	    readFileInput(file,filename);
		 	}
  		}
	 });
	    btnOpenFile.setBounds(10, 11, 89, 23);
	    panelFile.add(btnOpenFile);
		  
		 
	    rdbtnText.addActionListener(new ActionListener() {
  	public void actionPerformed(ActionEvent arg0) {
        panelChoice.setVisible(false);
        panelText.setVisible(true);
  		}
	  });
	  final JTextArea txtrPleaseInsertYour = new JTextArea();
	    txtrPleaseInsertYour.setFont(new Font("Arial", Font.PLAIN, 14));
	    txtrPleaseInsertYour.setWrapStyleWord(true);
	    txtrPleaseInsertYour.setText("Please Insert Your Text Here");
	    txtrPleaseInsertYour.setBounds(10, 11, 504, 78);
	    panelText.add(txtrPleaseInsertYour);
	  
	    JButton btnEnter = new JButton("Enter");
	    btnEnter.setToolTipText("Please Press When Text is Added");
	    btnEnter.setBounds(425, 100, 89, 23);
	    panelText.add(btnEnter);
		  
      final JLabel lblCorrectedText = new JLabel("Corrected Text:");
        lblCorrectedText.setFont(new Font("Arial", Font.PLAIN, 14));
	    lblCorrectedText.setBounds(10, 118, 107, 23);
	    panelText.add(lblCorrectedText);
	    lblCorrectedText.setVisible(false);
		  
      final JFormattedTextField formattedTextField = new JFormattedTextField();
        formattedTextField.setBounds(10, 144, 504, 68);
        panelText.add(formattedTextField);
        formattedTextField.setVisible(false);
        btnEnter.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
 	    language = new Language(txtrPleaseInsertYour.getText(),selectedLanguageNumber);
 	    language.readDictionary(language.getDictionary());
 	    formattedTextField.setText(language.spellChecker(language.textToArray(txtrPleaseInsertYour.getText())));
 	    formattedTextField.setVisible(true);
 	    lblCorrectedText.setVisible(true);
    		}
      	});  
	}
	
	protected void readFileInput(File file, String fileName) {
	  try {
	    file = new File(fileName);
		BufferedReader in = new BufferedReader(new InputStreamReader(
	                      new FileInputStream(file), "UTF8"));
		jTextArea_1.read(in,null);
		jTextArea_1.requestFocus();
        setText(text);
        in.close();
	  	  }
	  catch(UnsupportedEncodingException e)
	  	  {
		JOptionPane.showMessageDialog(null,e.getMessage());
		  }
	  catch(IOException e)
		  {
		JOptionPane.showMessageDialog(null,e.getMessage());
		  }
	  catch(Exception e)
	      {
		JOptionPane.showMessageDialog(null,e.getMessage());
	      }
	}

	public void setText(String text) {
	  this.text = text;
	}
	
	public void isSelectedLanguageNumber(int selectedLanguageNumber) {
	    SpellChecker.selectedLanguageNumber = selectedLanguageNumber;
	}
}
