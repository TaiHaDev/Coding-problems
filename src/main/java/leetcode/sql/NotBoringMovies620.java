package leetcode.sql;

public class NotBoringMovies620 {
    String result = """
            SELECT * FROM Cinema WHERE id % 2 = 1 AND description != "boring" ORDER BY rating DESC;
            """;
}
