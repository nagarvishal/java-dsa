package DynamicProgramming;

import java.util.Scanner;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
    }
}

public class InsertInterval {
    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int intervals[][] = new int[n][2];
        for(int i=0;i<n;i++){
            intervals[i][0] = s.nextInt();
            intervals[i][1] = s.nextInt();
        }
        
        return;
    }
}
