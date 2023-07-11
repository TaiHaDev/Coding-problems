package leetcode.array;

public class DesignParkingSystem1603 {
    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
        parkingSystem.addCar(1); // return true because there is 1 available slot for a big car
        parkingSystem.addCar(2); // return true because there is 1 available slot for a medium car
        parkingSystem.addCar(3); // return false because there is no available slot for a small car
        parkingSystem.addCar(1); // return false because there is no available slot for a big car. It is already occupied.
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
