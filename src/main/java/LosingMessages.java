import java.util.Random;
//A storage space for messages when the player loses
//@Author Jazmine McGowan

public class LosingMessages {
    private static final Random random = new Random();

    private static final String[] listOfWords = {
            "Game over, man! ", "Easy Mode is now Selectable. ", "Mr.Salieri sends his regards. ",
            "Fission Mailed. ", "Lost to the Zone. ", "The chop shop. That's it. Game over. ",
            "Game over man, game over. ", "Game Over, User Loses! ", "Game over, Shadow! ",
            "That's it. Game over. Go home. Go away. You bother me. ", "Too late! Game over, pal! ",
            "MORTIS. ", "Boy, are you stupid. ", "DUTY FAILED! ", "Game Over. Unfortunately you are bankrupt. :-( ",
            "MAYBE THIS ISN'T THE GAME FOR YOU! ", "YOU FAILED LOOK SAD! ", "BAD END! ", "Christmas is RUINED! ",
            "You are UNEMPLOYED. ", "Game over Hurricanes - better luck next time! ", "Alas, your quest is over. ",
            "Well, you can't expect to win 'em all... ", "Doom Is Victorious! "
    };

    public static String getRandom() {
        int index = random.nextInt(listOfWords.length);
        return listOfWords[index];
    }
}