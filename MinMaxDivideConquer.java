public class MinMaxDivideConquer {
    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 2, 4, 8};
        int min = arr[0], max = arr[0];
        int l = 0, h = arr.length - 1;

        if (l == h) {
            min = max = arr[l];
        } else if (h - l == 1) {
            if (arr[l] < arr[h]) {
                min = arr[l];
                max = arr[h];
            } else {
                min = arr[h];
                max = arr[l];
            }
        } else {
            while (l <= h) {
                int m = (l + h) / 2;
                if (arr[m] < min) min = arr[m];
                if (arr[m] > max) max = arr[m];
                if (m - 1 >= 0 && arr[m - 1] < min) min = arr[m - 1];
                if (m + 1 < arr.length && arr[m + 1] > max) max = arr[m + 1];
                l = m + 1;
            }
        }

        System.out.println("Min: " + min + ", Max: " + max);
    }
}
