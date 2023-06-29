package coding_assessment.citadel;

import java.io.*;

public class DoTheyBelongGeometry {
}



class Result {

    /*
     * Complete the 'pointsBelong' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER x1
     *  2. INTEGER y1
     *  3. INTEGER x2
     *  4. INTEGER y2
     *  5. INTEGER x3
     *  6. INTEGER y3
     *  7. INTEGER xp
     *  8. INTEGER yp
     *  9. INTEGER xq
     *  10. INTEGER yq
     */

    public static int pointsBelong(int x1, int y1, int x2, int y2, int x3, int y3, int xp, int yp, int xq, int yq) {
        double ab = lengthTwoPoints(x1, y1, x2, y2);
        double bc = lengthTwoPoints(x1, y1, x3, y3);
        double cd = lengthTwoPoints(x3, y3, x2, y2);
        if (ab + bc <= cd || ab + cd <= bc || bc + cd <= ab) return 0;
        double wholeArea = area(x1, y1, x2, y2, x3, y3);
        // calculate area of 3 triangles form by p
        double areaP1 = area(x1,y1,x2,y2, xp, yp);
        double areaP2 = area(x1, y1, xp, yp, x3, y3);
        double areaP3 = area(xp, yp, x2, y2, x3, y3);
        // calculate area of 3 triangles form by q
        double areaQ1 = area(x1,y1,x2,y2, xq, yq);
        double areaQ2 = area(x1, y1, xq, yq, x3, y3);
        double areaQ3 = area(xq, yq, x2, y2, x3, y3);

        boolean isPInside = wholeArea == (areaP1 + areaP2 + areaP3);
        boolean isQInside = wholeArea == (areaQ1 + areaQ2 + areaQ3);
        if (isPInside && isQInside) {
            return 3;
        } else if (isPInside) {
            return 1;
        } else if (isQInside) {
            return 2;
        } else {
            return 4;
        }

    }
    public static double lengthTwoPoints(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
    public static double area(int x1, int y1, int x2, int y2,
                              int x3, int y3)
    {
        return Math.abs((x1*(y2-y3) + x2*(y3-y1)+
                x3*(y1-y2))/2.0);
    }

}
class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int x1 = Integer.parseInt(bufferedReader.readLine().trim());

        int y1 = Integer.parseInt(bufferedReader.readLine().trim());

        int x2 = Integer.parseInt(bufferedReader.readLine().trim());

        int y2 = Integer.parseInt(bufferedReader.readLine().trim());

        int x3 = Integer.parseInt(bufferedReader.readLine().trim());

        int y3 = Integer.parseInt(bufferedReader.readLine().trim());

        int xp = Integer.parseInt(bufferedReader.readLine().trim());

        int yp = Integer.parseInt(bufferedReader.readLine().trim());

        int xq = Integer.parseInt(bufferedReader.readLine().trim());

        int yq = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.pointsBelong(x1, y1, x2, y2, x3, y3, xp, yp, xq, yq);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
