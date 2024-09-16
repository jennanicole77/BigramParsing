package bigramParsing;

import bigramParsing.Main;
import java.io.*;

/*
 * Bigram Parsing testing class.
 */
public class BigramParsingTest {
    
    private static ByteArrayOutputStream outStream = new ByteArrayOutputStream();
    private static PrintStream standard = System.out; 

    /*
     * Main testing method that runs multiple tests.
     */
    public static void main(String[] args) {
        String invalidArgs = "Invalid arguments. Please enter 1 argument - the file name you wish to read.";
        String invalidFile = "(The system cannot find the file specified)";

        // Test for empty arguments
        test("Empty Arguments", new String[] {}, invalidArgs);
    
        // Test for multiple (>1) arguments
        test("Multiple Arguments", new String[] {"file.txt", "1"}, invalidArgs);

        // Test argument given, but not a standard file name
        test("1: Invalid File Name", new String[] {"1"}, "1 " + invalidFile);

        // Test for invalid file given
        test("2: Invalid File Name", new String[] {"file.txt"}, "file.txt " + invalidFile);

        // Test for empty file given
        test("Empty File", new String[] {"../../resources/empty.txt"}, "");
       
        // Test for file with a single word
        test("One Word", new String[] {"../../resources/singleWord.txt"}, "");
       
        // Test for file with just new lines
        test("New Lines", new String[] {"../../resources/newLines.txt"}, "");
       
        // Test for white space surrounding text
        test("Surrounding White Space", new String[] {"../../resources/whiteSpaceSurrounding.txt"}, 
                "{extra space=1, space test=1}");
       
        // Test for space between text
        test("Space Between Text", new String[] {"../../resources/spaceBetweenText.txt"}, 
                "{space between=1, between test=1}");
       
        // Test for no duplicates
        test("No Duplicates", new String[] {"../../resources/noDuplicates.txt"}, 
                "{no duplicates=1, duplicates test=1}");
    
        // Test with all duplicates
        test("All Duplicates", new String[] {"../../resources/allDuplicates.txt"}, "{hi hi=3}");
       
        // Test given example
        test("Given Example", new String[] {"../../resources/example.txt"}, 
                "{the quick=2, quick brown=1, brown fox=1, fox and=1, and the=1, quick blue=1, blue hare=1}");
    }
   
    /*
     * Generic test that calls the main application's function, reads the output stream, 
     * and determines if tests passes or fails.
     * @param name: the name of the test.
     * @param args: the arguments to send to main.
     * @param expected: the expected output.
     */
    private static void test(String name, String[] args, String expected) {
        // Set output stream and call main application's static main method.
        outStream.reset();
        System.setOut(new PrintStream(outStream));
        Main.main(args);
        String output = outStream.toString().trim();
        System.setOut(standard);

        // Compare output to expected result
        // Print pass/fail result of the test
        Boolean passFail = expected.equals(output);
        String passFailStr = passFail ? name + " Test: Pass" : name + " Test: Fail";
        System.out.println(passFailStr + (passFail ? "\n" : "\nExpected Output: " + expected + "\nOutput: " + output + "\n"));
    }
}
