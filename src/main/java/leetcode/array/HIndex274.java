package leetcode.array;

public class HIndex274 {
    public int hIndex(int[] citations) {
        int[] count = new int[citations.length + 1];
        int h = 0;
        for (int citation : citations) {
            count[Math.min(citation, citations.length)]++;
        }
        for (int i = citations.length; i >= 0; i--) {
            int curH = Math.min(i, count[i] + h);
            h = Math.max(h, curH);
        }
        return h;
    }
}
