package interview_prep;

import java.util.*;

public class JS {
    public static void main(String[] args) {
        System.out.println(new JS().conversion("2 in = ? m", "m = 3.28 ft\nft = 12 in"));
    }
    public Map<String, Node> parseFacts(String facts) {
        String[] factsList = facts.split("\n");
        Map<String, Node> mapNode = new HashMap<String, Node>();
        for (String fact : factsList) {
            String[] elem = fact.split(" ");
            if (!mapNode.containsKey(elem[0])) {
                mapNode.put(elem[0], new Node(elem[0]));
            }
            if (!mapNode.containsKey(elem[3])) {
                mapNode.put(elem[3], new Node(elem[3]));
            }
            Node startNode = mapNode.get(elem[0]);
            Node endNode = mapNode.get(elem[3]);
            float multiplier = Float.parseFloat(elem[2]);
            startNode.edgeList.add(new Edge(multiplier, endNode));
            endNode.edgeList.add(new Edge(1 / multiplier, startNode));
        }
        return mapNode;
    }
    public double conversion(String query, String facts) {
        Map<String, Node> mapNode = parseFacts(facts);
        String[] queryElems = query.split(" ");
        double startingValue = Double.parseDouble(queryElems[0]);
        String startingUnit = queryElems[1];
        String endingUnit = queryElems[4];

        Node startingNode = mapNode.get(startingUnit);
        Set<Node> visited = new HashSet<>();
        Queue<BFS> queue = new LinkedList<>();
        queue.add(new BFS(startingNode, 1));
        visited.add(startingNode);
        while(!queue.isEmpty()) {
            BFS curBFS = queue.poll();
            if (curBFS.node.unit.equals(endingUnit)) {
                return startingValue * curBFS.multiplier;
            }
            for (Edge nextEdge : curBFS.node.edgeList) {
                if (visited.contains(nextEdge.des)) continue;
                queue.add(new BFS(nextEdge.des, nextEdge.multiplier * curBFS.multiplier));
                visited.add(nextEdge.des);
            }
        }
        return -1;
    }
    public class BFS {
        Node node;
        double multiplier;
        public BFS(Node node, double multiplier) {
            this.node = node;
            this.multiplier = multiplier;
        }
    }





    public class Node {
        public String unit;
        List<Edge> edgeList = new ArrayList<>();
        public Node(String unit) {
            this.unit = unit;
        }
    }
    public class Edge {
        public double multiplier;
        public Node des;
        public Edge(double multiplier, Node des) {
            this.multiplier = multiplier;
            this.des = des;
        }
    }
}
