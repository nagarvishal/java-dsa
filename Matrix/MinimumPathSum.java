package Matrix;


class Solution {
   
    
    public int minPathSum(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(!(i==0 && j==0)){
                    if(i==0 && j!=0){
                        grid[i][j] = grid[i][j]+grid[i][j-1]; 
                    }
                    else if(i!=0 && j==0){
                        grid[i][j] = grid[i][j] + grid[i-1][j];
                    }
                    else{
                        if(grid[i][j]+grid[i][j-1] > grid[i][j]+grid[i-1][j]){
                            grid[i][j] = grid[i][j] + grid[i-1][j];
                        }
                        else{
                            grid[i][j] = grid[i][j] + grid[i][j-1];
                        }
                    }
                }
            }
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println("\n");
        }

        return grid[grid.length-1][grid[0].length-1]; 
    }
}
public class MinimumPathSum {
    public static void main(String args[])
    {
        Solution s1 = new Solution();
        int[][] matrix = {{1,2,3},{4,5,6}};
        int minSum = s1.minPathSum(matrix);
        System.out.println("minimum sum = "+minSum);
        return;
    } 
}
