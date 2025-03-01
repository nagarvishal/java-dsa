package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> l1 = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        int min = rows > cols ? cols:rows;

        for(int i=0;i<=(int)(min-1)/2;i++){
            for(int j=i; j<=cols-i-1; j++){
                l1.add(matrix[i][j]);
            }
            for(int j=i+1; j<=(rows-i-1); j++){
                l1.add(matrix[j][cols-i-1]);
            }
            for(int j=cols-i-2; j>=i; j--){
                if(rows-i-1!=i){
                    l1.add(matrix[rows-i-1][j]);
                }
            }
            for(int j=rows-i-2;j>=i+1;j--){
                if(i!=cols-i-1){
                    l1.add(matrix[j][i]);
                }
            }
        }
        return l1;
        
    }
}

public class SpiralMatrix {
    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        int[][] matrix = new int[2][4];
        for(int i=0;i<2;i++){
            for(int j=0;j<4;j++){
                matrix[i][j] = s.nextInt();
            }
        }

        Solution s1 = new Solution();
        s1.spiralOrder(matrix);
        return;
    }
}
