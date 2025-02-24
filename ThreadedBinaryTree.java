class BinaryTree
{
    class BinaryNode
    {
        int data;
        BinaryNode left;
        BinaryNode right;
        int star;
        BinaryNode(int data){
            this.data = data;
            this.left = null;
            this.right = null;
            this.star = 0;
        }
    }
    BinaryNode root;
    BinaryTree(){
        root = new BinaryNode(5);
        root.left = new BinaryNode(8);
        root.right = new BinaryNode(3);
        root.left.left = new BinaryNode(9);
        root.left.right = new BinaryNode(8);
        root.right.left = new BinaryNode(5);
        root.right.right = new BinaryNode(4);
        root.left.left.left = new BinaryNode(2);
        root.left.right.left = new BinaryNode(3);
    }
    void convertThreadedBinary(BinaryNode root,BinaryNode parent)
    {
        if(root==null)return;
        else{
            this.convertThreadedBinary(root.left, root);
            if(root.right==null){
                root.right = parent;
                root.star = 1;
            }
            this.convertThreadedBinary(root.right, parent);
            return;
        }
    }
    void inorderwithrecursion()
    {
        BinaryNode temp = this.root;
        while(temp!=null){
            while(temp.left!=null){
                temp = temp.left;
            }
            while(temp!=null && temp.star == 1){
                System.out.println("vishal nagar");
                System.out.println(temp.data);
                temp = temp.right;
            }
            if(temp!=null){
                System.out.println("keshave nagar");
                System.out.println(temp.data);
                temp = temp.right;
            }
        }
        return;
    }
}
public class ThreadedBinaryTree {
    public static void main(String args[]){
        BinaryTree b1 = new BinaryTree();
        b1.convertThreadedBinary(b1.root, null);
        b1.inorderwithrecursion();
    }
}
