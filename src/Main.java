import java.util.Scanner;
//main file for Wordle in Terminal
//@Author Jazmine McGowan

public class Main {
    private static final String word = DailyWord.getRandom();

    static void main(String[] args) {
        IO.println("Enter Your 5-Letter Guess:");
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

    private static void printWordResult(String wordy) {
        for (int iter = 0; iter < wordy.length(); iter++) {
            char currentChar = wordy.charAt(iter);
            if (currentChar == word.charAt(iter)) {
                IO.print("G");
                continue;
            }
            if (word.indexOf(currentChar) > -1) {
                IO.print("Y");
                continue;
            }
            IO.print("B");
        }
        IO.println();
    }
}
