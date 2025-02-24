import java.util.Queue;
import java.util.LinkedList;

class BinaryNode
{
    int data;
    BinaryNode left;
    BinaryNode right;
    BinaryNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
class Binaryclass
{
    BinaryNode root;
    Binaryclass(){
        this.root = null;
        this.root = new BinaryNode(3);
        this.root.left = new BinaryNode(4);
        this.root.right = new BinaryNode(1);
        this.root.left.left = new BinaryNode(2);
        this.root.left.right = new BinaryNode(1);
        this.root.left.left.left = new BinaryNode(9);
        this.root.left.right.left = new BinaryNode(6);
        this.root.left.right.right = new BinaryNode(10);
    }
    void inorderTraversal(BinaryNode root)
    {
        if(root == null)return;
        else{
            this.inorderTraversal(root.left);
            System.out.println(root.data);
            this.inorderTraversal(root.right);
            return;
        }
    }
    void preorderTraversal(BinaryNode root)
    {
        if(root == null)return;
        else{
            System.out.println(root.data);
            this.preorderTraversal(root.left);
            this.preorderTraversal(root.right);
            return;
        }
    }

    void postOrderTraversal(BinaryNode root)
    {
        if(root == null)return;
        else{
            this.preorderTraversal(root.left);
            this.preorderTraversal(root.right);
            System.out.println(root.data);
            return;
        }
    }
    void levelOrderTraversal(){
        Queue<BinaryNode> Q1 = new LinkedList<BinaryNode>();
        BinaryNode temp;
        if(this.root != null){
            Q1.add(this.root);
            while(!Q1.isEmpty()){
                temp = Q1.poll();
                if(temp==null)break;
                System.out.println(temp.data);
                if(temp.left != null)Q1.add(temp.left);
                if(temp.right != null)Q1.add(temp.right);
            }
        }
    }

}
public class Binarytree {
    public static void main(String args[]){
        Binaryclass bc = new Binaryclass();
        // bc.inorderTraversal(bc.root);
        // bc.preorderTraversal(bc.root);
        // bc.postOrderTraversal(bc.root);

        bc.levelOrderTraversal();
        

    }
}
