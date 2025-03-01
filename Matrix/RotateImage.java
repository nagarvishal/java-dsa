package Matrix;

import java.util.Scanner;

class Solution {
    public void rotate(int[][] matrix) {
        for(int i=0;i<=(int)((matrix.length-1)/2);i++){
            if(matrix.length-2*i==1){
                break;
            }
            else{
                for(int j=i;j<=matrix.length-i-2;j++){
                    int temp = matrix[i][j];

                    matrix[i][j] = matrix[matrix.length-j-1][i];
                    matrix[matrix.length-j-1][i] = matrix[matrix.length-i-1][matrix.length-j-1];
                    matrix[matrix.length-i-1][matrix.length-j-1] = matrix[j][matrix.length-i-1];
                    matrix[j][matrix.length-i-1] = temp;
                }
            }
        } 
    }
}

public class RotateImage {
    public static void main(String args[])
    {
        Solution s1 = new Solution();
        Scanner s = new Scanner(System.in);
        int[][] matrix = new  int[4][4];
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++) matrix[i][j] = s.nextInt();
        }

        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++)System.out.print(matrix[i][j]+" ");
            System.out.print("\n");
        }

        s1.rotate(matrix);
        System.out.print("\n\n");

        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++) System.out.print(matrix[i][j]+" ");
            System.out.print("\n");
        }
        // System.out.print(matrix.length);
    }
}
