package leetcode.bit_manipulation;

public class ReverseBits {
    public int reverseBits(int n) {
        int answer = 0;

        for (int i = 0; i < 32; i++) {
            int lastDigit = n & 1;
            int shift = lastDigit << (31 - i);
            answer = answer | shift;
            n = n >> 1;
        }
        return answer;
    }
}
