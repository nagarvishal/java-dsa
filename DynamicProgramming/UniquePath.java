package DynamicProgramming;

class Solution {
    int count = 0;
    void countUniquePath(int row,int col,int m,int n)
    {
        if(row==m-1 && col==n-1){
            this.count = this.count + 1;
            return;
        }
        else{
            if(row==m-1){
                this.countUniquePath(row, col+1, m, n);
                return;
            }
            if(col==n-1){
                this.countUniquePath(row+1, col, m, n);
                return;
            }
            else{
                this.countUniquePath(row+1, col, m, n);
                this.countUniquePath(row, col+1, m, n);
                return;
            }
        }
    }
    public int uniquePaths(int m, int n) {
        this.countUniquePath(0, 0, m, n);
        return this.count;
    }
}
public class UniquePath {
    public static void main(String args[])
    {
        Solution s1 = new Solution();
        int count = s1.uniquePaths(3, 7);
        System.out.print(count);
        return;
    }
}
