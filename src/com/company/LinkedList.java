package com.company;
import java.io.*;

public class LinkedList<E> {
    Node head;

    public void insert(String word) {
        if (head == null) {
            head = new Node(word);
        }
        if (this.head.word.compareToIgnoreCase(word) > 0) {
            if (head.left == null) {
                head.left = new Node(word);
            } else {
                head.left.insert(word);
            }
        } else {
            if (head.right == null) {
                head.right = new Node(word);
            } else {
                head.right.insert(word);
            }
        }
    }

    public void insertFromFile(String file){
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                insert(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void addToFile(String file) throws IOException {
//        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
//
//        if (head.left != null) {
//            head.left.returnWordsInOrder(file);
//        }
//        bw.write(head.word);
//        bw.newLine();
//        if (head.right != null) {
//            head.right.returnWordsInOrder(file);
//        }
//        bw.close();
//
//    }

    public void printInOrder() {
        if (head.left != null) {
            head.left.printInOrder();
        }
        System.out.println(head.word);
        if (head.right != null) {
            head.right.printInOrder();
        }
    }





//
//    // Return the index of a word
//    public int find(String word){
//        Node current = this.head;
//        int index = 0;
//        while (current != null) {
//            if (current.word.equals(word)) {
//                return index;
//            }
//            index ++;
//            current = current.next;
//        }
//        return -1;
//    }
//
//    // Get the word at that index
//    public String get(int index) {
//        Node current = this.head;
//        for (int i = 0; i < index; i++){
//            current = current.next;
//        }
//        return current.word.toString();
//    }
//
//    // Print all the words in the LinkList
//    public void show()
//    {
//        Node node = head;
//
//        while(node.next!=null)
//        {
//            System.out.println(node.word);
//            node = node.next;
//        }
//        System.out.println(node.word);
//    }

}
