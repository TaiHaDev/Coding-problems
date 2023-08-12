package leetcode.sql;

public class DuplicateEmail {
    String result = """
           SELECT email FROM Person GROUP BY email HAVING COUNT(email) > 1; 
           """;
}
