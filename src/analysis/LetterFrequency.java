package analysis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class LetterFrequency {
    public static void main(String[] args) {
        //number of occurrences in all words (repeats counted)
        int[] freqs = new int[26];
        Arrays.fill(freqs, 0);

        //number of words which contain letter
        int[] pres = new int[26];
        Arrays.fill(pres, 0);

        try {
            Scanner scan = new Scanner(new File("src/wordles.txt"));
            while(scan.hasNextLine()) {
                boolean[] contains = new boolean[26]; Arrays.fill(contains, false);
                char[] word = scan.nextLine().toLowerCase().toCharArray();
                for(char c: word) {
                    int i = c-'a';
                    freqs[i]++;
                    contains[i] = true;
                }
                for(int i=0; i < 26; i++) {
                    if(contains[i])
                        pres[i]++;
                }
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Letter[] letters = new Letter[26];
        for(int i=0; i < 26; i++) {
            char c = (char)('a'+i);
            letters[i] = new Letter(c, freqs[i], pres[i]);
        }

        for(int i=0; i < 26; i++) {
            for(int j=1; j < (26-i); j++) {
                if(letters[j-1].getWordPresence() < letters[j].getWordPresence()) {
                    Letter temp = letters[j];
                    letters[j] = letters[j-1];
                    letters[j-1] = temp;
                }
            }
        }

        System.out.println("char\t\tfreq\t   \" %\t\twords\t   \" %");
        System.out.println("----------------------------------------------");
        for(Letter l: letters) {
            int f = l.getFreq();
            int p = l.getWordPresence();
            float fpc = (float)(f*100)/12972;
            float ppc = (float)(p*100)/12972;
            System.out.printf("%4c\t\t%4d\t%6.3f\t\t%5d\t%6.3f\n", l.getValue(), f, fpc, p, ppc);
        }
    }

    public static boolean contains(String word, char c) {
        for(char wc: word.toCharArray())
            if(wc == c) return true;
        return false;
    }
}

class Letter {
    private final char value;
    private final int freq;
    private final int wordPresence;

    public Letter(char value, int freq, int wordPresence) {
        this.value = value;
        this.freq = freq;
        this.wordPresence = wordPresence;
    }

    public char getValue() {
        return value;
    }

    public int getFreq() {
        return freq;
    }

    public int getWordPresence() {
        return wordPresence;
    }

    public String toString() {
        return String.valueOf(value);
    }
}