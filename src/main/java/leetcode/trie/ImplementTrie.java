package leetcode.trie;

public class ImplementTrie {
}
class Trie {
    Node root = new Node();
    public Trie() {

    }

    public void insert(String word) {
        Node temp = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (temp.child[index] == null) {
                temp.child[index] = new Node();
            }
            temp = temp.child[index];
        }
        temp.isEnded = true;
    }

    public boolean search(String word) {
        Node temp = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (temp.child[index] == null) return false;
            temp = temp.child[index];
        }
        return temp.isEnded == true;
    }

    public boolean startsWith(String prefix) {
        Node temp = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (temp.child[index] == null) return false;
            temp = temp.child[index];
        }
        return true;
    }
}

class Node {
    Node[] child = new Node[26];
    boolean isEnded = false;;
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
