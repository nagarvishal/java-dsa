package STL;

public class GenericBox_1<T> 
{
    private T data;
    public GenericBox_1(T data)
    {
        this.data = data;
    }
    public T getData(){
        return this.data;
    }

    public void setData(T data){
        this.data = data;
        return;
    }

}






