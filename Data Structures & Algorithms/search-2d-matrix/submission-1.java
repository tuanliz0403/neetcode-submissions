class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int lm = 0, rm = matrix.length - 1;
        int m = matrix.length;
        if(m <= 0) return false;
        int n = matrix[0].length;
        while(lm <= rm)
        {
            int mid = lm + (rm - lm) / 2;
            if(target < matrix[mid][0]){
                rm = mid - 1;
            }   
            else if(target > matrix[mid][n - 1]){
                lm = mid + 1;
            }
            else{
                int ln = 0, rn = n - 1;
                while(ln <= rn){
                    int midn = ln + (rn - ln) / 2;
                    if(matrix[mid][midn] < target){
                        ln = midn + 1;
                    }
                    else if(matrix[mid][midn] > target){
                        rn = midn - 1;
                    }
                    else{
                        return true;
                    }
                }
                break;
            }
        }
        return false;
    }
}
