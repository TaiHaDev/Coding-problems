package big_o.trie;

import java.util.Scanner;

public class ConsistencyChecker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = 1;
        while (n-- > 0) {
            long total = sc.nextLong();
            Trie trie = new Trie();
            boolean isConsistent = true;
            for (long i = 0; i < total; i++) {
                if (!trie.addNumber(sc.next())) {
                    isConsistent = false;
                    break;
                }
            }
            String cStr = "Case " + c++ + ": ";
            if (isConsistent) {
                System.out.println(cStr + "YES");
            } else {
                System.out.println(cStr + "NO");
            }
        }
    }

    static class Trie {
        Node root = new Node();

        public boolean addNumber(String number) {
            Node temp = root;
            char[] charArray = number.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                char digit = charArray[i];
                int cur = Character.getNumericValue(digit);
                if (temp.child[cur] != null) {
                    if (i == charArray.length - 1 || temp.child[cur].wordCount == 1) return false;
                } else {
                    temp.child[cur] = new Node();
                }
                temp = temp.child[cur];
            }
            temp.wordCount = 1;
            return true;
        }
    }

    static class Node {
        Node[] child = new Node[10];
        int wordCount = 0;
    }
}
