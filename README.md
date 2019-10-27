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
