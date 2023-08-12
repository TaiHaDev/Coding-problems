package leetcode.sql;

public class DepartmentTopThreeSalaries185 {
    String result = """
            SELECT d.name as Department, e.name as Employee, e.salary as Salary\s
            FROM employee as e
            INNER JOIN department as d
            ON e.departmentId = d.id
            WHERE (
              SELECT COUNT(DISTINCT(salary))
              FROM Employee
              WHERE e.salary < salary AND departmentId = e.departmentId
            ) < 3;
            """;
}
