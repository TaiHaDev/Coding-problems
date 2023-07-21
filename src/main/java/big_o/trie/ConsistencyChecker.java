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
            for (long i = 0; i < total; i++) {
                trie.addNumber(sc.next());
            }
            String cStr = "Case " + c++ + ": ";
            if (!trie.isPrefix(trie.root)) {
                System.out.println(cStr + "YES");
            } else {
                System.out.println(cStr + "NO");
            }
        }
    }

    static class Trie {
        Node root = new Node();

//        public boolean addNumber(String number) {
//            Node temp = root;
//            char[] charArray = number.toCharArray();
//            for (int i = 0; i < charArray.length; i++) {
//                char digit = charArray[i];
//                int cur = Character.getNumericValue(digit);
//                if (temp.child[cur] != null) {
//                    if ((i == charArray.length - 1 && !isEmpty(temp.child[cur]) || temp.child[cur].wordCount == 1) return false;
//                } else {
//                    temp.child[cur] = new Node();
//                }
//                temp = temp.child[cur];
//            }
//            temp.wordCount = 1;
//            return true;
//        }
        public boolean isEmpty(Node node) {
            for (int i = 0; i < 10; i++) {
                if (node.child[i] != null) return false;
            }
            return true;
        }

        public void addNumber(String number) {
            Node temp = root;
            for (char c : number.toCharArray()) {
                int index = Character.getNumericValue(c);
                if (temp.child[index] == null) {
                    temp.child[index] = new Node();
                }
                temp = temp.child[index];
            }
            temp.wordCount = 1;
        }
        public boolean isPrefix(Node node) {
            for (int i = 0; i < 10; i++) {
                if (node.child[i] != null) {
                    if (node.wordCount != 0) return true;
                    if (isPrefix(node.child[i])) return true;
                }
            }
            return false;
        }
    }

    static class Node {
        Node[] child = new Node[10];
        int wordCount = 0;
    }
}
