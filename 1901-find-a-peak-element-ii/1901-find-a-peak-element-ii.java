class Solution {
    public static int findMaxRow(int[][] mat, int n, int m, int col){
        int maxValue = -1;
        int index = -1;

        for(int i = 0; i < n; i++){
            if(mat[i][col] > maxValue){
                maxValue = mat[i][col];
                index = i;
            }
        }

        return index;
    }
    public static int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        int low = 0, high = m - 1;

        while(low <= high){
            int mid = (low + high) / 2;
            int maxRow = findMaxRow(mat, n, m, mid);
            int left = mid - 1 >= 0 ? mat[maxRow][mid - 1] : -1;
            int right = mid + 1 < m ? mat[maxRow][mid + 1] : -1;

            if(mat[maxRow][mid] > left && mat[maxRow][mid] > right) return new int[] {maxRow, mid};
            else if (mat[maxRow][mid] < left) high = mid - 1;
            else low = mid + 1;
        }

        return new int[] {-1,-1};
    }
}