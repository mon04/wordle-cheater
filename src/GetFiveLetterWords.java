import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class GetFiveLetterWords {
    public static void main(String[] args)  {
        Scanner input = null;
        try {
            input = new Scanner(new File("src/words_full.txt"));
            FileWriter output = new FileWriter(new File("src/five_letter_words.txt"), true);
            while(input.hasNextLine()) {
                String line = input.nextLine();
                if(line.length() == 5)
                    output.write(line+"\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
