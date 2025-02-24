/** Implementation of stack using Array - first in last out, last in frist out */
class Stackclass
{
    int arr[];
    int top;
    int capacity;
    Stackclass(int capacity){
        this.capacity = capacity;
        this.arr = new int[this.capacity];
        this.top = -1;
    }
    public void push(int data){
        if(this.top == this.capacity-1){
            int arr1[] = new int[2*this.capacity];
            for(int i=0;i<=this.top;i++){ arr1[i] = this.arr[i]; }
            this.arr = arr1;
            this.capacity = this.capacity * 2;
        }
        this.top = this.top + 1;
        this.arr[this.top] = data;return;
    }
    public int pop(){
        if(this.top == -1)return -1;
        else {
            int index = this.top;
            int data = this.arr[index];
            this.top = this.top - 1;
            if(this.top < (int)((this.capacity/2)-1)){
                int arr1[] = new int[(int)this.capacity/2];
                for(int i=0;i<=this.top;i++){ arr1[i] = this.arr[i]; }
                this.arr = arr1;
                this.capacity = (int)this.capacity/2;
            }
            return data;
        }
    }
    public int size(){
        return this.top+1;
    }
    public int topelement(){
        if(this.top == -1)return -1;
        else{
            return this.arr[this.top];
        }
    }
    public boolean isfull(){
        if(this.top == this.capacity-1)return true;
        return false;
    }
    public boolean isempty(){
        if(this.top == -1)return true;
        return false;
    }

}

class Stacklinklist
{
    class Node
    {
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    Node head = null;
    int length;
    public void push(int data){
        if(this.head == null) this.head = new Node(data);
        else{
            Node temp = new Node(data);temp.next = this.head;
            this.head = temp;
        }
    }
    public int pop(){
        if(this.head == null)return -1;
        else{
            Node temp = this.head;this.head = temp.next;
            return temp.data;
        }
    }
    public boolean isempty(){
        if(this.head==null)return true;return false;
    }
}

public class Stack {
    public static void main(String args[]){

        Stacklinklist s1 = new Stacklinklist();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.push(4);
        System.out.println(s1.pop());
        System.out.println(s1.pop());
        System.out.println(s1.pop());
        System.out.println(s1.pop());
        System.out.println(s1.pop());
        System.out.println(s1.pop());


        // Stackclass s1 = new Stackclass(3);
        // s1.push(1);
        // s1.push(2);
        // s1.push(3);
        // s1.push(4);
        // s1.push(5);
        // s1.push(6);
        // s1.push(7);
        // s1.push(8);
        // System.out.println(s1.pop());
        // System.out.println(s1.pop());
        // System.out.println(s1.pop());
        // System.out.println(s1.pop());
        // System.out.println(s1.pop());
        // System.out.println(s1.pop());
        // System.out.println(s1.isfull());
        // System.out.println(s1.isempty());
        // System.out.println(s1.topelement());
        // System.out.println(s1.size());
        // System.out.println(s1.pop());
        // System.out.println(s1.pop());
        // System.out.println(s1.pop());
    }
}
