package randos;

public class AlternativeSum {

    public int solution(int[] A) {
        long maxSum = 0; // Use long to avoid integer overflow during calculation
        long currentSum = 0;
        int MOD = 1000000000;

        // Calculate the initial sum
        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0) currentSum += A[i]; // even index, add to sum
            else currentSum -= A[i]; // odd index, subtract from sum
        }

        maxSum = currentSum;

        // Iterate through the array to find the maximum sum
        // by considering the effect of removing each element
        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0) currentSum -= 2 * A[i]; // even index, subtract twice
            else currentSum += 2 * A[i]; // odd index, add twice

            // Update maxSum if currentSum is greater
            maxSum = Math.max(maxSum, currentSum);

            // If we've passed an odd index, revert the change
            if (i % 2 == 1) currentSum -= 2 * A[i];
        }

        // Ensure the result is positive and within the range [0, MOD)
        maxSum = ((maxSum % MOD) + MOD) % MOD;

        return (int)maxSum; // cast to int as per the problem statement
    }

    public static void main(String[] args) {
        var solution = new AlternativeSum();

        // Test cases
        int[] A1 = {4, 1, 2, 3};
        int[] A2 = {1, 2, 3, 3, 2, 1, 5};
        int[] A3 = {1000000000, 1, 2, 2, 1000000000, 1, 1000000000};

        System.out.println(solution.solution(A1)); // Expected output: 6
        System.out.println(solution.solution(A2)); // Expected output: 7
        System.out.println(solution.solution(A3)); // Expected output: 999999998
    }
}
