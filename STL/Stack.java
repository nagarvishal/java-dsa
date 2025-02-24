package STL;

public class Stack<T> {
    T arr[];
    int capacity;
    int top;
    @SuppressWarnings("unchecked")
    Stack(int increase_by){
        this.capacity = 20;
        this.top = -1;
        this.arr = (T[]) new Object[this.capacity];
    }

    @SuppressWarnings("unchecked")
    void insert(T data)
    {
        if(this.top == this.capacity-1){
            this.capacity = this.capacity *2;
            this.arr = (T[]) new Object[this.capacity];
        }
        else{
            this.top = this.top + 1;
            this.arr[this.top] = data;
        }
    }

    T delete(T data)
    {
        if(this.top == -1)return null;
        else{
            T data1 = this.arr[this.top];
            return data1;
        }
    }

    boolean isempty(){
        if(this.top == -1)return true;return false;
    }

    boolean isfull(){
        if(this.top == this.capacity)return true;return false;
    }
    
}
