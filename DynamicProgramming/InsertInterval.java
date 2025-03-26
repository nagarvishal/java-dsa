package DynamicProgramming;

import java.util.Scanner;

class Solution {
    public boolean isoverride(int[] interval1,int[] interval2)
    {
        if((interval1[1] >= interval2[0] && interval1[1] <= interval2[1]) || (interval1[0] >= interval2[0] && interval1[0] <= interval2[1])){
            return true;
        }
        if((interval2[1] >= interval1[0] && interval2[1] <= interval1[1]) || (interval2[0] >= interval1[0] && interval2[0] <= interval1[1])){
            return true;
        }
        return false;
    }
    public int[] mergeInterval(int[] interval1, int[] interval2)
    {
        int left = interval1[0];
        int right = interval1[1];
        if(interval1[0] > interval2[0]) left = interval2[0];
        if(interval1[1] > interval2[1]) right = interval1[1];

        return new int[]{left,right};
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] finalInterval = new int[intervals.length][2];
        int j=0;
        for(int i=0;i<intervals.length;i++){
            if(this.isoverride( intervals[i] , newInterval)) {
                newInterval = this.mergeInterval( intervals[i] , newInterval );
            }
            else {
                finalInterval[j][0] = intervals[i][0];
                finalInterval[j][1] = intervals[i][1];
                j = j + 1;
            }
        }
        
        return finalInterval;
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
