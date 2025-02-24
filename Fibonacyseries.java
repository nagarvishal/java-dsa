class Fiboclass
{
    public int findNthElement(int n)
    {
        if(n==1 || n==2){
            return 1;
        }
        else{
            return this.findNthElement(n-1)+this.findNthElement(n-2);
        }
    }
}
public class Fibonacyseries {
    public static void main(String args[]){
        Fiboclass fc = new Fiboclass();
        System.out.println(fc.findNthElement(5));
        System.out.println(fc.findNthElement(2));
        System.out.println(fc.findNthElement(10));
        System.out.println(fc.findNthElement(20));
    }
}
