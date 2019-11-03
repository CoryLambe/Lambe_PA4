import java.util.Set;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedHashSet;
import java.io.FileNotFoundException;
import java.io.IOException;



public class DuplicateRemover {
    String uniqueWords = "";

    public void remove(String dataFile) {
        int i;
        FileReader FR;

        try {
            FR = new FileReader(dataFile);
            while ((i = FR.read()) != -1)
                uniqueWords += (char) i;

            Set<String> wordSet = new LinkedHashSet<String>();
            int start = 0;
            for(int j = 0; j < uniqueWords.length(); j++) {
                if (uniqueWords.charAt(j) == ' '){
                    wordSet.add(uniqueWords.substring(start, j));
                    start = j + 1;
                }
            }
            FR.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found.");
        } catch (IOException e) {
            System.out.println("Input or Output Exception");
        } finally {
            System.out.println("Data Read Successful");
        }
    }
    public void write(String outputFile ){

        try {
            FileWriter FW = new FileWriter(outputFile);
            String wordString = String.join(" ", uniqueWords);

            FW.write(wordString);
            FW.close();
        } catch (Exception e) {
            System.out.println("File unable to open " + outputFile + "for writing");
        }
    }
}