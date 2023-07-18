package big_o.array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall554 {

    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (List<Integer> col : wall) {
            int edge = 0;
            for (int i = 0; i < col.size() - 1; i++) {
                edge += col.get(i);
                map.put(edge, map.getOrDefault(edge, 0) + 1);
                max = Math.max(map.get(edge), max);
            }
        }
        return wall.size() - max;
    }
}
