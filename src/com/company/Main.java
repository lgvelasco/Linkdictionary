package com.company;

import java.io.*;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {

        LinkedList<String> dictionary = new LinkedList<String>();

        try (BufferedReader br = new BufferedReader(new FileReader("unsorteddict.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Add word by word in alphabetical order to list
                dictionary.add(line);
            }
        }

        System.out.println(dictionary);

//        Collections.sort(dictionary);
        System.out.println(dictionary.toString());

        FileWriter fw = new FileWriter("sorteddict.txt");

        for (String temp : dictionary) {
            fw.write(temp.toString());
        }

    }
}
