package hangman;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * WordPanel Class
 * 
 * Contains logic for loading loading
 * words file as name in the config
 * as well as labels for each letter
 * to be guessed.
 * 
 * The text file containing the words
 * is not case sensitive, however each
 * word should be placed on a new line
 * and may only contain letters.
 */
public class WordPanel extends JPanel {
	
	private static final long serialVersionUID = 4323045538814725208L;
	
	private ArrayList<JLabel> Letters;
	private ArrayList<String> Words;
	public String Word;
	
	/**
	 * WordPanel Constructor
	 * 
	 * Words array is populated with words from
	 * the text file specified in the config.
	 * 
	 * To avoid duplication, the reset method
	 * is used as old labels are disposed and
	 * new labels are created.
	 * 
	 * @param	gameWindow	MainWindow	Reference to the MainWindow object.
	 * 
	 * @return	WordPanel
	 */
	public WordPanel(MainWindow gameWindow) {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("./words/" + Config.SELECTED_WORD_LIST));
			
			String line;
			Words = new ArrayList<String>();
			
			while ((line = reader.readLine()) != null)
				Words.add(line.toUpperCase());
			
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
			gameWindow.dispose();
			
			return;
		} catch (IOException e) {
			e.printStackTrace();
			
			gameWindow.dispose();
		}
		
		this.setLayout(new GridLayout(1, 1));
		
		reset();
		
		gameWindow.addComponent(this, 0, 3, 0, 0, 1.0, 1.0);
		
	}
	
	/**
	 * Selects word at random 
	 * 
	 * @return	String
	 */
	private String getRandomWord() {
		
		return Words.get(new Random().nextInt(Words.size()));
		
	}
	
	/**
	 * Disposes of old labels for which new
	 * labels are constructed. New labels
	 * show a placeholder "_" hiding the
	 * letter.
	 * 
	 * @return void
	 */
	private void constructLabels() {
		
		Letters = new ArrayList<JLabel>();
		
		this.removeAll();
		
		for (int i = 0; i < Word.length(); i++) {
			JLabel l = new JLabel("_", SwingConstants.CENTER);
			
			l.setFont(new Font(Config.FONT, Font.BOLD, Config.FONT_SIZE));
			l.setBackground(Color.WHITE);
			l.setOpaque(true);
			l.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
				
			Letters.add(l);
			this.add(l);	
		}
		
		this.validate();
		
	}
	
	/**
	 * Checks if the letter exists in the word
	 * to be guessed. For each occurrence of
	 * the letter the corresponding label will
	 * be revealed.
	 * 
	 * @param  String	Letter to be checked.
	 * 
	 * @return boolean	True if the letter exists in the word.
	 */
	public boolean guess(String letter) {
		
		boolean found = false;
		
		for (int i = 0; i < Word.length(); i++) {
			if (Word.charAt(i) == letter.charAt(0)) {
				Letters.get(i).setText(letter);
				
				found = true;
			}
		}
		
		return found;
		
	}
	
	/**
	 * Returns true if all letters in
	 * the word are known/revealed.
	 * 
	 * @return boolean
	 */
	public boolean isWordKnown() {
		
		for (int i = 0; i < Word.length(); i++) {
			if (Letters.get(i).getText() == "_")
				return false;
			
		}
		
		return true;
		
	}
	
	/**
	 * Generates a new random word
	 * and creates labels accordingly.
	 * 
	 * @return void
	 */
	public void reset() {
		Word = getRandomWord();
		
		constructLabels();
	}
	
}