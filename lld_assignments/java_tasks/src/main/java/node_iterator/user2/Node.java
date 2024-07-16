package node_iterator.user2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Node {
    private int data;
    private Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Iterator<Node> iterator() {
        return new NodeIterator(this);
    }

    private static class NodeIterator implements Iterator<Node> {
        private Node current;

        public NodeIterator(Node start) {
            this.current = start;
        }

        public boolean hasNext() {
            return current != null;
        }

        public Node next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Node temp = current;
            current = current.next;
            return temp;
        }
    }
}    