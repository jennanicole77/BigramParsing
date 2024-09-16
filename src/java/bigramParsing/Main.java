package bigramParsing;

/*
 * Main application class to run.
 */
public class Main {

    /*
    * Main method that reads in a file, parses bigram from file's data, and prints out a histogram
    * @param args: should have 1 argument which is a filepath.
    */
    public static void main(String[] args) {

        // Check there is only one argument: the file path
        if(args.length != 1) {
            System.out.println("Invalid arguments. Please enter 1 argument - the file name you wish to read.");
            return;
        }

        // Read in file
        ReadFile rf = new ReadFile();
        String data = rf.read(args[0]);

        // Create bigram parser, and get the string
        BigramParser bigramParser = new BigramParser(data);
        System.out.println(bigramParser.getBigrams());
    }
}
