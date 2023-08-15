package leetcode.sql;

public class ConsecutiveNumbers180 {
    String result = "SELECT Distinct l.num as ConsecutiveNums FROM Logs as l WHERE (SELECT num FROM Logs WHERE l.id + 1 = id) = num AND (SELECT num FROM Logs WHERE l.id + 2= id ) = num;";
}
