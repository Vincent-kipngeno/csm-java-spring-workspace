import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Decoder {

    public static void main(String[] args) {
        try {
            // Decode the message from the input file and print the decoded message
            String decodedMessage = decode("coding_qual_input.txt");
            System.out.println(decodedMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String decode(String messageFile) throws IOException {
        // Read lines from the given messageFile
        String[] lines = Files.readAllLines(Paths.get(messageFile)).toArray(new String[0]);

        // Split line into the word number and the word string itself.
        Map<Integer, String> wordDict = new HashMap<>();
        for (String line : lines) {
            String[] parts = line.split("\\s+");
            int wordNumber = Integer.parseInt(parts[0]);
            String word = parts[1];
            wordDict.put(wordNumber, word);
        }

        // Decode the message recursively
        return decodeRecurse(wordDict, "", 1, 2);
    }

    // A recursive function to process each row of the pyramid while decoding
    // the given message. The last digit at each row of the pyramid act as the
    // key to decode the current word
    private static String decodeRecurse(Map<Integer, String> wordDict, String message, int lastDigit, int nextRow) {
        if (!wordDict.containsKey(lastDigit)) {
            return message.trim();
        }

        message += wordDict.get(lastDigit) + " ";

        return decodeRecurse(wordDict, message, lastDigit + nextRow, nextRow + 1);
    }
}
