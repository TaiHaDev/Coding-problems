package big_o.trie;

import java.util.Scanner;

public class NoPrefixSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        Trie trie = new Trie();
        String result = null;
        for (int i = 0; i < total; i++) {
            String cur = sc.next();
            if (!trie.addNumber(cur)) {
                result = cur;
                break;
            }
        }
        if (result != null) {
            System.out.println("BAD SET");
            System.out.println(result);
        } else {
            System.out.println("GOOD SET");
        }
    }
    static class Trie {
        Node root = new Node();

        public boolean addNumber(String number) {
            Node temp = root;

            boolean isPrefix = false;
            for (int i = 0; i < number.length(); i++) {
                char c = number.charAt(i);
                int index = Character.getNumericValue(c);
                if (temp.child[index] == null) {
                    temp.child[index] = new Node();
                } else {
                    if (temp.child[index].wordCount != 0 || (i == number.length() - 1 && !isEmpty(temp.child[index]))) return false;
                }
                temp = temp.child[index];
            }
            temp.wordCount = 1;
            return true;
        }
        private boolean isEmpty(Node node) {
            for (int i = 0; i < 26; i++) {
                if (node.child[i] != null) return false;
            }
            return true;
        }

    }

    static class Node {
       Node[] child = new Node[26];
        int wordCount = 0;
    }
}
