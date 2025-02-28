package binarysearchtree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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


    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        List<TreeNode> l1 = new ArrayList<TreeNode>();

        TreeNode temp = root;
        while(temp!=null){
            while(temp.left!=null){
                s1.add(temp); temp = temp.left;
            }
            s1.add(temp);

            while(!s1.isEmpty()){
                temp = s1.pop();
                if(temp.right!=null){
                    l1.add(temp);
                    break;
                }
                else  l1.add(temp);
            }
            temp = temp.right;
        }
        boolean temp2 = true;
        for(int i=0;i<l1.size()-1;i++){
            if(l1.get(i).val >= l1.get(i+1).val){
                temp2 = false;
            }
        }
        


        return temp2;
    }
}


public class RecoverBST {
    public static void main(String args[]){
        TreeNode root = new TreeNode(5,null,null);
        root.left = new TreeNode(3,null,null);
        root.right = new TreeNode(10,null,null);
        root.left.left = new TreeNode(1,null,null);
        root.right.right = new TreeNode(20,null,null);


        Solution s1 = new Solution();
        s1.isValidBST(root);
        return;
    }

}
