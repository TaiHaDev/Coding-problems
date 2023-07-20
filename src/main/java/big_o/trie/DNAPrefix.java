package big_o.trie;

import java.util.Scanner;

public class DNAPrefix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = 1;
        while (n-- > 0) {
            int total = sc.nextInt();
            Trie trie = new DNAPrefix.Trie();
            for (int i = 0; i < total; i++) {
                trie.addDNA(sc.next());
            }
            System.out.println("Case " + c++ + ": " + trie.max);
        }
    }
    static class Trie {
        Node root = new Node();
        int max;

        public void addDNA(String dna) {
            Node temp = root;
            int len = 0;
            for (char c : dna.toCharArray()) {
                int index;
                if (c == 'A') index = 0;
                else if (c == 'C') index = 1;
                else if (c == 'G') index = 2;
                else index = 3;
                if (temp.child[index] == null) {
                    temp.child[index] = new Node();
                }
                temp = temp.child[index];
                len++;
                temp.totalChildCount++;
                max = Math.max(temp.totalChildCount * len, max);
            }
        }


    }
    static class Node {
        Node[] child = new Node[4];
        int totalChildCount = 0;
    }
}



