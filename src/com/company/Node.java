package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;

public class Node {
    Node left;
    Node right;
    String word;

    public Node(String word) {
        this.word = word;
    }

    public void insert(String word) {
        if (this.word.compareToIgnoreCase(word) > 0) {
            if (left == null) {
                left = new Node(word);
            } else {
                left.insert(word);
            }
        } else {
            if (right == null) {
                right = new Node(word);
            } else {
                right.insert(word);
            }
        }
    }

    public void printInOrder() {
        if (left != null) {
            left.printInOrder();
        }
        System.out.println(word);
        if (right != null) {
            right.printInOrder();
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

        public void addToFile(BufferedWriter bw) throws IOException {
        if (left != null) {
            left.addToFile(bw);
        }
        bw.write(word);
        bw.newLine();
        if (right != null) {
            right.addToFile(bw);
        }
    }

}
