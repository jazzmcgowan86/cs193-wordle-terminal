import java.io.IOException;
import java.util.Scanner;
//main file for Wordle in Terminal
//@Author Jazmine McGowan

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_WHITE = "\u001B[37m";
    private static String word;

    //Gets user input and tells them if it's right or not for 6 attempts
    static void main(String[] args) {
        try {
            WordleAPI wordleAPI = new WordleAPI();
            word = wordleAPI.getWordleOfTheDay();
        } catch (IOException e) {
            IO.println("Couldn't retrieve the Wordle of the Day");
            return;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            IO.println("API request was interrupted");
            return;
        }

        IO.println("Guess the 5-Letter Word:");
        Scanner scanner = new Scanner(System.in);
        int tries = 6;
        for (String line = scanner.nextLine(); line != null; line = scanner.nextLine()) {
            if (line.length() != 5) {
                IO.println("Only 5 letters allowed, try again:");
                continue;
            }
            line = line.toUpperCase();
            if (line.equals(word)) {
                if (tries == 6) {
                    IO.println("Spectacular! You got the Wordle in 1!");
                    return;
                }
                IO.println("Congratulations! You finished with " + tries + " tries remaining!");
                return;
            } else {
                IO.println("Sorry, not it, you have " + tries + " attempts remaining");
                tries--;
                printWordResult(line);
                if (tries <= 0) {
                    IO.println(LosingMessages.getRandom());
                    IO.println("The word was " + word);
                    return;
                }
            }
        }
    }

    //Colors and reprints the characters into green, white, and yellow based on if the character matches the wordle
    private static void printWordResult(String wordy) {
        for (int iter = 0; iter < wordy.length(); iter++) {
            char currentChar = wordy.charAt(iter);
            if (currentChar == word.charAt(iter)) {
                IO.print(ANSI_GREEN + currentChar + ANSI_RESET);
                continue;
            }
            if (word.indexOf(currentChar) > -1) {
                IO.print(ANSI_YELLOW + currentChar + ANSI_RESET);
                continue;
            }
            IO.print(ANSI_WHITE + currentChar + ANSI_RESET);
        }
        IO.println();
    }
}
