package leetcode.array;

public class DesignParkingSystem1603 {
    public static void main(String[] args) {
        System.out.println("annabelle".substring(4));

    }
}
class ParkingSystem {
    int curSmall = 0;
    int curMedium = 0;
    int curBig = 0;
    int big;
    int medium;
    int small;
    public ParkingSystem(int big, int medium, int small) {
        this.small = small;
        this.medium = medium;
        this.big = big;
    }

    public boolean addCar(int carType) {
        if (carType == 1) {
            return curSmall++ < small;
        } else if (carType == 2) {
            return curMedium++ < medium;
        } else {
            return curBig++ < big;
        }
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
