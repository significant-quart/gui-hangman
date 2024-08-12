package hangman;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * OptionPanel Class
 * 
 * In future, the "Settings" button would be
 * placed on the option panel opening a JFrame.
 */
public class OptionPanel extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = -6152489582094277309L;
	
	private MainWindow GameWindow;
	private JButton NewGame;
	
	/**
	 * OptionPanel Constructor
	 * 
	 * Panel containing new game button. This
	 * is added first to the GUI, placed along
	 * the top of the application.
	 * 
	 * @param	gameWindow	MainWindow	Reference to the MainWindow object.
	 * 
	 * @return	OptionPanel
	 */
	public OptionPanel(MainWindow gameWindow) {
		
		GameWindow = gameWindow;
		
		this.setLayout(new GridLayout(1, 1));
		
		NewGame = new JButton("New Game");
		NewGame.setFont(new Font(Config.FONT, Font.BOLD, Config.FONT_SIZE));
		NewGame.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
		NewGame.addActionListener(this);
		this.add(NewGame);
		
		gameWindow.addComponent(this, 0, 0, 0, 0, 0.0, 0.0);
	}
	
	/**
	 * actionPerformed Interface Implementation
	 * 
	 * Listens for press of "New Game" button.
	 * 
	 * @param	ActionEvent	event	Event payload.
	 * 
	 * @return void
	 */
	public void actionPerformed(ActionEvent event) {		
		
		JButton sourceButton = (JButton) event.getSource();
		
		if(sourceButton.getActionCommand() == NewGame.getActionCommand())
			GameWindow.reset();
		
	}
}