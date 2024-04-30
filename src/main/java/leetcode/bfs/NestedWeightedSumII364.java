package leetcode.bfs;

public class NestedWeightedSumII364 {
//    public int depthSumInverse(List<NestedInteger> nestedList) {
//        int treeDepth = 0;
//        Queue<NestedInteger> queue = new LinkedList<>();
//        queue.addAll(nestedList);
//        while(!queue.isEmpty()) {
//            int curSize = queue.size();
//            for (int i = 0; i < curSize; i++) {
//                NestedInteger cur = queue.poll();
//                if (!cur.isInteger()) {
//                    queue.addAll(cur.getList());
//                }
//            }
//            treeDepth++;
//        }
//        queue.addAll(nestedList);
//        int res = 0;
//        while(!queue.isEmpty()) {
//            int curSize = queue.size();
//            for (int i = 0; i < curSize; i++) {
//                NestedInteger cur = queue.poll();
//                if (cur.isInteger()) {
//                    res += cur.getInteger() * treeDepth;
//                } else {
//                    queue.addAll(cur.getList());
//                }
//            }
//            treeDepth--;
//        }
//        return res;
//    }
}
