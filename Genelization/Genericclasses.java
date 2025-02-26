package Genelization;

class MyData <T>
{
    T i;
    public void add(T i1){
        this.i = i1;
    }
    public T get(){
        return this.i;
    }
}

public class Genericclasses {
    public static void main(String args[]){
        MyData<Integer> m = new MyData<Integer>();
        MyData<String> m1 = new MyData<String>();
        MyData<Double> m2 = new MyData<Double>();
        
        m.add(3);
        m1.add("vishal nagar");
        m2.add(3.4);

        System.out.println(m.get());
        System.out.println(m1.get());
        System.out.println(m2.get());


        // m.add("vishal nagar");
        // System.out.println(m.get());
    }
}
