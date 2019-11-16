# Linkdictionary
##### By: Luis Guillermo Velasco & Carmen Oballe

#### Requisites
* The application will be able to open a file called “unsorteddict.txt”
* This file will be a collection of words where each line contains a word 
* The application will read the file line by line, in other words, it will read a new word each time a new line is read
  * Each time a new line is read, the new word will be inserted in the correct position of a data structure called “dictionary” that will be of a Linked list type
  * Therefore , this “dictionary” will be a sorted list of all the words read from the file
* After the “unsorteddict.txt” has been fully read, the application will create another file called “sorteddict.txt” which will contain all the words (one word per line) alphabetically ordered
* The application will also accept command line arguments, i.e. it could be executed as java LinkDictionary 23 butterfly

## Master Branch
The Master branch is composed of three classes. **Node.java, LinkedList.java, Main.java**. And is able to read words from a file, print them alphabetically into another, and allow the user to search though it. 

### Node 
This class soleley defines the properties of the Node. As having a next Node and storing a value. 
``` java

public class Node <E>{

    Node next;
    E word;

    public Node(E word) {
        this.word = word;
```

### LinkedList.java 
This class handles the creation of nodes and is able to add them alphabetically through _addAlphabetically_ method. 
```java
public void addAlphabetically(E word) {
        if (head==null) {
            append(word);
        } else if (head.next == null) {
            if (head.word.toString().compareToIgnoreCase((String) word) < 0 ) {
                append(word);
            }
         }

        if (head.word.toString().compareToIgnoreCase((String) word) > 0) {
            prepend(word);
        }

        Node current = head;
        while(current.next != null) {
            if (current.word.toString().compareToIgnoreCase((String) word) < 0 && current.next.word.toString().compareToIgnoreCase((String) word) > 0) {
                Node move = current.next;
                current.next = new Node(word);
                current.next.next = move;
                return;
            }
            current = current.next;
        }
        if (current.next == null) {
            if (current.word.toString().compareToIgnoreCase((String) word) < 0) {
                append(word);
            }
        }

    }
```
##### 3 minutes to complete. 

### Main.java
In the class, the program sets up the dictionary, reading from one file and printing alphabetically to another. 
``` java

        LinkedList<String> dictionary = new LinkedList<String>();

        dictionary.addAlphabeticallyFromFile("unsorteddict.txt");

        dictionary.addToFile("sorteddict.txt");
```
Further along, the user is able to search words or indexes up to 10 times. 

## Faster Branch
To increase efficency a binary tree was implemented, reducing the number of path a word has to take to reach its place. 
To achieve this, the _Node_ class was changed to allow it to have to child nodes and regression was used to add the child nodes. 
``` java
public class Node {
    Node left;
    Node right;
    String word;
    int index = 0;

    public Node(String word) {
        this.word = word;
    }

    public void insert(String word) {
        if (this.word.compareToIgnoreCase(word) > 0) {
            if (left == null) {
                left = new Node(word);
            } else {
                left.insert(word);
            }
        } else {
            if (right == null) {
                right = new Node(word);
            } else {
                right.insert(word);
            }
        }
    }
```
This class is also able to add nodes from a file, as well as print them into another in alphabetical order. Nevertheless, it's unable to return the index of a word, but can tell if it can be found in the dictionary. 
##### 0.3 seconds to complete. 

# Part 2 
All further changes (Verification Test, Preformance Test, and checking against different inputs) can be found in the *faster branch*. 

## Verification Test
In order to check if the words in our new created document are correctly sorted, the method _compareTwoFiles_ was created. The method compares two documents as return _-1_ if they are different, and _0_ if they are the same. 
``` java 
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
```
This method is available thorugh the _main_ by writing _check_; it returned 0 for both the 10,000 and 1000,000 word documents. 

## Performance Test 
Various timers are set throughout the project in order to test preformance, additionally a method _preformanceTest_ was created in order to get the average time in milliseconds of two major tasks; reading from a file and adding the word to a binary tree, and adding the binary tree to a new document. 

```java
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
            start.insertFromFile("test.txt");
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
```
#### For 10,000 words
> The average insert time is: 11
>
> Max time: 34. 
> Min time: 6. 
>
> The average write time is: 4. 
>
> Max time: 10. 
> Min time: 1. 
>
>Process finished with exit code 0
#### For 100,000 words
> The average insert time is: 129
> 
> Max time: 185
> Min time: 74
>
> The average write time is: 17
> 
> Max time: 57
> Min time: 7
> 
> Process finished with exit code 0

After analysing the respective times of tasks, no bottlenecks were discoverd. As the program cannot be improved using binary trees. 

## Checking against different inputs
In order to differentiate between a number and a word within the user's input, regular expressions were used.
```java
 if(command.matches("^-?\\d+$")) {
 ```
 Other constraints were added to different methods in order to control user inputs. For example, in the _fingWord_ method. If the index is greated than the number of words, the program will return: _"That index is out of bounds"_. 
 ```java
  if (lines < index) {
            word = "That index is out of bounds";
        }
```

# Part 3 Refactoring
All refactor changes can be found in the _refactor_ branch.
