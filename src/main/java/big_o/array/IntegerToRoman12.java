package big_o.array;

public class IntegerToRoman12 {
    public String IntToRoman(int num) {
        Pair[] romanians = {of("M", 1000), of("CM", 900), of("D", 500), of("CD", 400), of("C", 100), of("XC", 90), of("L", 50), of("XL", 40), of("X", 10), of("IX", 9), of("V", 5), of("IV", 4), of("I", 1)};
        StringBuilder res = new StringBuilder();
        for (Pair romanian : romanians) {
            while(num >= romanian.value) {
                res.append(romanian.symbol);
                num -= romanian.value;
            }
        }
        return res.toString();
    }
    public static Pair of(String s, int v) {
        return new Pair(s, v);
    }

}
class Pair {
    String symbol;
    int value;

    public Pair(String symbol, int value) {
        this.symbol = symbol;
        this.value = value;
    }
}