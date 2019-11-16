# Linkdictionary
##### By: Luis Guillermo Velasco & Carmen Oballe

## Refactor Branch
Faster branch code was refactored using the following principles:
* Meaningful names
* Keep functions small
* Avoid redundant commenting
* Single responsibility principle
* Don’t repeat yourself
* Keep your code simple
* You ain’t gonna need it

### Examples
Although changes where made through the entirety of the code, here
are some examples:

* The method _compareTwoFiles()_ was renamed to _compareIfTwoFilesAreTheSame()_

* The method createSortedLinkedListFromFileAndAddItToNewFile() was created in order to organize and clean the main method. 
``` java 
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
```

* The _LinkedList.java_ class was deleted as it was not being used 

* Methods were reanmed to better express their function
 * createSortedLinkedListFromFileAndAddItToNewFile()
 * allow10UserInputsToFindWordsInTheSortedLinkedList()
 * performanceTestForAddingFromAFileAndWritingToAnother()
 * findWordAtAnIndex
