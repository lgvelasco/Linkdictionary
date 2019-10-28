package com.company;
import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        long first = System.currentTimeMillis();
        BufferedWriter bw = new BufferedWriter(new FileWriter("sortedtest.txt"));

        Node start = new Node("discontents");
        start.insertFromFile("test.txt");
        start.addToFile(bw);
        bw.close();
        long last = System.currentTimeMillis();
        System.out.println(last-first);

        Scanner scan = new Scanner(System.in);

        boolean flag = true;
        while (flag) {
            System.out.println("Find a word that is in the dictionary or enter exit");
            String command = scan.nextLine();
            if (command.equalsIgnoreCase("exit")) {
                flag = false;
            } else {
                System.out.println(start.containsWord(command));

            }
        }

    }


}



