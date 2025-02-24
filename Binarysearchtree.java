
class BinaryNode
{
    int data;
    int count;
    BinaryNode left;
    BinaryNode right;
    BinaryNode(int data){
        this.data = data;
        this.count = 1;
        this.left = null;
        this.right = null;
        
    }
}

class Binarysearchclass
{
    BinaryNode root;
    Binarysearchclass(){
        this.root = null;
    }
    public boolean insert(int data){
        if(this.root == null){this.root = new BinaryNode(data);return true;}
        else{
            BinaryNode temp = this.root;
            while(temp!=null){
                if(temp.data == data){
                    temp.count = temp.count + 1;return true;
                }
                else{
                    if(temp.data > data){
                        if(temp.left == null){temp.left = new BinaryNode(data);return true;}
                        temp = temp.left;
                    }
                    else{
                        if(temp.right == null){temp.right = new BinaryNode(data); return true;}
                        temp = temp.right;
                    }
                }
            }
            return false;
        }
    }
    public boolean findelement(int data){
        if(this.root == null)return false;
        else{
            BinaryNode temp = this.root;
            while(temp!=null){
                if(temp.data == data)return true;
                else{
                    if(temp.data > data) temp = temp.left;
                    else temp = temp.right;
                }
            }
            return false;
        }
    }

    public BinaryNode findmax(BinaryNode root){
        BinaryNode temp = root;
        while(temp.right!=null) temp = temp.right;
        return temp;
    }
    public BinaryNode findmin(BinaryNode root){
        BinaryNode temp = root;
        while(temp.left!=null) temp = temp.left;
        return temp;
    }
    public BinaryNode delete(BinaryNode root,int data,boolean component){
        if(root == null)return null;
        else if(root.data > data){ root.left = this.delete(root.left,data,component);return root; }
        else if(root.data < data){ root.right = this.delete(root.right, data, component);return root;  }
        else{
            if(root.left == null && root.right == null){
                if(component == true || root.count == 1)return null;
                else{
                    root.count = root.count - 1; return root;
                }
            }
            else if(root.left == null && root.right != null){
                if(component == true || root.count == 1)return root.right;
                else{
                    root.count = root.count - 1; return root;
                }
            }
            else if(root.left != null && root.right == null){
                if(component == true || root.count == 1)return root.left;
                else{
                    root.count = root.count - 1; return root;
                }
            }
            else{
                BinaryNode maxNode = this.findmax(root.left);
                root.data = maxNode.data;root.count = maxNode.count;
                root.left = this.delete(root.left,maxNode.data,true);
                return root;
            }
        }
    }
    public void deleteElement(int data){
        this.root = this.delete(root, data, false); 
    }
    public void inorderTraversal(BinaryNode root)
    {
        if(root == null)return;
        else{
            this.inorderTraversal(root.left);
            System.out.println(root.data);
            this.inorderTraversal(root.right);
            return;
        }
    }
}

public class Binarysearchtree {
    public static void main(String args[]){
        Binarysearchclass b1 = new Binarysearchclass();
        b1.insert(4);
        b1.insert(3);
        b1.insert(8);
        b1.insert(9);
        b1.insert(10);
        b1.insert(12);
        b1.insert(3);
        b1.insert(20);
        b1.deleteElement(4);
        b1.deleteElement(20);
        b1.deleteElement(3);
        b1.deleteElement(8);
        b1.deleteElement(12);
        b1.deleteElement(10);
        b1.deleteElement(9);
        b1.deleteElement(3);
        b1.inorderTraversal(b1.root);
        System.out.println(b1.root);
    }
}
