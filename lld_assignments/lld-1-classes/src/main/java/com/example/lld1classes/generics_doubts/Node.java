package com.example.lld1classes.generics_doubts;

import java.util.Iterator;

public class Node implements Iterable<Node> {

    public int data;
    public Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Iterator<Node> iterator() {
        return new IshanIterator(this);
    }

    static class IshanIterator implements Iterator<Node> {
        private Node head;

        public IshanIterator(Node node) {
            this.head = node;
        }

        @Override
        public boolean hasNext() {
            return this.head != null;
        }

        @Override
        public Node next() {
            Node previous = this.head;
            this.head = head.next;
            return previous;
        }
    }
}