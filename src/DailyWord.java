import java.util.Random;
//Temporary word bank for the Main class
//@Author Jazmine McGowan

public class DailyWord {
    private static final Random random = new Random();

    private static final String[] listOfWords = {
         "BACON", "MOIST", "MANIA", "CLOUT", "CLOUD", "ZEBRA",
         "SPICY", "SUGAR", "PROPS", "FJORD", "POWER", "PUNCH"
    };

    public static String getRandom() {
        int index = random.nextInt(listOfWords.length);
        return listOfWords[index];
    }
}

