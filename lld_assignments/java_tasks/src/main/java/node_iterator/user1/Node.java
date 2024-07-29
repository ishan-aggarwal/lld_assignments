package node_iterator.user1;

import java.util.Iterator;

public class Node /*implements Iterable<Node>*/ {
    private int data;
    private Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public int getData() {
        return data;
    }

//    public Iterator<Node> iterator() {
//        return null;
////        return new NodeIterator(this);
//    }
//
//    private class NodeIterator implements Iterator<Node> {
//        private Node head;
//
//        public NodeIterator(Node head) {
//            this.head = head;
//        }
//
//        public boolean hasNext() {
//            return head != null;
//        }
//
//        public Node next() {
//            Node temp = head;
//            head = head.getNext();
//            return temp;
//        }
//    }

    public static void main(String[] args) {

    }
}