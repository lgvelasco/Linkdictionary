package com.company;
import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {


        BufferedWriter bw = new BufferedWriter(new FileWriter("sortedtest.txt"));

        Node start = new Node("discontents");

        long first = System.currentTimeMillis();
        start.insertFromFile("test.txt");
        long last = System.currentTimeMillis();
        System.out.println(last-first);

        first = System.currentTimeMillis();
        start.addToFile(bw);
        bw.close();
        last = System.currentTimeMillis();
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



