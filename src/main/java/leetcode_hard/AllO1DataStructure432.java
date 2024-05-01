package leetcode_hard;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

public class AllO1DataStructure432 {
    Map<String,Payload> countMap = new HashMap<>();
    Map<Integer, Node> countNodeMap = new HashMap<>();
    String curMinKey = "";
    String curMaxKey = "";
    public AllO1DataStructure432() {
    }

    public void inc(String key) {
        Node curNode;
        int count;
        if (countMap.containsKey(key)) {
            Payload curPayload = countMap.get(key);
            curPayload.count++;
            count = curPayload.count;
            curNode = curPayload.node;
        } else {
            curNode = new Node(key);
            count = 1;
            countMap.put(key, new Payload(count, curNode));
        }
        if (!countNodeMap.containsKey(count)) {
            countNodeMap.put(count, curNode);
        } else {
            Node curHead = countNodeMap.get(count);
            curHead.prev = curNode;
            curNode.next = curHead;
            countNodeMap.put(count, curHead);
        }
        if (curMinKey.isEmpty()) {
            curMinKey = curNode.value;;
        } else if (curMinKey.equals(curNode.value) && countNodeMap.) {

        }
    }

    public void dec(String key) {

    }

    public String getMaxKey() {

    }

    public String getMinKey() {

    }
    public class Payload {
        int count;
        Node node;

        public Payload(int count, Node node) {
            this.count = count;
            this.node = node;
        }
    }
    public class Node {
        Node prev;
        Node next;
        String value;

        public Node(String value) {
            this.value = value;
        }
    }
}
