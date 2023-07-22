package leetcode.trie;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII212 {


    public List<String> findWords(char[][] board, String[] words) {
        int r = board.length;
        int c = board[0].length;
        List<String> result = new ArrayList<>();
        Trie trie = new Trie();
        for (String word : words) {
            trie.addWord(word);
        }
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                dfs(board, trie, row, col, new boolean[r][c], result, "");
            }
        }
        return result;
    }

    private void dfs(char[][] board, Trie node, int r, int c, boolean[][] visited, List<String> result, String str) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || visited[r][c] || node.children[board[r][c] - 'a'] == null) {
            return;
        }
        node = node.children[board[r][c] - 'a'];
        str += board[r][c];
        if (node.isEndOfWord) {
            result.add(str);
            node.isEndOfWord = false;
        }
        visited[r][c] = true;
        dfs(board, node, r - 1, c, visited, result, str);
        dfs(board, node, r + 1, c, visited, result, str);
        dfs(board, node, r, c - 1, visited, result, str);
        dfs(board, node, r, c + 1, visited, result, str);
        visited[r][c] = false;
    }

    class NextWord {
        Trie trie;
        int r;
        int c;
        String cur = "";

        public NextWord(Trie trie, int r, int c, String cur) {
            this.trie = trie;
            this.r = r;
            this.c = c;
            this.cur = cur;
        }
    }

    static class Trie {
        Trie[] children = new Trie[26];
        boolean isEndOfWord = false;
        public void addWord(String word) {
            Trie temp = this;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (temp.children[index] == null) {
                    temp.children[index] = new Trie();
                }
                temp = temp.children[index];
            }
            temp.isEndOfWord = true;
        }
    }
}
