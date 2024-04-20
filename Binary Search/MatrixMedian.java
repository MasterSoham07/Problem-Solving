public class MatrixMedian {

    public static int upperBound(int[] arr, int x, int n){
        int low = 0, high = n - 1;
        int ans = n;

        while(low <= high){
            int mid = (low + high) / 2;

            if(arr[mid] > x){
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }

        return ans;
    }

    public static int countSmallEqual(int[][] matrix, int n, int m, int x){
        int cnt = 0;
        for(int i = 0; i < n; i++){
            cnt += upperBound(matrix[i], x, m);
        }

        return cnt;
    }
    public static int findMedian(int matrix[][], int m, int n) {
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        n = matrix.length;
        m = matrix[0].length;

        for(int  i = 0; i < n; i++){
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][m - 1]);
        }

        int req = (n * m) / 2;

        while(low <= high){
            int mid = (low + high) / 2;
            int smallEqual = countSmallEqual(matrix, n, m, mid);
            if(smallEqual <= req) low = mid + 1;
            else high = mid - 1;
        }

        return low;
    }
}
