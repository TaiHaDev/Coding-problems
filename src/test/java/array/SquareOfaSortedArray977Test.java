package array;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * <h1>abc</h1>
 */
public class SquareOfaSortedArray977Test {
    public static void main(String[] args) {
        System.out.println(Double.NaN );
    }

    @org.junit.Before
    public void setUp() throws Exception {
        System.out.println("set up");
    }

    @Test(expected = ArithmeticException.class)
    public void exceptionTesting() {
        long sum = 0 ;
        for(int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        int a = 1/ 0 ;
    }

    @org.junit.After
    public void tearDown() throws Exception {
        System.out.println("tear down");
    }
}