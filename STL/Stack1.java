package STL;

public class Stack1<T> 
{
    T arr[];
    int capacity;
    int top;
    int increase_by;
    Stack1(){

    }
    

    @SuppressWarnings("unchecked")
    Stack1(int capacity , int increase_by){
        this.increase_by = increase_by;
        this.capacity = capacity;
        this.top = -1;
        this.arr = (T[]) new Object[this.capacity];
    }

    void insert(T data)
    {
        if(this.top == this.capacity-1){
            this.incresesize();
        }
        this.top = this.top + 1;
        this.arr[this.top] = data;
    }

    @SuppressWarnings("unchecked")
    void incresesize(){
        this.capacity = this.capacity + this.increase_by;
        T arr1[] =  (T[]) new Object[this.capacity];
        for(int i = 0;i<=this.top;i++) arr1[i] = this.arr[i];
        arr = arr1;
    }

    @SuppressWarnings("unchecked")
    void decreasesize(){
        this.capacity = this.capacity - this.increase_by;
        T arr1[] =  (T[]) new Object[this.capacity];
        for(int i = 0;i<=this.top;i++) arr1[i] = this.arr[i];
        arr = arr1;
    }

    

    T delete()
    {
        if(this.top == -1)return null;
        else{
            T data1 = this.arr[this.top];
            this.top = this.top - 1;
            return data1;
        }
    }

    boolean isempty(){
        if(this.top == -1)return true;return false;
    }

    boolean isfull(){
        if(this.top == this.capacity)return true;return false;
    }

    public static void main(String[] args) {
    
    }

}
