package DynamicProgramming;

import java.util.Scanner;

class Solution {
    public boolean canJump(int[] nums) {
        if(nums[0] == 0)return false;
        int maxjumpindex = nums[0];
        for(int i=1;i<nums.length-1;i++){
            if(nums[i] == 0){
                if(maxjumpindex <= i){
                    return false;
                }
            }
            else{
                if(maxjumpindex < nums[i]+i){
                    maxjumpindex = nums[i]+i;
                }
            }
        }
        if(maxjumpindex>=nums.length-1)return true;
        else return false;
    }
}

public class JumpGrame {
    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int nums[] = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = s.nextInt();
        }

        Solution s1 = new Solution();
        boolean answer = s1.canJump(nums);
        System.out.println(answer);
        return;
    }
}
