package hangman;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * ButtonPanel Class
 * 
 * Neatly displays each letter of
 * the alphabet as a button for
 * which the player can make a
 * guess.
 */
public class ButtonPanel extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 8300805510783903742L;
	
	private MainWindow GameWindow;
	private JButton[] Alphabet = new JButton[26];
	
	/**
	 * ButtonPanel Constructor
	 * 
	 * Creates JButtons for each letter
	 * of the alphabet.
	 * 
	 * @param	gameWindow	MainWindow	Reference to the MainWindow object.
	 * 
	 * @return ButtonPanel
	 */
	public ButtonPanel(MainWindow gameWindow) {
		
		this.GameWindow = gameWindow;
		
		int rows = (int) Math.ceil((float) 26 / Config.N_GUESSES); // cast as float to avoid truncation
		LayoutManager layout = new GridLayout(rows, Config.N_GUESSES);
		this.setLayout(layout);
		
		this.setBackground(Color.WHITE);
		
		// construct array of buttons for each letter in the alphabet.
		for (int i = 0; i < 26; i++) {
			Alphabet[i] = new JButton("" + (char) (i + 65));
			Alphabet[i].setFont(new Font(Config.FONT, Font.BOLD, Config.FONT_SIZE));
			Alphabet[i].setHorizontalAlignment(JButton.CENTER);
			Alphabet[i].setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
			Alphabet[i].addActionListener(this);
			
			this.add(Alphabet[i]);
		}
		
		gameWindow.addComponent(this, 0, 2, 0, 0, 1.0, 1.0);
		
	}
	
	/**
	 * actionPerformed Interface Implementation
	 * 
	 * Listens for presses of any letter.
	 * If the letter is wrong a life will
	 * be removed.
	 * If the game is over the MenuFrame
	 * is shown and further actions are
	 * ignored until a new game is started.
	 * 
	 * @param	ActionEvent	event	Event payload.
	 * 
	 * @return void
	 */
	public void actionPerformed(ActionEvent e) {
		
		if (GameWindow.HealthPanel.Lives == 0 || GameWindow.WordPanel.isWordKnown()) 
			return;
		
		JButton sourceButton = (JButton) e.getSource();
		
		sourceButton.setVisible(false);
		
		boolean correct = GameWindow.WordPanel.guess(sourceButton.getText());
		boolean alive = true;
		if (!correct)
			alive = GameWindow.HealthPanel.removeLife();	
		
		if (!alive) {
			GameWindow.MenuFrame.showMenuFrame(false,  GameWindow.WordPanel.Word);
		} else if (GameWindow.WordPanel.isWordKnown()) {
			GameWindow.MenuFrame.showMenuFrame(true,  GameWindow.WordPanel.Word);
		}
		
	}
	
	/**
	 * Turns all letters visible
	 * again.
	 * 
	 * @return void
	 */
	public void reset() {
		
		for (int i = 0; i < 26; i++) {			
			Alphabet[i].setVisible(true);
		}
		
	}
	
}