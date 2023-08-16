package big_o.blue_final;

import java.util.Scanner;

public class PhoneList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        while (total-- > 0) {
            int amount = sc.nextInt();
            Trie phoneTrie = new Trie();
            boolean isInvalid = false;
            for (int i = 0; i < amount; i++) {
                if (!phoneTrie.addWord(sc.next())) {
                    isInvalid = true;
                }
            }
            if (isInvalid) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
    public static class Trie {
        Trie[] children = new Trie[10];
        boolean isEndOfWord = false;
        public boolean addWord(String phoneNumber) {
            Trie cur = this;
            for (char c : phoneNumber.toCharArray()) {
                int index = Character.getNumericValue(c);
                if (cur.children[index] == null) {
                    cur.children[index] = new Trie();
                } else if (cur.children[index].isEndOfWord) {
                    return false;
                }
                cur = cur.children[index];
            }
            cur.isEndOfWord = true;
            for (Trie trie : cur.children) {
                if (trie != null) {
                    return false;
                }
            }
            return true;
        }
    }
}
