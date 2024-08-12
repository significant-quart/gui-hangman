# gui-hangman
gui-hangman is a GUI implementation of the 
popular Hangman game written purely in Java. Upon start users are
presented with a word which is unknown to them
and are tasked with finding the word by guessing
each letter in the word. Every wrong guess reduces
the player's number of remaining "lives" by one. To win, the player must correctly guess each letter of the mystery word before their lives reach 0.

Provided in [./words](./words) are two lists of words; ``eng.txt`` containing all English words, and ``eng_nouns.txt`` containing all English nouns. You can configure what word list is used, among other things, in the [hangman.config](./hangman.config#L4) file.

## Installation / Getting Started

### Prerequisites
- Java >=17

### Install / Building
1. Clone this repository
2. Build with ``javac --release 17 -d ".\bin" "src/hangman/*.java"``
3. Run the project with ``java -classpath ".\bin" hangman.Run``

### Configuration
Within the project is a configuration file ([hangman.config](./hangman.config)) which enables you to change some aspects of the game's rules and appearance. Below is a more detailed description of each setting.
```
hangman.config
├─ N_GUESSES           (DEFAULT=7): Number of guesses available to the player.
├─ FONT_SIZE           (DEFAULT=15): Size of font inside game in pixels.
├─ FONT                (DEFAULT=Default): Font name used inside game, see javax.swing.JComponent.setFont() for more options.
└─ SELECTED_WORD_LIST  (DEFAULT=eng.txt): txt file found in ./words containing words used inside game, seperated by newline (\n).

```