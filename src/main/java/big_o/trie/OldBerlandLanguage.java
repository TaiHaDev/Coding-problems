package big_o.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class OldBerlandLanguage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        Trie root = new Trie();
        List<String> words = new ArrayList<>();
        int[] length = new int[total];
        boolean isTrue = true;
        Arrays.sort(length);
        for (int i = 0; i < total; i++) {
            if (!root.addWord(length[i], words)) {
                isTrue = false;
            }
        }
        if (isTrue) {
            System.out.println("YES");
            for (String str : words) {
                System.out.println(str);
            }
        } else {
            System.out.println("NO");
        }

    }
    static class Trie {
        Trie[] children = new Trie[2];
        boolean isEnded = false;

        public boolean addWord(int length, List<String> words) {
            Trie temp = this;
            String res = "";
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < 2; j++) {
                    if (temp.children[j] == null) {
                        temp.children[j] = new Trie();
                        temp = temp.children[j];
                        res += j;
                        break;
                    }
                    if (!temp.children[j].isEnded) {
                        temp=temp.children[j];
                        res += j;
                        break;
                    }
                    if (i == 1) {
                        return false;
                    }
                }
            }
            temp.isEnded = true;
            words.add(res);
            return true;
        }
    }
}

