package big_o.array;

public class FlippingImage {
    public int[][] flipAndInvertImage(int[][] image) {
        for (int row = 0; row < image.length; row++) {
            for (int col = 0; col < (image[0].length + 1) / 2; col++) {
                int temp = image[row][col];
                int oppositeCol = image[0].length - 1 - col;
                image[row][col] = image[row][oppositeCol] == 0 ? 1 : 0;
                image[row][oppositeCol] = temp == 0 ? 1 : 0;
            }
        }
        return image;
    }
}
