package leetcode.array;

public class ReverseWordsInAString151 {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder str = new StringBuilder();
        for (int i = words.length - 1; i >= 1; i--) {
            str.append(words[i]).append(" ");
        }
        str.append(words[0]);
        return str.toString();
    }
}
