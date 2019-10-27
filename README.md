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

### LinkedList.java 
This class handles the creation of nodes and adds them alphabetically through _addAlphabetically_ method. 
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
#### 3 minutes to complete. 
