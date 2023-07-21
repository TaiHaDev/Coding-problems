package leetcode.trie;

public class WordDictionary {

    WordDictionary[] child = new WordDictionary[26];
    boolean isEndOfWorld = false;
    public WordDictionary() {

    }

    public void addWord(String word) {
        WordDictionary temp = this;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (temp.child[index] == null) {
                temp.child[index] = new WordDictionary();
            }
            temp = temp.child[index];
        }
        temp.isEndOfWorld = true;
    }

    public boolean search(String word) {
        WordDictionary temp = this;
        char[] charArray = word.toCharArray();
        for (int j = 0; j < charArray.length; j++) {
            char c = charArray[j];
            int index = c - 'a';
            if (c == '.') {
                for (int i = 0; i < 26; i++) {
                    if (temp.child[i] != null && temp.child[i].search(word.substring(j + 1))) return true;
                }
                return false;
            } else {
                if (temp.child[index] == null) return false;
            }
            temp = temp.child[index];
        }
        return temp.isEndOfWorld;
    }




}
