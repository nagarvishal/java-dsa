package DynamicProgramming;


class Solution {
    public int[][] generateMatrix(int n) {
        int rows = n;
        int cols = n;
        int min = n;
        int[][] matrix  = new int[rows][cols];
        int p = 1;
        

        for(int i=0;i<=(int)(min-1)/2;i++){
            for(int j=i; j<=cols-i-1; j++){
                matrix[i][j] = p;
                p++;
            }
            for(int j=i+1; j<=(rows-i-1); j++){
                matrix[j][cols-i-1] = p;
                p++;
            }
            for(int j=cols-i-2; j>=i; j--){
                if(rows-i-1!=i){
                    matrix[rows-i-1][j] = p;
                    p++;
                }
            }
            for(int j=rows-i-2;j>=i+1;j--){
                if(i!=cols-i-1){
                    matrix[j][i] = p;
                    p++;
                }
            }
        }
        return matrix;   
    }
}
public class SpiralMatrix2 {
    public static void main(String args[]){
        int n = 5;
        Solution s1 = new Solution();
        int matrix[][] = s1.generateMatrix(n);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.print("\n");
        }
    }
}
