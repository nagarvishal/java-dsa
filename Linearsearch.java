class Linear
{
    int arr[];
    int n;
    int top;
    Linear(int capacity){
        this.n = capacity;
        this.top = -1;
        this.arr = new int[this.n];
    }
    void insert(int data){
        this.top = this.top + 1;
        this.arr[top] = data;
        return;
    }
    int linearsearch(int data){
        for(int i=0;i<=this.top;i++){
            if(this.arr[i] == data)return i;
        }
        return -1;
    }
    
}
public class Linearsearch {
    public static void main(String args[]){
        Linear l1 = new Linear(10);
        l1.insert(4);
        l1.insert(5);
        l1.insert(2);
        l1.insert(9);
        l1.insert(10);
        l1.insert(9);
        l1.insert(11);
        l1.insert(1);
        System.out.println(l1.linearsearch(2));
        System.out.println(l1.linearsearch(10));
        System.out.println(l1.linearsearch(4));
        System.out.println(l1.linearsearch(3));
        System.out.println(l1.linearsearch(9));
    }    
}
