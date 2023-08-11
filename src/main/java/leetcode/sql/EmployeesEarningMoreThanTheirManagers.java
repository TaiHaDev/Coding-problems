package leetcode.sql;

public class EmployeesEarningMoreThanTheirManagers {
    String result = "    SELECT e.name as Employee FROM\n" +
            "    employee e INNER JOIN employee m\n" +
            "    ON e.managerId = m.id\n" +
            "    WHERE e.salary > m.salary;";
}
