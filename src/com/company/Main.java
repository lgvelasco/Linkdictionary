package com.company;
import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        LinkedList<String> dictionary = new LinkedList<String>();

        long start = System.currentTimeMillis();
        dictionary.addAlphabeticallyFromFile("test.txt");
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();
        dictionary.addToFile("sortedtest.txt");
        end = System.currentTimeMillis();
        System.out.println(end - start);

        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
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
                int index = Integer.parseInt(command);

                if (index == -1) {
                    System.out.println(compareTwoFiles("solution_test.txt", "sortedtest.txt"));
                } else {
                    System.out.println(dictionary.get(index));
                }
            } else {
                int index = dictionary.find(command);
                System.out.println(index);
            }

        }
    }

    public static int compareTwoFiles(String file1, String file2) throws IOException {

        BufferedReader fileOne = new BufferedReader(new FileReader(file1));
        BufferedReader fileTwo = new BufferedReader(new FileReader(file2));

        String line;
        String line2;

        while ((line = fileOne.readLine()) != null && (line2 = fileTwo.readLine()) != null) {
            if (!line.equalsIgnoreCase(line2)) {
                return -1;
            }
        }

        return 0;
    }
}

