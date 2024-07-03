package node_iterator;

import java.util.Iterator;

public class Node implements Iterable<Integer> {
    private int data;
    private Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new NodeIterator(this);
    }

    static class NodeIterator implements Iterator<Integer> {
        Node current;

        NodeIterator(Node root) {
            this.current = root;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Integer next() {
            Integer tempData = current.data;
            current = current.next;
            return tempData;
        }
    }
}
