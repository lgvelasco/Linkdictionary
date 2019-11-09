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



