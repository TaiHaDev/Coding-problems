package leetcode.sql;

public class SecondHighestSalary176 {
    String res = "SELECT DISTINCT salary as SecondHighestSalary FROM Employee ORDER BY salary DESC LIMIT 1 OFFSET 1;";
}
