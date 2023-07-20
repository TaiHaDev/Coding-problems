package big_o.trie;

import java.util.Scanner;

public class SearchEngine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int entries = sc.nextInt();
        int queries = sc.nextInt();
        Trie trie = new Trie();
        for (int i = 0; i < entries; i++) {
            trie.addWord(sc.next(), sc.nextInt());
        }
        for (int i = 0; i < queries; i++) {
            System.out.println(trie.findBestMatch(sc.next()));
        }
    }
}


class Trie {
    Node root;

    public Trie() {
        this.root = new Node();
    }
    public void addWord(String word, int weight) {
        Node temp = root;
        for (char c : word.toCharArray()) {
            temp.maxValue = Math.max(temp.maxValue, weight);
            int index = c - 'a';
            if (temp.child[index] == null) {
                temp.child[index] = new Node();
            }
            temp = temp.child[index];
        }
        temp.maxValue = Math.max(temp.maxValue, weight);
    }
    public int findBestMatch(String word) {
        Node temp = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (temp.child[index] == null) {
                return -1;
            }
            temp = temp.child[index];
        }
        return temp.maxValue;
    }




}

class Node {

    Node[] child = new Node[26];
    int maxValue = 0;



}