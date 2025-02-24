

class GenericBox<T> 
{
    private T data;
    public GenericBox(T data)
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

class GeneralSum<T1,T2>
{
    private T1 data_1;
    private T2 data_2;

    public void setValues(T1 value_1 , T2 value_2){
        this.data_1 = value_1;
        this.data_2 = value_2;
    }

    public void showValues(){
        System.out.println(this.data_1);
        System.out.println(this.data_2);
    }
}

public class Generalclass {
    public static void main(String args[]){
        // GenericBox<Integer> G1 = new GenericBox<>(10);
        // System.out.println(G1.getData());
        // G1.setData(7);
        // System.out.println(G1.getData());

        GeneralSum<Integer,Float> GS = new GeneralSum<>();
        GS.setValues(4, (float)3.4);
        GS.showValues();
        GS.showValues();
        return;
    }
}
