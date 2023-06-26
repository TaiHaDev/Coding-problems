package leetcode.array;

import java.util.*;

public class PascalTriangle118 {
    public static void main(String[] args) {
        System.out.println(new PascalTriangle118().generate(5));
        System.out.println(new PascalTriangle118().numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}));
        System.out.println(new PascalTriangle118().hammingWeight(1011));
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList();
        result.add(List.of(1));
        int count = 1;
        while (count != numRows) {
            List<Integer> last = result.get(result.size() - 1);
            List<Integer> cur = new ArrayList();
            cur.add(1);
            for (int i = 1; i <= count - 1; i++) {
                cur.add(last.get(i -1 ) + last.get(i));
            }
            cur.add(1);
            result.add(cur);
            count++;
        }
        return result;
    }



    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet();
        for (String str : emails) {
            String[] split = str.split("@");
            String local = split[0];
            int plusIndex;
            if ((plusIndex = local.indexOf("+")) != -1) {
                local = local.substring(0, plusIndex);
            }
            local = local.replace(".", "");
            set.add(local + "@" + split[1]);
        }
        return set.size();
    }
    public int hammingWeight(int n) {
        String str = Integer.toString(n);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') count++;
        }
        return count;
    }
}
