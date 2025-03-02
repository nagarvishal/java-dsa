package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Solution {
    int[] mergeInterval(int[] interval1,int[] interval)
    {

        if(interval1[1] > interval[1] ) return new int[]{interval1[0],interval1[1]};
        else return new int[]{interval1[0],interval[1]};
    }

    public int[][] merge(int[][] intervals) {
        int c_interval[],j;
        List<int[]> l1 = new ArrayList<>();

        Arrays.sort(intervals, new Comparator<>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                return p1[0] > p2[0] ? 1 : -1;
            }
        });

        for(int i=0;i<intervals.length;){
            c_interval = intervals[i];
            for(j=i+1;j<intervals.length;j++){
                if(c_interval[1] >= intervals[j][0]){
                    c_interval = this.mergeInterval(c_interval, intervals[j]);
                }
                else{
                    break;
                }
            }
            i = j;
            l1.add(c_interval);
            if(j==intervals.length)break;
        }

        int vals[][] = new int[l1.size()][2];
        for(int i=0;i<l1.size();i++){
            vals[i][0] = l1.get(i)[0];
            vals[i][1] = l1.get(i)[1];
        }

        return vals;
    }
}

public class MergeIntervals {
    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int intervals[][] = new int[n][2];
        for(int i=0;i<n;i++){
            intervals[i][0] = s.nextInt();
            intervals[i][1] = s.nextInt();
        }

        Solution s1 = new Solution();
        int vals[][] = s1.merge(intervals);
        System.out.print(vals);
        return;
    }
}
