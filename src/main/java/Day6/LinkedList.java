package Day6;


import java.util.ArrayList;
import java.util.List;

class LinkedList {

    static class Node {
        String data;
        List<Node> list = new ArrayList<>();

        Node(String d) {
            data = d;
        }

    }
}