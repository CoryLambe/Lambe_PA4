import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.HashMap;



public class DuplicateCounter {
    private Map<String, Integer> wordCounter;

    public DuplicateCounter(){
        wordCounter = new HashMap<String,Integer>();
    }

    public void count(String dataFile){
        Scanner incomingfile = null;
        try {
            incomingfile = new Scanner(new File(dataFile));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }
        while(incomingfile.hasNext()) {
            String word = incomingfile.next().toLowerCase();
            Integer count = wordCounter.get(word);
            if(count == null)
                count = 1;
            else
                count = count + 1;
            wordCounter.put(word, count);
        }
        incomingfile.close();
    }

    public void write(String filename){
        try {
            PrintWriter outfile = new PrintWriter(new File(filename));
            for(String key : wordCounter.keySet()) {
                outfile.println(key + " " + wordCounter.get(key));
            }
            outfile.close();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }



}
