package com.company;
import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        // performanceTestForAddingFromAFileAndWritingToAnother();

        createSortedLinkedListFromFileAndAddItToNewFile();

        allow10UserInputsToFindWordsInTheSortedLinkedList();

    }

    public static void createSortedLinkedListFromFileAndAddItToNewFile() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("sortedtest.txt"));

        Node start = new Node("discontents");

        long first = System.currentTimeMillis();
        start.insertFromFile("test.txt");
        long last = System.currentTimeMillis();
        System.out.println("Time to insert to the binary tree: " + (last-first) + " milliseconds");

        first = System.currentTimeMillis();
        start.addToFile(bw);
        bw.close();
        last = System.currentTimeMillis();
        System.out.println("Time to add to a file: " + (last-first) + " milliseconds");
    }

    public static void allow10UserInputsToFindWordsInTheSortedLinkedList() throws IOException {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 10; i++ ) {
            System.out.println("Enter a command");
            String command = scan.nextLine();

            if(command.matches("^-?\\d+$")) {
                int temp = Integer.parseInt(command);

                if (temp == -1) {
                    System.out.println(compareIfTwoTextFilesAreTheSame("sortedtest.txt", "sortedtest_2.txt"));
                } else {
                    System.out.println(findWordAtAnIndex(temp, "sortedtest.txt"));
                }
            } else {
                System.out.println(findIndexOfAWordInTheSortedLinkedList(command, "sortedtest.txt"));
            }

        }
    }

    public static int compareIfTwoTextFilesAreTheSame(String file1, String file2) throws IOException {

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

    public static void performanceTestForAddingFromAFileAndWritingToAnother() throws IOException {

        long insert = 0;
        long insertMin = 0;
        long insertMax = 0;

        long write = 0;
        long writeMin = 0;
        long writeMax = 0;


        for (int i = 0; i < 10; i ++) {
            BufferedWriter bw = new BufferedWriter(new FileWriter("sortedtest.txt"));

            Node start = new Node("discontents");

            long first = System.currentTimeMillis();
            start.insertFromFile("unsorteddict.txt");
            long last = System.currentTimeMillis();

            if (insertMin == 0) {
                insertMin = (last-first);
            } else if ((last-first) < insertMin) {
                insertMin = (last-first);
            }
            if ((last-first) > insertMax) {
                insertMax = (last-first);
            }
            insert = (insert + (last-first));

            first = System.currentTimeMillis();
            start.addToFile(bw);
            bw.close();
            last = System.currentTimeMillis();
            if (writeMin == 0) {
                writeMin = (last-first);
            } else if ((last-first) < writeMin) {
                writeMin = (last-first);
            }
            if ((last-first) > writeMax) {
                writeMax = (last-first);
            }
            write = (write + (last-first));
        }

        System.out.println("The average insert time is: " + (insert/10));
        System.out.println("Max time: " + insertMax);
        System.out.println("Min time: " + insertMin);
        System.out.println();;
        System.out.println("The average write time is: " + (write/10));
        System.out.println("Max time: " + writeMax);
        System.out.println("Min time: " + writeMin);

    }

    public static String findWordAtAnIndex(int index, String file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String word = "";

        int lines = 0;
        while (br.readLine() != null) lines++;

        if (lines < index) {
            word = "That index is out of bounds";
        }

        for (int i = 0; i < index; i ++) {
            word = br.readLine();
        }
        return word;
    }

    public static int findIndexOfAWordInTheSortedLinkedList(String word, String file) throws IOException {
        int index = 1;

        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;

        while ((line = br.readLine()) != null) {
            if (line.equals(word)) {
                return index;
            }
            index++;
        }

        return -1;
    }
}



