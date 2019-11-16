package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;

public class treeNode {
    treeNode left;
    treeNode right;
    String word;
    int index = 0;

    public treeNode(String word) {
        this.word = word;
    }

    public void insert(String word) {
        if (this.word.compareToIgnoreCase(word) > 0) {
            if (left == null) {
                left = new treeNode(word);
            } else {
                left.insert(word);
            }
        } else {
            if (right == null) {
                right = new treeNode(word);
            } else {
                right.insert(word);
            }
        }
    }

    public boolean containsWord(String word) {
        if (word.equalsIgnoreCase(this.word)) {
            return true;
        } else if (this.word.compareToIgnoreCase(word) > 0) {
            if (left == null) {
                return false;
            } else {
                return left.containsWord(word);
            }
        } else {
            if (right == null) {
                return false;
            } else {
                return right.containsWord(word);
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
