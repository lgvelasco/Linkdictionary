package com.company;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        LinkedList<String> dictionary = new LinkedList<String>();

        try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                dictionary.addAlphabetically(line);
            }
        }

        dictionary.show();

    }
}

