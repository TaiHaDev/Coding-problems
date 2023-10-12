package Coding_assessment.canva;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LRUCache().getLatestKRequests(new String[]{"1", "2", "3", "2", "3"}, 5)));
    }
    public String[] getLatestKRequests(String[] input, int k) {
        Map<String, Node> nodeMap = new HashMap<>();
        int resLen = 0;
        Node dummyNode = new Node("");
        Node last = dummyNode;
        for (String str : input) {
            if (!nodeMap.containsKey(str)) {
                Node curNode = new Node(str);
                last.next = curNode;
                curNode.prev = last;
                nodeMap.put(str, curNode);
                resLen++;
                last = last.next;
            } else {
                Node curNode = nodeMap.get(str);
                // removing current node from linkedlist by connecting prev and next
                curNode.prev.next = curNode.next;
                if (curNode.next != null) {
                    curNode.next.prev = curNode.prev;
                }
                // adding current node to the start of the linked list
                dummyNode.next.prev = curNode;
                curNode.next = dummyNode.next;
                dummyNode.next = curNode;
                curNode.prev = dummyNode;
            }
        }
        String[] res = new String[resLen];
        for (int i = 0; i < res.length; i++) {
            res[i] = dummyNode.next.val;
            dummyNode = dummyNode.next;
        }
        return res;
    }
    class Node {
        String val;
        Node next;
        Node prev;

        public Node(String val) {
            this.val = val;
        }
    }
}
