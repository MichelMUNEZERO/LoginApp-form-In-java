public class MaxSubarrayDivideConquer {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int left = 0, right = arr.length - 1;
        int maxSum = Integer.MIN_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = 0, leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE;

            for (int i = mid; i >= left; i--) {
                sum += arr[i];
                if (sum > leftSum) leftSum = sum;
            }

            sum = 0;
            for (int i = mid + 1; i <= right; i++) {
                sum += arr[i];
                if (sum > rightSum) rightSum = sum;
            }

            int crossSum = leftSum + rightSum;
            int lMax = Integer.MIN_VALUE, rMax = Integer.MIN_VALUE, total = 0;

            for (int i = left; i <= mid; i++) {
                total += arr[i];
                if (total > lMax) lMax = total;
            }

            total = 0;
            for (int i = mid + 1; i <= right; i++) {
                total += arr[i];
                if (total > rMax) rMax = total;
            }

            maxSum = Math.max(Math.max(lMax, rMax), crossSum);
            break;
        }

        System.out.println("Max Subarray Sum: " + maxSum);
    }
}
