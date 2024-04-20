public class sqrtOfAnInteger {
    public static int sqrtN(long N) {
        long low = 1, high = N;

        int ans = 1;

        while (low <= high) {
            long mid = (low + high) / 2;
            if ((mid * mid) <= N) {
                ans = (int) mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}
