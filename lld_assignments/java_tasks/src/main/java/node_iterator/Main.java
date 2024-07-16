package node_iterator;

public class Main {
    public static void main(String[] args) {
        // Creating a linked list: 1 -> 2 -> 3
//        Node node3 = new Node(3, null);
//        Node node2 = new Node(2, node3);
//        Node node1 = new Node(1, node2);
//
//        // Iterating through the linked list and printing each element
//        for (int data : node1) {
//            System.out.println(data);
//        }


        Node1 node3 = new Node1(3, null);
        Node1 node2 = new Node1(2, node3);
        Node1 node1 = new Node1(1, node2);

        // Iterating through the linked list and printing each element
        for (Node1 tempNode : node1) {
            System.out.println(tempNode);
        }
    }
}
