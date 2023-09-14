package big_o.divide_and_concur;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ClosestPoint {

    public class Main {
        static final double INF = 1E9;

        static class Point {
            double x = 0, y = 0;

            public Point(double x, double y) {
                this.x = x;
                this.y = y;
            }
        }

        static double distance(Point p1, Point p2) {
            double x = p1.x - p2.x;
            double y = p1.y - p2.y;
            return Math.sqrt(x * x + y * y);
        }

        static double bruteForce(ArrayList<Point> point_set, int left, int right) {
            double min_dist = INF;
            for (int i = left; i < right; ++i) {
                for (int j = i + 1; j < right; ++j) {
                    min_dist = Math.min(min_dist, distance(point_set.get(i), point_set.get(j)));
                }
            }
            return min_dist;
        }

        static double stripClosest(ArrayList<Point> point_set, int left, int right, int mid, double dist_min) {
            Point point_mid = point_set.get(mid);
            ArrayList<Point> splitted_points = new ArrayList<>();
            for (int i = left; i < right; i++) {
                if (Math.abs(point_set.get(i).x - point_mid.x) <= dist_min) {
                    splitted_points.add(point_set.get(i));
                }
            }

            Collections.sort(splitted_points, (o1, o2) -> Double.compare(o1.y, o2.y));

            double smallest = INF;
            int l = splitted_points.size();
            for (int i = 0; i < l; i++) {
                for (int j = i + 1; j < l && (splitted_points.get(j).y - splitted_points.get(i).y) < dist_min; j++) {
                    double d = distance(splitted_points.get(i), splitted_points.get(j));
                    smallest = Math.min(smallest, d);
                }
            }
            return smallest;
        }

        static double closestUtil(ArrayList<Point> point_set, int left, int right) {
            if (right - left <= 3)
                return bruteForce(point_set, left, right);

            int mid = (right + left) / 2;
            double dist_left = closestUtil(point_set, left, mid);
            double dist_right = closestUtil(point_set, mid + 1, right);
            double dist_min = Math.min(dist_left, dist_right);

            return Math.min(dist_min, stripClosest(point_set, left, right, mid, dist_min));
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n;
            double x, y;
            while (true) {
                n = sc.nextInt();
                if (n == 0)
                    break;
                ArrayList<Point> point_set = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    x = sc.nextDouble();
                    y = sc.nextDouble();
                    point_set.add(new Point(x, y));
                }

                Collections.sort(point_set, ((o1, o2) -> Double.compare(o1.x, o2.x)));
                double ans = closestUtil(point_set, 0, n);
                if (ans <= 10000)
                    System.out.format("%.4f\n", ans);
                else
                    System.out.println("INFINITY");
            }

            sc.close();
        }
    }
}
