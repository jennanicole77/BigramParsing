package bigramParsing;

import java.util.regex.*;
import java.util.*;


/*
 * This classes parses bigram's from given data.
 */
public class BigramParser {

    private LinkedHashMap<String, Integer> bigrams;

    public BigramParser(String data) {
        parse(data);
    }

    public String getBigrams() {
        return bigrams.isEmpty() ? "" : bigrams.toString();
    }

    private void parse(String data) {
        // Create pattern of only words, and set matcher
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(data);
        
        bigrams = new LinkedHashMap<String, Integer>();
        String firstWord = null;

        while(matcher.find()) {
            String secondWord = matcher.group();

            // If this is the first word, continue on to get second
            if(firstWord == null) {
                firstWord = secondWord;
                continue;
            }

            String currBigram = firstWord.toLowerCase() + " " + secondWord.toLowerCase();

            // If the current bigram is already in the map, increment count
            // Otherwise, add to map.
            if(bigrams.containsKey(currBigram)) {
                int currCount = bigrams.get(currBigram);
                bigrams.replace(currBigram, currCount+1);
            } else {
                bigrams.put(currBigram, 1);
            }

            firstWord = secondWord;
        }
    }
}

