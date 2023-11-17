import java.util.*;
import java.lang.*;

public class Hangman1 {

        public static String[] words = { "ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
                        "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
                        "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
                        "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
                        "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon",
                        "python", "rabbit", "ram", "rat", "raven", "rhino", "salmon", "seal",
                        "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
                        "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
                        "wombat", "zebra" };

        public static String[] gallows = { "+---+\n" +
                        "|   |\n" +
                        "    |\n" +
                        "    |\n" +
                        "    |\n" +
                        "    |\n" +
                        "=========\n",

                        "+---+\n" +
                                        "|   |\n" +
                                        "O   |\n" +
                                        "    |\n" +
                                        "    |\n" +
                                        "    |\n" +
                                        "=========\n",

                        "+---+\n" +
                                        "|   |\n" +
                                        "O   |\n" +
                                        "|   |\n" +
                                        "    |\n" +
                                        "    |\n" +
                                        "=========\n",

                        " +---+\n" +
                                        " |   |\n" +
                                        " O   |\n" +
                                        "/|   |\n" +
                                        "     |\n" +
                                        "     |\n" +
                                        " =========\n",

                        " +---+\n" +
                                        " |   |\n" +
                                        " O   |\n" +
                                        "/|\\  |\n" + // if you were wondering, the only way to print '\' is with a
                                                      // trailing escape
                                                      // character, which also happens to be '\'
                                        "     |\n" +
                                        "     |\n" +
                                        " =========\n",

                        " +---+\n" +
                                        " |   |\n" +
                                        " O   |\n" +
                                        "/|\\  |\n" +
                                        "/    |\n" +
                                        "     |\n" +
                                        " =========\n",

                        " +---+\n" +
                                        " |   |\n" +
                                        " O   |\n" +
                                        "/|\\  |\n" +
                                        "/ \\  |\n" +
                                        "     |\n" +
                                        " =========\n" };
        static int crt_cnt = 0;

        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                String ran = randomword();
                String tem = "_".repeat(ran.length());
                char[] wordarr = tem.toCharArray();
                String miss = "";
                int galIndex = 0;

                while (true) {

                        System.out.print("Guess:");
                        char letter = sc.next().charAt(0);
                        if (crt_cnt == ran.length() - 1) {
                                System.out.println("game won");
                                break;
                        }
                        if (checkguess(letter, ran) == true) {
                                char[] updatedWordArr = updatePlaceHolders(letter, ran, wordarr);
                                wordarr = updatedWordArr;
                        } else {
                                miss += letter;
                                galIndex++;
                        }
                        printPlaceHolders(wordarr, miss);
                        System.out.println(gallows[galIndex]);
                        if (galIndex == 6) {
                                System.out.println("Game lost");
                                break;
                        }

                }

        }

        public static String randomword() {
                int ran = (int) (Math.random() * words.length) + 1;
                String ranword = words[ran];
                return ranword;
        }

        public static boolean checkguess(char letter, String ran) {
                return ran.contains("" + letter);
        }

        public static char[] updatePlaceHolders(char letter, String ran, char[] wordarr) {
                int i = 0;
                while (true) {
                        int index = ran.indexOf(letter, i);
                        if (index == -1)
                                break;
                        wordarr[index] = letter;
                        crt_cnt++;
                        i = index + 1;
                }
                return wordarr;

        }

        public static void printPlaceHolders(char[] wordarr, String miss) {
                System.out.print("Words: ");
                for (int i = 0; i < wordarr.length; i++)
                        System.out.print(wordarr[i] + " ");
                System.out.println("\nMissWords: " + miss + "\n");
        }

}
