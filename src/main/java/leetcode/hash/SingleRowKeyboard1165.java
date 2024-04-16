package leetcode.hash;

public class SingleRowKeyboard1165 {
    public int calculateTime(String keyboard, String word) {
        int[] map = new int[26];
        for (int i = 0; i < keyboard.length(); i++) {
            int index = keyboard.charAt(i) - 'a';
            map[index] = i;
        }
        int lastIndex = 0;
        int totalMoving = 0;
        for (char c : word.toCharArray()) {
            int index = map[c-'a'];
            totalMoving += Math.abs(index - lastIndex);
            lastIndex = index;
        }
        return totalMoving;
    }
}
