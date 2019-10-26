package com.company;
import java.io.*;

public class LinkedList<E> {
    Node head;






//    public void addAlphabeticallyFromFile(String file){
//        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                addAlphabetically((E) line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // Add to a LinkList from a File
//    public void addToFile(String file) throws IOException {
//        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
//
//        Node current = head;
//        while(current != null) {
//            bw.write(current.word.toString());
//            bw.newLine();
//            current = current.next;
//        }
//        bw.close();
//
//    }
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
