package hangman;

import java.io.*;
import java.util.Properties;

/**
 * Config Class
 * 
 * Config is loaded from file.
 * If no such file exists, default values
 * are used.
 */
public class Config {
	
	public static int N_GUESSES = 5;
	public static String FONT = "Default";
	public static int FONT_SIZE = 15;
	public static String SELECTED_WORD_LIST = "eng.txt"; // name is prepended with "./words/"
	
	/**
	 * Config Constructor
	 * 
	 * Upon instantiation of the config, an
	 * attempt to read "hangman.config" in the
	 * local directory is made.
	 * 
	 * The file should be formatted as an INI
	 * file (extension ".ini") consisting of key-value 
	 * pairs representing the name and value of
	 * each setting.
	 * 
	 * If a setting's name is present but does
	 * not have a value, the default value as
	 * declared above is used.
	 */
	public Config(MainWindow gameWindow) {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("./hangman.config"));
			
			Properties config = new Properties();
			config.load(reader);
			
			N_GUESSES = Integer.valueOf(config.getProperty("N_GUESSES", String.valueOf(N_GUESSES)));
			FONT = config.getProperty("FONT", FONT);
			FONT_SIZE = Integer.valueOf(config.getProperty("FONT_SIZE", String.valueOf(FONT_SIZE)));
			SELECTED_WORD_LIST = config.getProperty("SELECTED_WORD_LIST", SELECTED_WORD_LIST);
			
			reader.close();
		} catch (FileNotFoundException e) {
			writeSettings();
			
			return;
		} catch (IOException e) {
			e.printStackTrace();
			
			gameWindow.dispose();
		}
		
	}
	
	/**
	 * Writes config to file on disk. 
	 * 
	 * @return void
	 */
	private void writeSettings() {
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("./hangman.config"))) {
			writer.write("N_GUESSES=" + String.valueOf(N_GUESSES));
			writer.newLine();
			writer.write("FONT_SIZE=" + String.valueOf(FONT_SIZE));
			writer.newLine();
			writer.write("FONT=" + FONT);
			writer.newLine();
			writer.write("SELECTED_WORD_LIST=" + SELECTED_WORD_LIST);
			
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}