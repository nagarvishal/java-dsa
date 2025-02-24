import java.util.Scanner;

class TestClass
{
    public int factorial(int n)
    {
        if(n==1){
            return 1;
        }
        else{
            return n*this.factorial(n-1);
        }
    }
}
public class Factorial {
    public static void main(String args[]){
        TestClass t1 = new TestClass();
        int f1 = t1.factorial(5);
        System.out.println(f1);

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(t1.factorial(n));
        n = sc.nextInt();
        System.out.println(t1.factorial(n));
        n = sc.nextInt();
        System.out.println(t1.factorial(n));
    }
}
