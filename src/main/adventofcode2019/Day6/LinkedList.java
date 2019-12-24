package adventofcode2019.Day6;


class LinkedList {

    Node head;
    static class Node {
        String data;
        Node next;

        Node(String d) {
            data = d;
            next = null;
        }

    }
}