package hangman;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * MenuFrame Class
 * 
 * JFrame prompting the user on the
 * outcome of their game.
 * 
 * Contents of the JFrame are
 * changed at runtime, such as the
 * window title and menu text.
 */
public class MenuFrame extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = -1943145905861975753L;
	
	private MainWindow GameWindow;
	private JLabel MenuText;
	private JButton NewGame;
	private JButton Exit;
	
	/**
	 * MenuFrame Constructor
	 * 
	 * JFrame along with its contents are
	 * initialised here.
	 * 
	 * @param	gameWindow	MainWindow	Reference to the MainWindow object.
	 * 
	 * @return	MenuFrame
	 */
	public MenuFrame(MainWindow gameWindow) {
		
		GameWindow = gameWindow;
		
		this.setPreferredSize(new Dimension(420, 240));
		this.getContentPane().setBackground(Color.WHITE);
		
		LayoutManager Layout = new GridLayout(2, 1);
		this.setLayout(Layout);
		
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new GridLayout(1, 1));
		textPanel.setBackground(Color.WHITE);
		
		MenuText = new JLabel("Do you want to play another game?", SwingConstants.CENTER);
		textPanel.add(MenuText);
		this.add(textPanel);
		
		JPanel selectionPanel = new JPanel();
		selectionPanel.setLayout(new GridLayout(1, 2));
		
		NewGame = new JButton("Yes");
		NewGame.setFont(new Font(Config.FONT, Font.BOLD, Config.FONT_SIZE));
		NewGame.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
		NewGame.addActionListener(this);
		selectionPanel.add(NewGame);
		
		Exit = new JButton("No");
		Exit.setFont(new Font(Config.FONT, Font.BOLD, Config.FONT_SIZE));
		Exit.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
		Exit.addActionListener(this);
		selectionPanel.add(Exit);
		
		this.add(selectionPanel);
		
		this.setLocationRelativeTo(gameWindow);
		this.pack();
		
	}
	
	/**
	 * Display the MenuFrame and edit contents
	 * according to the result of the game.
	 * 
	 * @param success	boolean	True if the played guessed the word.
	 * @param word		String	The word being guesses.
	 * 
	 * @return void
	 */
	public void showMenuFrame(boolean success, String word) {
		
		this.setTitle(success ? "Victory!" : "Defeat!");
		
		MenuText.setText("<html>"); // HTML is used for <br> as \n is unsupported in JLabel text
		
		if (success) {
			MenuText.setText(MenuText.getText() + "Congratulations you found the mystery word!");	
		} else {
			MenuText.setText(MenuText.getText() + "Unfortunately, you failed to find the mystery word!<br><br>The mystery word was " + word + ".");	
		}
		
		MenuText.setText(MenuText.getText() + "<br><br>Do you want to play another game?</html>");
		
		this.pack();
		
		this.setVisible(true);
	}
	
	/**
	 * actionPerformed Interface Implementation
	 * 
	 * Listens for press of "New Game" or "Exit" button.
	 * If "Exit" is pressed, the game will be disposed of
	 * and closed.
	 * 
	 * @param	ActionEvent	event	Event payload.
	 * 
	 * @return void
	 */
	public void actionPerformed(ActionEvent event) {
		
		JButton sourceButton = (JButton) event.getSource();
		
		if (sourceButton.getActionCommand() == NewGame.getActionCommand()) {
			GameWindow.reset();
		} else if (sourceButton.getActionCommand() == Exit.getActionCommand()) {
			this.dispose();
			
			GameWindow.dispose();
		}
		
		this.setVisible(false);
		
	}
	
}