package com.company;
import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        long first = System.currentTimeMillis();
        BufferedWriter bw = new BufferedWriter(new FileWriter("soreted.txt"));

        Node start = new Node("discontents");
        start.insertFromFile("unsorteddict.txt");
        start.addToFile(bw);
        bw.close();
        long last = System.currentTimeMillis();
        System.out.println(last-first);

    }


}



