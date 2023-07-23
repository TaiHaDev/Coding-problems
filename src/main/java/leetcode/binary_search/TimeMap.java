package leetcode.binary_search;

import java.util.*;

public class TimeMap {

    Map<String, List<Value>> map = new HashMap<>();

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, e -> new ArrayList<>());
        map.get(key).add(new Value(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<Value> li = map.get(key);
        int index = Collections.binarySearch(li, new Value(null, timestamp), (o1, o2) -> Integer.compare(o1.timestamp, o2.timestamp));
        if (index >= 0) {
            return li.get(index).value;
        } else {
            index = -index - 2;
            if (index >= 0) {
                return li.get(index).value;
            }
            return "";
        }

    }

}
class Value {
    String value;
    int timestamp;

    public Value(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}