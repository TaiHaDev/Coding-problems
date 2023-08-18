package leetcode.sql;

public class RisingTemperature197 {
    String result = "SELECT w1.id \n" +
            "FROM Weather w1\n" +
            "INNER JOIN Weather w2 \n" +
            "ON DATEDIFF(w1.recordDate, w2.recordDate) = 1 AND w1.temperature > w2.temperature;";
}
