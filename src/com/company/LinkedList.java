package com.company;

import jdk.nashorn.internal.ir.WhileNode;

public class LinkedList<E> {
    Node head;


    public void append(E word) {
        if (head == null) {
            head = new Node(word);
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(word);
    }

    public void prepend(E word) {
        Node newHead = new Node(word);
        newHead.next = head;
        head = newHead;
    }

    public void addAlphabetically(E word) {
        if (head==null) {
            append(word);
        } else if (head.next == null) {
            if (head.word.toString().compareToIgnoreCase((String) word) < 0 ) {
                append(word);
            } else {
                prepend(word);
            }

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

    }

    public void show()
    {
        Node node = head;

        while(node.next!=null)
        {
            System.out.println(node.word);
            node = node.next;
        }
        System.out.println(node.word);
    }

}

//https://www.youtube.com/watch?v=njTh_OwMljA&t=219s