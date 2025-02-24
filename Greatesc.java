class GCD
{
    public int findGCD(int a,int b)
    {
        if(a>b){
            if(a%b == 0) return b;
            else return findGCD(a%b, b);
        }
        else{
            if(b%a == 0)return a;
            else return findGCD(a, b%a);
        }
    }
}
public class Greatesc {
    public static void main(String args[]){
        GCD g = new GCD();
        System.out.println(g.findGCD(5, 10));
        System.out.println(g.findGCD(7, 100));
        System.out.println(g.findGCD(10, 20));
    }
}
