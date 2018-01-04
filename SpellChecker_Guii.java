package gr.aueb.dmst.javaaddicts.SpellChecker.views;



import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import gr.aueb.dmst.javaaddicts.SpellChecker.common.Language;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.util.Locale;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.CardLayout;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.List;
import java.awt.TextField;
import java.awt.Choice;
import javax.swing.JProgressBar;
import java.awt.TextArea;

public class SpellChecker_Guii extends JFrame {

	protected JPanel contentPane;
	protected JPanel panelResults;
	protected JPanel panelLanguage;
	protected static Locale locale;
	protected Language language;
	private static final String[] LANGUAGES_AV = {"\\u0395\\u03BB\\u03BB\\u03B7\\u03BD\\u03B9\\u03BA\\u03AC", "English", "Francais", "Deutsch", "Italiano", "Espanol", "Netherlands", "Dansk", "Norsk"};
	private JButton btnEnter = new JButton("Enter");
	private JTextPane textForCorrection = new JTextPane();
	private JTextField txtTextCorrected;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SpellChecker_Guii frame = new SpellChecker_Guii();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public SpellChecker_Guii() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SpellChecker_Guii.class.getResource("/gr/aueb/dmst/javaaddicts/SpellChecker/resources/dictionary.png")));
		setTitle("SpellChecker");
		initialize();
	}
	
	private void initialize() {
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  setBounds(100, 100, 607, 339);
	  contentPane = new JPanel();
	  contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
	  setContentPane(contentPane);
	  contentPane.setLayout(new CardLayout(0, 0));
	  
	  JPanel panelLanguage = new JPanel();
	  contentPane.add(panelLanguage, "name_516559441566739");
	  panelLanguage.setLayout(null);
	  
	  JPanel panelResults = new JPanel();
	  contentPane.add(panelResults, "name_516559441566739");
	  panelResults.setLayout(null);
	  
	  JComboBox comboBox = new JComboBox();
	  comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u0395\u03BB\u03BB\u03B7\u03BD\u03B9\u03BA\u03AC", "English", "Deutsch", "Francais", "Espanol", "Italiano", "Netherlands", "Dansk", "Norsk"}));
	  comboBox.setBounds(212, 79, 150, 20);
	  panelLanguage.add(comboBox);
	  
	  JLabel lblWelcomeToSpellchecer = DefaultComponentFactory.getInstance().createTitle("Welcome to SpellChecker!");
	  lblWelcomeToSpellchecer.setFont(new Font("Sylfaen", Font.BOLD, 17));
	  lblWelcomeToSpellchecer.setBounds(164, 11, 231, 29);
	  panelLanguage.add(lblWelcomeToSpellchecer);
	  
	  JLabel lblPleaseChooseLanguage = new JLabel("Please Choose Language");
	  lblPleaseChooseLanguage.setBounds(33, 75, 166, 29);
	  panelLanguage.add(lblPleaseChooseLanguage);
	  
	  JLabel lblEnterYourText = new JLabel("Enter Your Text Here:");
	  lblEnterYourText.setBounds(33, 186, 150, 29);
	  panelLanguage.add(lblEnterYourText);
	  
	  textForCorrection.setBounds(180, 186, 215, 90);
	  panelLanguage.add(textForCorrection);
	  
	  TextArea textArea = new TextArea();
	  
	  btnEnter.addActionListener(new ActionListener() {
	  	public void actionPerformed(ActionEvent e) {
	  	if (textForCorrection.getText().isEmpty()) {
	  	  JOptionPane.showMessageDialog(null, "Text Not Found.Please Try Again","ERROR", JOptionPane.ERROR_MESSAGE);
	  	} else {
	  		panelResults.setVisible(true);
	  		panelLanguage.setVisible(false);
	  		language = new Language(textForCorrection.getText(),comboBox.getSelectedIndex()+1);
	  		textArea.setText(language.getText());
	  		textArea.setEditable(false);
	  	}
	  	}
	  });
	  
	  btnEnter.setToolTipText("Press when language and text are added");
	  btnEnter.setBounds(431, 189, 89, 23);
	  panelLanguage.add(btnEnter);
	  
	  
	  JLabel lblTheRedWords = new JLabel("The red words are wrong: Please Choose Action.");
	  lblTheRedWords.setBounds(10, 11, 296, 21);
	  panelResults.add(lblTheRedWords);
	  
	  textArea.setBounds(10, 38, 571, 105);
	  panelResults.add(textArea);
	  for (int i = 0 ; i < language.textArray.length; i++) {
	    language.spellChecker(language.textArray[i]);
	    ArrayList
	  
	}
}