/**
 * This Java program reads an encoded message from a file and decodes it using a pyramid
 * decoding structure. Each row of the pyramid corresponds to a decoded word, and the last
 * digit of each row serves as a key to retrieve the word from the encoded message. The
 * program reads the encoded message and its corresponding keys from a file, constructs the
 * decoding structure recursively, and prints the decoded message as the output.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PyramidDecoding {

    // A map to store encoded words and their respective keys
    private static Map<Integer, String> encodedWords = new HashMap<>();

    // A recursive function to construct a decoding structure and decipher the encoded message
    // based on the last digit of each row.
    // It starts with an empty decoded message, a key of 1, and a step of 2.
    private static String constructPyramid(String decodedMessage, int currentKey, int step) {
        // Base case: Check if the current key exceeds the maximum key in the dictionary.
        if (currentKey > encodedWords.size()) {
            return decodedMessage.trim(); // Remove any trailing whitespace and return the decoded message.
        }

        // Decode the word based on the current key.
        decodedMessage += encodedWords.get(currentKey) + " ";

        // Continue decoding and extracting other words in the structure until reaching the end of the dictionary.
        // Increment the key by the step to get the next key and increment the step by 1.
        return constructPyramid(decodedMessage, currentKey + step, step + 1);
    }

    // Decode the message from the input file
    private static String decodeMessage(String encodedFile) {
        // Read the encoded words and their keys from the input file and store them in the global encodedWords map.
        try (BufferedReader br = new BufferedReader(new FileReader(encodedFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split(" ");
                int idx = Integer.parseInt(parts[0]);
                String word = parts[1];
                encodedWords.put(idx, word);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Extract and return the decoded message from the constructed decoding structure.
        return constructPyramid("", 1, 2);
    }

    // Display the decoded message based on the provided sample file.
    public static void main(String[] args) {
        System.out.println(decodeMessage("encoded.txt"));
    }
}
