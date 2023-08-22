package leetcode.assessment.google;

public class FirstUniqueCharacterInAString387 {
    public int firstUniqChar(String s) {
        int[] rec = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            rec[idx]++;
        }
        for (int i = 0; i < s.length(); i++){
            int idx = s.charAt(i) - 'a';
            if (rec[idx] == 1) return i;
        }
        return -1;
    }
}
