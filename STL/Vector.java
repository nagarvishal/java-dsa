package STL;
import STL.Stack1;

public class Vector <T> extends Stack1{
    Vector(int increase_by,int capacity){
        super(increase_by,capacity);
    }

    void addElement(T data){
        this.insert(data);
    }

    void insertElementAt(T data , int index)
    {
        if(this.top == this.capacity-1) this.incresesize();
        for(int i=this.top+1;i>index;i--) this.arr[i] = this.arr[i-1];
        this.arr[index] = data;
        return;
    }

    @SuppressWarnings("unchecked")
    T removeElementAt(int index)
    {
        if(this.top < index){
            throw new Error("Element is not greater then now i am very hppy");
        }
        else{
            T data = (T) this.arr[index];
            for(int i=index;i<this.top;i++) this.arr[i] = this.arr[i+1];
            this.top = this.top-1;
            return data;
        }
    }

    void clear(){
        this.top = -1;
    }

    @SuppressWarnings("unchecked")
    T firstElement(){
        if(this.top == -1)return null;
        else{
            return (T) this.arr[0];
        }
    }

    @SuppressWarnings("unchecked")
    protected Vector<T> clone(){
        Vector<T> t1 = new Vector<>(this.capacity,this.increase_by);
        t1.top = this.top;
        for(int i=0;i<=t1.top;i++){
            t1.arr[i] = this.arr[i];
        }
        return t1;        
    }

    @SuppressWarnings("unchecked")
    T elementAt(int index)
    {
        if(this.top < index)return null;
        else{
            return (T)this.arr[index];
        }
    }

    void set(int index, T element)
    {
        if(this.top < index){
            throw new Error("this is and error");
        }
        else{
            this.arr[index] = element;
        }
    }

    void merge_sort(int left,int right)
    {
        if(left >= right)return;
        else{
            int middle = (int)(left+right)/2;
            this.merge_sort(left, middle-1);
            this.merge_sort(middle, right);

            int i = 0 , j = middle;
            Vector<T> t1 = new Vector<>(right-left+1,this.increase_by);
            while(i<=middle-1 && j<=right){
                
            }
            while(i<=middle-1){

            }
            while(j<=right){

            }
            
        }
    }
    void sort(){
        this.merge_sort(0, this.top);
        return;
    }









}
