package bigramParsing;

import java.io.*;

/*
 * This classes single purpose is to read in a given file.
 */
public class ReadFile {
  
    /*
     * Read's in a file
     * @param file: file name/path
     */
    public String read(String file) {
       
        String data = "";
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            
            String currLine;
            while((currLine= br.readLine()) != null) {
                data += currLine + "\n";
            }
            
            br.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return data;
    }
}
