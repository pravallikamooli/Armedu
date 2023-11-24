import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Scanner;

public class ReverseSentence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String inputSentence = scanner.nextLine();

        String reversedSentence = reverseSentence(inputSentence);
        System.out.println("Reversed Sentence: " + reversedSentence);

        scanner.close();
        org.junit.runner.JUnitCore.main("ReverseSentence");

    }

    public static String reverseSentence(String sentence) {
        String[] words = sentence.split("\\s+");
        StringBuilder reversedSentence = new StringBuilder();

        for (String word : words) {
            StringBuilder reversedWord = new StringBuilder(word).reverse();
            reversedSentence.append(reversedWord).append(" ");
        }

        return reversedSentence.toString().trim();

    }

    @Test
    public void testEmptyString() {
        assertEquals("", reverseSentence(""));
    }

    @Test
    public void testOneWord() {
        assertEquals("desserts", reverseSentence("stressed"));
    }

    @Test
    public void testMultipleWords() {
        assertEquals("sihT si a tset", reverseSentence("This is a test"));
    }

    @Test
    public void testSpecialCharacters() {
        String reversed = reverseSentence("Hello, World!");
        String[] originalWords = {"Hello", "World"};
        for (String word : originalWords) {
            assertTrue("Expected: " + word + " in reversed sentence, Actual: " + reversed, reversed.contains(word));
        }
        assertTrue("Expected special characters in reversed sentence, Actual: " + reversed, reversed.matches(".*[^a-zA-Z ].*"));
    }

}
