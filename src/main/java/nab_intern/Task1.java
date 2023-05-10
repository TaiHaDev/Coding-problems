package nab_intern;

public class Task1 {
    /**
     * No 3 identical consecutive letter
     */
    public static void main(String[] args) {
        String s = "baaabbaabbba";
        System.out.println(solution(s));
    }

    public static int solution(String input) {
        int result = 0;
        int consecutiveCount = 1;
        String lastChar = input.substring(0, 1);
        for (int i = 1; i < input.length(); i++) {
            String currentChar = input.substring(i, i+1);
            if (currentChar.equals(lastChar)) {
                consecutiveCount++;
            } else {
                consecutiveCount = 1;
                lastChar = currentChar;
            }
            if (consecutiveCount == 3) {
                result += consecutiveCount / 3;
                consecutiveCount = 0;
            }
        }
        return result;
    }
}
