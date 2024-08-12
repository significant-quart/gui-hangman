package hangman;

import java.awt.*;
import javax.swing.*;

/**
 * HealthPanel Class
 * 
 * Displays the player's "lives" with
 * JLabels. "lives" with a green background
 * are still available, red means they are
 * "used".
 */
public class HealthPanel extends JPanel {
	
	private static final long serialVersionUID = -5323795432536525291L;
	
	private JLabel[] Segments = new JLabel[Config.N_GUESSES];
	public int Lives;
	
	/**
	 * HealthPanel Constructor
	 * 
	 * Creates JLabels for each life with a
	 * green background. Initialises remaining
	 * lives to the number of guesses.
	 * 
	 * @param	gameWindow	MainWindow	Reference to the MainWindow object.
	 * 
	 * @return 	MainWindow
	 */
	public HealthPanel(MainWindow gameWindow) {
		
		Lives = Config.N_GUESSES;
		
		this.setLayout(new GridLayout(1, Config.N_GUESSES));
		
		for (int i = 0; i < Config.N_GUESSES; i++) {
			Segments[i] = new JLabel("" + (i + 1), SwingConstants.CENTER);
			Segments[i].setFont(new Font(Config.FONT, Font.BOLD, Config.FONT_SIZE));
			Segments[i].setBackground(Color.GREEN);
			Segments[i].setOpaque(true);
			Segments[i].setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
			
			this.add(Segments[i]);
		}

		gameWindow.addComponent(this, 0, 1, 0, 0, 1.0, 1.0);
		
	}
	
	/**
	 * Remove life and turn next segment
	 * to red.
	 * 
	 * @return boolean	True if the player has remaining lives.
	 */
	public boolean removeLife() {
		
		Segments[Lives - 1].setBackground(Color.RED);
				
		Lives -= 1;
		
		return (Lives != 0);
	}
	
	/**
	 * Resets remaining lives and
	 * turns all segments back to green.
	 * 
	 * @return void
	 */
	public void reset() {
		
		Lives = Config.N_GUESSES;
		
		for (int i = (Config.N_GUESSES - 1); i >= 0; i--) {
			Segments[i].setBackground(Color.GREEN);
		}
		
	}
	
}