package big_o.trie;

import java.util.Scanner;

public class VulnerablePassword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        Trie trie = new Trie();
        boolean isVulnerable = false;
        for (int i = 0; i < total; i++) {
            String cur = sc.next();
            if (!trie.addWord(cur)) {
                isVulnerable = true;
                break;
            }
        }
        if (isVulnerable) {
            System.out.println("vulnerable");
        } else {
            System.out.println("non vulnerable");
        }
    }
    static class Trie {
        Node root = new Node();

        public boolean addWord(String number) {
            Node temp = root;

            boolean isPrefix = false;
            for (int i = 0; i < number.length(); i++) {
                char c = number.charAt(i);
                int index = c - 'a';
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
