import java.util.Scanner;
//main file for Wordle in Terminal
//@Author Jazmine McGowan

public class Main {
    private static final String word = DailyWord.getRandom();
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_WHITE = "\u001B[37m";

    static void main(String[] args) {
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
                IO.println("Congratulations! You finished with " + tries + " tries remaining!");
                return;
            } else {
                IO.println("Sorry, not it, you have " + tries + " attempts remaining");
                tries--;
                printWordResult(line);
                if (tries <= 0) {
                    IO.println("Game over, man! The word was "+ word);
                    return;
                }
            }
        }
    }

    //colors and reprints the characters into green, white, and yellow
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
