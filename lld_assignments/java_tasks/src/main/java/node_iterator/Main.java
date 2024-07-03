package node_iterator;

public class Main {
    public static void main(String[] args) {
        // Creating a linked list: 1 -> 2 -> 3
        Node node3 = new Node(3, null);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);

        // Iterating through the linked list and printing each element
        for (int data : node1) {
            System.out.println(data);
        }
    }
}
