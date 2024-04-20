public class CapacityToShipPackagesWithinDdays {
    public static int noOfDays(int arr[], int mid) {
        int days = 1, load = 0;

        for (int i = 0; i < arr.length; i++) {
            if (load + arr[i] > mid) {
                days = days + 1;
                load = arr[i];
            } else {
                load += arr[i];
            }
        }

        return days;
    }

    public static int leastWeightCapacity(int[] weights, int d) {
        int low = Integer.MIN_VALUE, high = 0;

        for (int i = 0; i < weights.length; i++) {
            high += weights[i];
            low = Math.max(low, weights[i]);
        }

        while (low <= high) {
            int mid = (low + high) / 2;

            if (noOfDays(weights, mid) <= d) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
