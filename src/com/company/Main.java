package com.company;
import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        long first = System.currentTimeMillis();
        BufferedWriter bw = new BufferedWriter(new FileWriter("sorteddict.txt"));

        Node start = new Node("discontents");
        start.insertFromFile("unsorteddict.txt");
        start.addToFile(bw);
        bw.close();
        long last = System.currentTimeMillis();
        System.out.println(last-first);

        Scanner scan = new Scanner(System.in);

        boolean flag = true;

        FileReader fr = new FileReader("sorted.test")

        while (flag) {
            System.out.println("Please enter a command");
            System.out.println("If the argument is a number, the dictionary will print the word at that position.");
            System.out.println("If the argument is a word, the dictionary will print the position of that word.");
            System.out.println("Enter exit to end program");

            String command = scan.nextLine();
            if (command.equalsIgnoreCase( "exit")) {
                break;
            }

            // Regex to see if the command is and integer or a string
            if(command.matches("^\\d+(\\.\\d+)?")) {
                if
            } else {
                int index = dictionary.find(command);
                System.out.println(index);
            }

        }

        boolean flag = true;
        while (true) {
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



