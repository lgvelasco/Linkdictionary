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

//    public String returnWordsInOrder() {
//        if (left != null) {
//            left.returnWordsInOrder();
//        }
//        return word;
//        if (right != null) {
//            right.printInOrder();
//        }
//    }
}
