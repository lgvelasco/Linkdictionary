package com.company;
import java.io.*;
import java.util.Scanner;

public class Main {

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

    public static void performanceTest() throws IOException {

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

    public static void main(String[] args) throws IOException {

        // performanceTest();

        BufferedWriter bw = new BufferedWriter(new FileWriter("sortedtest.txt"));

        Node start = new Node("discontents");

        long first = System.currentTimeMillis();
        start.insertFromFile("test.txt");
        long last = System.currentTimeMillis();
        System.out.println("Time to insert to the binary tree: " + (last-first) + "milliseconds");

        first = System.currentTimeMillis();
        start.addToFile(bw);
        bw.close();
        last = System.currentTimeMillis();
        System.out.println("Time to add to a file: " + (last-first) + "milliseconds");

        Scanner scan = new Scanner(System.in);

        boolean flag = true;
        while (flag) {
            System.out.println("Enter a command");
            String command = scan.nextLine();
            if (command.equalsIgnoreCase("exit")) {
                flag = false;
            } else if (command.equalsIgnoreCase("check")) {
                System.out.println(compareTwoFiles("sortedtest.txt", "sortedtest_2.txt"));
            } else {
                System.out.println(start.containsWord(command));

            }
        }

    }


}



