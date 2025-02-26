package binarysearchtree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public void genBST(List<Integer> l1){
        
    }
    public List<TreeNode> generateTrees(int n) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<TreeNode> l3 = new ArrayList<>();
        for(int i=1;i<=n;i++){
            l1.add(i);
        }
        
        return null;
    }
}

public class UniqueBinarySearch {
   
    public static void main(String args[]){
        System.out.println("Enter a number");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Solution s1 = new Solution();
        s1.generateTrees(n);

        
    }
}
