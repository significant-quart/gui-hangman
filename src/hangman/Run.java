/**
 * Hangman Game
 * 
 * The Hangman game is a GUI implementation of the 
 * popular Hangman game. Upon start, users are
 * presented with a word which is unknown to them
 * and are tasked with finding the word by guessing
 * the letters in the word. Every wrong guess reduces
 * the player's number of remaining "lives" by one.
 *
 * @author  Anthony Gillespie
 * @email	anthonygillespie942@gmail.com
 * @version 1.0
 */

package hangman;

/**
 * Run Class
 * 
 * Entrypoint for the game. 
 * 
 * Initialises the game window 
 * from which the GUI is constructed.
 */
public class Run {
	
	public static void main(String[] args) {
		new MainWindow();
 	}
	
}