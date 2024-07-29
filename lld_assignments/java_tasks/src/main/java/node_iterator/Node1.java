package node_iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Node1 implements Iterable<Node1> {

    public int data;

    public Node1 next;

    public Node1(int data, Node1 next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public Iterator<Node1> iterator() {
//        return null;
        return new ABCIterator(this);
    }

    @Override
    public String toString() {
        return "Node1{" +
                "data=" + data +
                '}';
    }

    class ABCIterator implements Iterator<Node1> {
        private Node1 current;
        public ABCIterator(Node1 node1) {
            this.current = node1;
        }

        @Override
        public boolean hasNext() {
            return this.current != null;
        }

        @Override
        public Node1 next() {
            Node1 temp = current;
            current = current.next;
            return temp;
        }
    }
}
