package big_o.trie;

import java.util.Scanner;

public class Contacts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        String cur;
        Trie trie = new Trie();
        sc.nextLine();
        while (total-- > 0) {
            if ((cur = sc.nextLine()).startsWith("add")) {
                trie.addContact(cur.split(" ")[1]);
            } else {
                System.out.println(trie.findPartial(cur.split(" ")[1]));
            }
        }
    }
    static class Trie {
        Node root = new Node();

        public void addContact(String s) {
            Node temp = root;
            for (char c : s.toCharArray()) {
                int index = c - 'a';
                if (temp.child[index] == null) {
                    temp.child[index] = new Node();
                }
                temp = temp.child[index];
                temp.childCount++;
            }
        }


        public int findPartial(String s) {
            Node temp = root;
            for (char c : s.toCharArray()) {
                int index = c - 'a';
                if (temp.child[index] == null) return 0;
                temp = temp.child[index];
            }
            return temp.childCount;
        }
    }
    static class Node {
        Node[] child = new Node[26];
        int childCount = 0;
    }
}
