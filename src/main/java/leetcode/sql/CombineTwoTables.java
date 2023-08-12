package leetcode.sql;

public class CombineTwoTables {
    String result = """
            SELECT firstName, lastName, city, state FROM person LEFT JOIN address on person.personId = address.personId;
            """;
}
