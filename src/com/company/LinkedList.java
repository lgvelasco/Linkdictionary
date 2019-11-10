package com.company;
import java.io.*;

public class LinkedList<E> {
    Node head;


    public void append(E word) {
        if (head == null) {
            head = new Node(word);
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(word);
    }

    public void prepend(E word) {
        Node newHead = new Node(word);
        newHead.next = head;
        head = newHead;
    }

    public void addAlphabetically(E word) {
        if (head==null) {
            append(word);
        } else if (head.next == null) {
            if (head.word.toString().compareToIgnoreCase((String) word) < 0 ) {
                append(word);
            }
         }

        if (head.word.toString().compareToIgnoreCase((String) word) > 0) {
            prepend(word);
        } else {
            Node current = head;
            while(current.next != null) {
                if (current.next.word.toString().compareToIgnoreCase((String) word) > 0) {
                    Node move = current.next;
                    current.next = new Node(word);
                    current.next.next = move;
                    return;
                }
                current = current.next;
            }
            if (current.next == null) {
                if (current.word.toString().compareToIgnoreCase((String) word) < 0) {
                    append(word);
                }
            }
        }

    }


    public void addAlphabeticallyFromFile(String file){
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                addAlphabetically((E) line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Add to a LinkList from a File
    public void addToFile(String file) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));

        Node current = head;
        while(current != null) {
            bw.write(current.word.toString());
            bw.newLine();
            current = current.next;
        }
        bw.close();

    }

    // Return the index of a word
    public int find(String word){
        Node current = this.head;
        int index = 1;
        while (current != null) {
            if (current.word.equals(word)) {
                return index;
            }
            index ++;
            current = current.next;
        }
        return -1;
    }

    // Get the word at that index
    public String get(int index) {
        Node current = this.head;
        for (int i = 0; i < index; i++){
            current = current.next;
        }
        return current.word.toString();
    }

    // Print all the words in the LinkList
    public void show()
    {
        Node node = head;

        while(node.next!=null)
        {
            System.out.println(node.word);
            node = node.next;
        }
        System.out.println(node.word);
    }

}
