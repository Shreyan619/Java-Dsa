// 1423. Maximum Points You Can Obtain from Cards

public class lc1423 {

    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        // Compute the sum of the first k elements (left window)
        int leftSum = 0;
        for (int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
        }
        // Start with maxSum as the total leftSum
        int maxSum = leftSum;
        // Use right pointer to replace elements from the right side
        int rightSum = 0;
        for (int i = 0; i < k; i++) {
            rightSum += cardPoints[n - 1 - i];   // Add element from right
            leftSum -= cardPoints[k - 1 - i];    // Remove last element from left
            maxSum = Math.max(maxSum, leftSum + rightSum);
        }

        return maxSum;
    }
}
