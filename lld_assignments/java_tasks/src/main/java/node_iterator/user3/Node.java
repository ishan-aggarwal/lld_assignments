package node_iterator.user3;

import java.util.Iterator;
import java.util.Scanner;

class Node implements Iterable<Integer> {
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
            Integer value = current.data;
            current = current.next;
            return value;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        Node node = null;
        for (int i = 1; i <= n; i++) {
            int data = scn.nextInt();
            if (node == null) {
                node = new Node(data, null);
            } else {
                node = new Node(data, node);
            }
        }

        for (int temp : node) {
            System.out.println(temp);
        }
    }
}
