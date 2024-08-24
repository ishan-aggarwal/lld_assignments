package com.example.lld1classes.generics_doubts;

import java.util.ArrayList;
import java.util.List;

public class Test {


    public static void main(String[] args) {

        Node end = new Node(3, null);
        Node middle = new Node(2, end);
        Node head = new Node(1, middle);

        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }



        // head(1) -> middle(2)  ->  end(3)
        for (Node node : head) {
            System.out.println(node.data);
        }


        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        for (int num : list) {
            System.out.println(num);
        }


    }
}
