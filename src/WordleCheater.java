import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class WordleCheater {
    public static void main(String[] args) throws IOException {

        // Set up file and linked list of words
        File words = new File("src/words.txt");
        Scanner scan = new Scanner(words);
        LinkedList list = new LinkedList(scan.nextLine());
        while(scan.hasNextLine()) {
            list.insert(scan.nextLine());
        }
        System.out.print("Welcome to wordle cheater!\n**************************\n\n");

        while(list.size() > 1) {
            // Take user inputs
            scan = new Scanner(System.in);
            String greens, yellows, grays;

            boolean first = true;
            do {
                if (!first) {
                    System.out.println("  Invalid! Please enter 5 characters, with non-greens denoted by '_'.");
                    System.out.println("  Examples: \"h____\", \"_an_c\", \"_____\"");
                } else first = false;
                System.out.print("Enter your green pattern: ");
                greens = scan.nextLine().toLowerCase();

            } while (!greens.matches("[_a-z]{5}"));
            System.out.println();

            first = true;
            do {
                if (!first) {
                    System.out.println("  Invalid! Please enter 5 characters, with non-yellows denoted by '_'.");
                    System.out.println("  Examples: \"__a__\", \"m_a__\", \"_____\"");
                } else first = false;
                System.out.print("Enter your yellow pattern: ");
                yellows = scan.nextLine().toLowerCase();

            } while (!yellows.matches("[_a-z]{5}"));
            System.out.println();

            first = true;
            do {
                if (!first) {
                    System.out.println("  Invalid! Please enter only letters");
                    System.out.println("  Examples: \"j\", \"slekmzxt\"");
                } else first = false;
                System.out.print("Enter your gray letters: ");
                grays = scan.nextLine().toLowerCase();

            } while (!grays.matches("[a-z]*"));
            System.out.println();

            // Filter and print suggestions
            list.filter(greens, yellows, grays);
            if (list.size() > 0)
                System.out.printf("Your suggested words are:\n%s\n----------------\n\n", list);
            else
                System.out.println("No valid words found!");
        }
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

    public void filter(String greens, String yellows, String grays) {
        if(!greens.equals("_____"))
            filterByGreen(greens);
        if(!yellows.equals("_____"))
            filterByYellow(yellows);
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

    private void filterByYellow(String yellows) {
        Node current = head;
        while(current != null) {
            if(!current.containsElsewhere(yellows))
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

        private boolean containsAny(String grays) {
            for(char gr: grays.toCharArray())
                for(char vc: value.toCharArray())
                    if(gr == vc) return true;
            return false;
        }

        private boolean containsElsewhere(String yellows) {
            char[] y = yellows.toCharArray();
            for(int i=0; i < y.length; i++) {
                if(y[i] != '_' && !containsElsewhere(y[i], i))
                    return false;
            }
            return true;
        }

        private boolean containsElsewhere(char c, int pos) {
            for(int i=0; i < value.length(); i++) {
                if(i!=pos && value.charAt(i) == c)
                    return true;
            }
            return false;
        }
    }
}

