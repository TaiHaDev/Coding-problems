package leetcode.sql;

public class EmployeeBonus {
    String res = "SELECT * FROM employee e LEFT JOIN bonus b ON e.empId = b.empId HAVING b.bonus < 1000 OR b.bonus is NULL;";
}
