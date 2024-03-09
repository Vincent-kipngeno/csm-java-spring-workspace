/*
The Java code below reads the lines of a file with an encoded message, then decodes it using recursion. The recursion
emulates a pyramid structure where under each recursive function instance we deal with only one row of the pyramid.
The function uses the current key and the next pyramid row number to find the next key by adding them together. This
computed key is used to get the decoded word at the current row of the pyramid. Initially, the starting key is 1 with
the next row being row number 2. This pattern is continued recursively until the end of the pyramid (that is, until we
extract the last word with the highest possible index/key in the word map). Finally, the full decoded message is printed
to the console.
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Decoder_0 {

    private static final Map<Integer, String> idxWordMap = new HashMap<>();

    /*
    A recursive function to build a pyramid like structure while computing the last digit of each
    pyramid row by adding the next row number to the current last digit hence giving a key that can
    be used to get the decoded word from the word map.
     */
    private static String recursive_decoder(String result, int key, int nextRowNum) {
        // Base case to check if this is the last digit in the word map
        if (key > idxWordMap.size()) return result.trim();
        // Get the decoded word
        String nextWord = idxWordMap.get(key);
        // Continue to the next row of the pyramid
        return recursive_decoder(result + nextWord + " ", key + nextRowNum, nextRowNum + 1);
    }

    public static void main(String[] args) {
        try {

            // Read all lines from the file
            List<String> lines = Files.readAllLines(Paths.get("input.txt"));
            for (String line : lines) {
                String[] idx_word = line.trim().split(" ");
                idxWordMap.put(Integer.parseInt(idx_word[0]), idx_word[1]);
            }

            // Get the final decoded message based on the recursively built pyramid structure
            String decodedMessage =  recursive_decoder("", 1, 2);

            System.out.println(decodedMessage);

        } catch (IOException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }
}
