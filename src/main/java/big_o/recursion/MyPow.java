package big_o.recursion;

public class MyPow {
    public double myPow(double x, long n) {
        if (n == 0) return 1;
        if (n < 0) return 1/myPow(x,-n);
        if (n % 2 ==0) {
            return myPow(x * x, n / 2);
        } else {
            return x * myPow(x, n - 1);
        }
    }
}
