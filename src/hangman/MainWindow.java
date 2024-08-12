package hangman;

import java.awt.*;
import javax.swing.*;

/**
 * MainWindow Class
 * 
 * Initialises all panels for use. Handles 
 * the layout of all panels using GridBagLayout 
 * with a custom layout implementation.
 */
public class MainWindow extends JFrame {
	
	private static final long serialVersionUID = 2098014336481777556L;
	
	private GridBagConstraints Layout;
	
	public OptionPanel OptionPanel;
	public HealthPanel HealthPanel;
	public ButtonPanel ButtonPanel;
	public WordPanel WordPanel;
	
	public MenuFrame MenuFrame;
	
	/**
	 * MainWindow Constructor
	 * 
	 * Upon instantiation of the main window,
	 * all panels for the game's GUI are also 
	 * instantiated. Each panel will add itself
	 * to the MainWindow via the addComponent
	 * method.
	 * 
	 * @return MainWindow
	 */
	public MainWindow() {
		
		new Config(this);
		
		this.setLayout(new GridBagLayout());
		Layout = new GridBagConstraints();
		
		this.setPreferredSize(new Dimension(720, 480));
		this.setTitle("Hangman");
		this.getContentPane().setBackground(Color.WHITE);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		OptionPanel = new OptionPanel(this);
		HealthPanel= new HealthPanel(this);
		ButtonPanel = new ButtonPanel(this);
		WordPanel = new WordPanel(this);
		
		MenuFrame = new MenuFrame(this);
		
		this.setLocationRelativeTo(null); // open in centre of screen
		this.pack();
		this.setVisible(true);
		
	}
	
	/**
	 * Configure layout for component to be added to the main window.
	 * If padding is provided, layout will adjust according:
	 * - px			Component will fill vertically
	 * - py			Component will fill horizontally
	 * - px and py	Component will not fill and use padding exclusively.
	 * - neither    Component will fill both vertically and horizontally.
	 * 
	 * @param panel		JPanel Component object to be added.
	 * @param x			int    X position of component beginning from 0.
	 * @param y			int    Y position of component beginning from 0.
	 * @param px		int	   Padding/margin of component on X plain.
	 * @param py		int	   Padding/margin of component on y plain.
	 * @param wx		double Weight of distribution of whitespace on X plain.
	 * @param wy		double Weight of distribution of whitespace on Y plain.
	 * 
	 * @return void
	 */
	public void addComponent(JPanel panel, int x, int y, int px, int py, double wx, double wy) {
		
		Layout.weightx = wx;
		Layout.weighty = wy;
		Layout.gridx = x;
		Layout.gridy = y;
		Layout.ipadx = 0;
		Layout.ipady = 0;
		Layout.anchor = GridBagConstraints.FIRST_LINE_START;
		
		if (px > 0 && py > 0) {
			Layout.fill = GridBagConstraints.NONE;
			
			Layout.ipadx = px;
			Layout.ipady = py;	
		} else if (px > 0 && py == 0) {
			Layout.fill = GridBagConstraints.VERTICAL;
			
			Layout.ipadx = px;	
		} else if (px == 0 && py > 0) { 
			Layout.fill = GridBagConstraints.HORIZONTAL;
			
			Layout.ipady = py;	
		} else { 
			Layout.fill = GridBagConstraints.BOTH;
		}
		
		this.add(panel, Layout);
		
	}
	
	/**
	 * Resets all panels for re-use. Called
	 * whenever user starts a new game.
	 * 
	 * @return void
	 */
	public void reset() {
		
		HealthPanel.reset();
		ButtonPanel.reset();
		WordPanel.reset();
		
	}
	
}