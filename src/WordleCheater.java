import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class WordleCheater {
    public static void main(String[] args) throws IOException {
        // Set up file and linked list of words
        File words = new File("src/wordles.txt");
        Scanner scan = new Scanner(words);
        LinkedList list = new LinkedList(scan.nextLine());
        while(scan.hasNextLine()) {
            list.insert(scan.nextLine());
        }
        System.out.print("Welcome to wordle cheater!\n**************************\n");

        // Take user inputs
        scan = new Scanner(System.in);
        System.out.print("\nEnter your green letters: ");
        String greens = scan.nextLine().toLowerCase();
        while(!greens.matches("[_a-z]{5}")) {
            System.out.print(greenError());
            greens = scan.nextLine().toLowerCase();
        }
        System.out.print("\nEnter your gray letters: ");
        String grays = scan.nextLine().toLowerCase();
        while(!grays.matches("[a-z]*")) {
            System.out.print(grayError());
            grays = scan.nextLine().toLowerCase();
        }

        // Filter according to user input and print suggestions
        list.filter(greens, grays);
        String listString = list.toString();
        if(listString.length() > 0)
            System.out.printf("\nYour suggested words are:\n%s\n", listString);
        else
            System.out.println("\nNo valid words found!");
    }

    public static String greenError() {
        return  "  ERROR: Invalid input!\n"+
                "  Please ensure your pattern has 5 characters and unknowns are denoted with '_'\n"+
                "  E.g. \"_el_o\"\n"+
                "  E.g. \"_____\"\n\n"+

                "Enter your green letters: ";
    }

    public static String grayError() {
        return  "  ERROR: Invalid input!\n"+
                "  Please ensure your string is empty or contains only letters."+
                "  E.g. \"j\"\n"+
                "  E.g. \"jmopi\"\n\n"+

                "Enter your gray letters: ";
    }
}

class LinkedList {
    private Node head;
    private int size;

    public LinkedList(String value) {
        this.head = new Node(value);
        size = 1;
        //head.next = null;
    }

    public void filter(String greens, String grays) {
        if(!greens.equals("_____"))
            filterByGreen(greens);
        if(grays.length() > 0)
            filterByGrays(grays);
    }

    public void filterByGreen(String greens) {
        Node current = head;
        while(current != null) {
            if(!current.matches(greens))
                remove(current);
            current = current.next;
        }
    }

    public void filterByGrays(String grays) {
        Node current = head;
        while(current != null) {
            if(current.containsAny(grays))
                remove(current);
            current = current.next;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while(current != null) {
            sb.append(current.value);
            sb.append('\n');
            current = current.next;
        }
        String s = sb.toString();
        return (s.length() > 0) ?s.substring(0, s.length()-1) :"";
    }

    public int size() {
        return size;
    }

    public void insert(String value) {
        if(head == null) {
            head = new Node(value);
            return;
        }
        Node current = head;
        while(current.next != null)
            current = current.next;
        current.next = new Node(value);
        current.next.prev = current;
        size++;
    }

    private void remove(Node node) {
        if(node == head && head != null) {
            head = node.next;
            if(head != null) head.prev = null;
            return;
        }
        if(node.prev != null)
            node.prev.next = node.next;
        if(node.next != null)
            node.next.prev = node.prev;
        size--;
    }

    private static class Node {
        private final String value;
        private Node prev;
        private Node next;

        private Node(String value) {
            this.value = value;
        }

        private boolean matches(String green) {
            char[] p = green.toCharArray();
            char[] v = value.toCharArray();
            if(p.length != v.length)
                return false;
            for(int i=0; i < p.length; i++)
                if(p[i] != '_' && p[i] != v[i])
                    return false;
            return true;
        }

        private boolean containsAny(String gray) {
            for(char gr: gray.toCharArray())
                for(char vc: value.toCharArray())
                    if(gr == vc) return true;
            return false;
        }
    }
}

