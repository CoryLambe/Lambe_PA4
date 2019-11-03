
public class Application {

    public static void main(String[] args) {

        DuplicateRemover DR = new DuplicateRemover();
        System.out.println("System.getProperty");

        DR.remove("problem1.txt");
        DR.write("unique_words.txt");


    }

}
