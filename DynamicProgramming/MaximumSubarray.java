package DynamicProgramming;

import java.util.Scanner;

class Solution {
    public int maxSubArray(int[] nums) {
        int maxsum = nums[0];
        int sum = 0;
        if(nums[0]>0)sum = nums[0];
        for(int i=1;i<nums.length;i++){
            sum = sum + nums[i];
            if(sum>maxsum){
                maxsum = sum;
            }
            if(sum<0)sum = 0;
        }
        return maxsum;
    }
}

public class MaximumSubarray {
    public static void main(String args[])
    {
        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();

        int[] nums = new int[n];
        for(int i=0;i<n;i++)nums[i] = s.nextInt();
        
        Solution s1 = new Solution();
        int maxsum = s1.maxSubArray(nums);
        System.out.println("maximum sumarray sum is "+maxsum);
        return;
    }
}
