package leetcode.array;



import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    Map<Integer, Checkin> checkinMap;
    Map<String, Pair> travellingTimeMap;
    public UndergroundSystem() {
        checkinMap = new HashMap<>();
        travellingTimeMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkinMap.put(id, new Checkin(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Checkin curCheckin = checkinMap.get(id);
        String map = curCheckin.stationName + "-" + stationName;
        Pair curPair = travellingTimeMap.getOrDefault(map, Pair.of(0.0, 0));
        travellingTimeMap.put(map, Pair.of(curPair.first() + (t - curCheckin.time), curPair.second() + 1));
        checkinMap.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        var cur =travellingTimeMap.get(startStation + "-" + endStation);
        return cur.first() / cur.second();
    }
}
class Checkin {
    String stationName;
    int time;

    public Checkin(String stationName, int time) {
        this.stationName = stationName;
        this.time = time;
    }
}
class Pair {
    Double first;
    Integer second;

    public static Pair of(Double first, Integer second) {
        Pair cur = new Pair();
        cur.first = first;
        cur.second = second;
        return cur;
    }
    public Double first() {
        return first;
    }
    public Integer second() {
        return second;
    }
}
/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
