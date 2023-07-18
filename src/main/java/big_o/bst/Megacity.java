package big_o.bst;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class Megacity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int curPop = sc.nextInt();
        TreeSet<City> treeSet = new TreeSet<>(Comparator.comparingDouble(c -> Math.pow(c.x, 2) + Math.pow(c.y, 2)));
        for (int i = 0; i < total; i++) {
            treeSet.add(new City(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        int minRadius = -1;
        while(curPop < 1000000) {

        }
    }



}
class City {
    int x;
    int y;
    int pop;

    public City(int x, int y, int pop) {
        this.x = x;
        this.y = y;
        this.pop = pop;
    }
}