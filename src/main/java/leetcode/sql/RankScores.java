package leetcode.sql;

public class RankScores {
    String result = """
            SELECT score, DENSE_RANK() OVER(ORDER BY score DESC)\s
            FROM scores;""";
}
