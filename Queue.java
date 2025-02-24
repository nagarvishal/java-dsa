class Queuearray
{
    int arr[];
    int front;
    int rear;
    int capacity;
    int size;
    Queuearray(int capacity){
        this.capacity = capacity;
        this.front = -1;
        this.rear = -1;
        this.capacity = capacity;
        this.arr = new int[this.capacity];
    }
    public void push(int data){
        if((this.rear+1)%this.capacity==this.front){
            int arr1[] = new int[2*this.capacity];
            int index = 0;
            int i = this.front;
            do
            {
                arr1[index] = this.arr[i]; index = index+1; i = (i+1)%this.capacity;
            }
            while(i!=this.front);
            this.arr = arr1;
            this.capacity = 2*this.capacity;
        }
        this.rear = (this.rear+1)%this.capacity;
        if(this.front==-1)this.front = this.rear;
        this.arr[this.rear] = data;
        this.size = this.size+1;
        return;
    }
    public int pop(){
        if(this.front == -1){
            return -1;
        }
        else{
            int data = this.arr[this.front];
            if(this.front == this.rear){
                this.front = -1;this.rear = -1;return data;
            }
            this.front = (this.front+1)%this.capacity;
            this.size = this.size-1;
            if((this.size+1) < (int)this.capacity/2){
                int arr1[] = new int[(int)this.capacity/2];
                int i=this.front;
                int index=0;
                do
                {
                    arr1[index] = this.arr[i];index = index+1; i=(i+1)%this.capacity;

                }
                while(i!=(this.rear+1)%this.capacity);
                this.front=0;
                this.rear = index-1;
                this.capacity = (int)this.capacity/2;
                this.arr = arr1;
            }
            return data;
        }
    }
    public boolean isfull(){
        if((this.rear+1)%this.capacity==this.front)return true;return false;
    }
    public boolean isempty(){
        if(this.front == -1)return true;return false;
    }
}

class Queuelinklist
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
    Node front;
    Node rear;
    int length;
    Queuelinklist(){
        this.front = null;
        this.rear = null;
        this.length = 0;
    }
    void push(int data){
        if(this.front == null && this.rear == null){
            this.front = new Node(data);this.rear = this.front;return;
        }
        else{
            Node temp = new Node(data);this.rear.next = temp;
            this.rear = temp;return;
        }
    }
    int pop(){
        if(this.front == null)return -1;
        else{
            Node temp = this.front;
            if(this.front == this.rear){ this.front = null;this.rear = null;return temp.data;}
            else{
                this.front = this.front.next;
                return temp.data;
            }
        }
    }
    boolean isempty(){
        if(this.front == null)return true;return false;
    }
    int fontelemnet(){
        if(this.front == null)return -1;return this.front.data;
    }
    int rearelement(){
        if(this.front == null)return -1;return this.rear.data;
    }
}
public class Queue {
    public static void main(String[] args){
        Queuelinklist q1 = new Queuelinklist();
        q1.push(1);
        q1.push(2);
        q1.push(3);
        q1.push(4);
        q1.push(5);
        System.out.println(q1.pop());
        System.out.println(q1.pop());
        System.out.println(q1.pop());
        System.out.println(q1.pop());
        System.out.println(q1.pop());
        System.out.println(q1.pop());
        System.out.println(q1.pop());
        System.out.println(q1.pop());
        System.out.println(q1.pop());
        // Queuearray q1 = new Queuearray(4);
        // q1.push(1);
        // q1.push(2);
        // q1.push(3);
        // q1.push(4);
        // q1.push(5);
        // q1.push(6);
        // q1.push(7);
        // System.out.println(q1.pop());
        // System.out.println(q1.pop());
        // System.out.println(q1.pop());
        // System.out.println(q1.pop());
        // System.out.println(q1.pop());
        // System.out.println(q1.pop());
        // System.out.println(q1.isfull());
        // System.out.println(q1.isempty());
        // System.out.println(q1.pop());
        // System.out.println(q1.pop());
        // System.out.println(q1.pop());
        // System.out.println(q1.pop());
        // System.out.println(q1.pop());


    }
}
