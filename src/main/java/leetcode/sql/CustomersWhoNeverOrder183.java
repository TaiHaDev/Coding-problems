package leetcode.sql;

public class CustomersWhoNeverOrder183 {
    String result = "SELECT c.name as Customers FROM Customers c LEFT JOIN Orders o\n" +
            "ON c.id = o.customerId where o.id is NULL;";
}
