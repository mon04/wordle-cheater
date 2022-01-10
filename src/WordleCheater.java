import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class WordleCheater {
    public static void main(String[] args) throws IOException {
        File words = new File("words.txt");
        Scanner scan = new Scanner(words);
        LinkedList list = new LinkedList(scan.nextLine());
        while(scan.hasNextLine()) {
            list.insert(scan.nextLine());
        }
        System.out.print("Welcome to Wordle Cheater!\nPlease enter a pattern: ");
        scan = new Scanner(System.in);
        list.filter(scan.nextLine());
        System.out.println(list);
    }
}

class LinkedList {
    private Node head;

    public LinkedList(String value) {
        this.head = new Node(value);
        //head.next = null;
    }

    public void filter(String pattern) {
        Node current = head;
        while(current != null) {
            if(!current.matches(pattern))
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
        return s.substring(0, s.length()-1);
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
    }

    private void remove(Node node) {
        if(node == head) {
            head = node.next;
            head.prev = null;
            return;
        }
        if(node.prev != null)
            node.prev.next = node.next;
        if(node.next != null)
            node.next.prev = node.prev;
    }

    private static class Node {
        private final String value;
        private Node prev;
        private Node next;

        private Node(String value) {
            this.value = value;
        }

        private boolean matches(String pattern) {
            char[] p = pattern.toCharArray();
            char[] v = value.toCharArray();
            if(p.length != v.length)
                return false;
            for(int i=0; i < p.length; i++)
                if(p[i] != '_' && p[i] != v[i])
                    return false;
            return true;
        }
    }
}

