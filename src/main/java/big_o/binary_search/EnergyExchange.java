package big_o.binary_search;

import java.util.Scanner;

public class EnergyExchange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int k = sc.nextInt();
        int[] energy = new int[total];
        for (int i = 0; i < total; i++) {
            energy[i] = sc.nextInt();
        }
        double upper = 0, lower = 0;
        for (int e : energy) {
            upper = Math.max(e , upper);
            lower = Math.min(e, lower);
        }
        while (Math.abs(upper - lower) > 1e-7) {
            double middle = (upper + lower) / 2;
            double diff = checkEnergyTransfer(middle, energy, k);
            if (diff > 0) {
                lower = middle;
            } else if (diff < 0) {
                upper = middle;
            } else {
                lower = middle;
                break;
            }
        }
        System.out.printf("%.8f\n",lower);
    }

    private static double checkEnergyTransfer(double target, int[] energy, int k) {
        double cur = 0;
        for (int e : energy) {
            if (e > target) {
                cur += (e-target) * (100-k) / 100;
            } else if (e < target) {
                cur -= (target - e);
            }
        }
        return cur;
    }
}
