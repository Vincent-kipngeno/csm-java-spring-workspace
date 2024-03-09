/**
 * Explanation:
 *
 * The code below builds a pyramid recursively and uses the constructed pyramid to decode the message in the given input
 * file with the help of the below explained functions:
 *
 *     buildPyramid() function recursively constructs the pyramid and extracts the decoded message based on the last
 *     digit of each line. It takes three parameters: result (the decoded message so far), key (the last digit of the
 *     current pyramid row), and counter (to compute the next key). When the last key is exceeded, it returns the
 *     decoded message.
 *
 *     decode() function reads the encoded words and their keys from the input file, maps them to the wordsDict, and
 *     then calls buildPyramid to decode the message. It returns the decoded message.
 *
 *     In the main() method, the decode function is called with the provided sample file (encoded.txt) to display the
 *     decoded message.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class PyramidDecoder {

    // Initialize a static words map to store the words and key mappings
    private static HashMap<Integer, String> wordsDict = new HashMap<>();

    // A recursive function to build a pyramid and extract the decoded word based on the last digit of each line
    // The initial result is empty, initial key is 1, and initial counter is 2
    private static String buildPyramid(String result, int key, int counter) {
        // Base case to check if the end of the words map
        if (key > wordsDict.size()) {
            return result.trim();
        }

        result += wordsDict.get(key) + " ";

        return buildPyramid(result, key + counter, counter + 1);
    }

    // Decodes the message from the input file
    public static String decode(String messageFile) {
        try {
            // Read the words and their keys from the input file and map them to the words map
            BufferedReader reader = new BufferedReader(new FileReader(messageFile));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.trim().split(" ");
                int idx = Integer.parseInt(parts[0]);
                String word = parts[1];
                wordsDict.put(idx, word);
            }
            reader.close();

            // Extract and return the decoded message from the pyramid
            return buildPyramid("", 1, 2);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(decode("encoded.txt"));
    }
}
