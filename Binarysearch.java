import java.util.Scanner;
class BinarySearchch
{
    int arr[];
    int n;
    
    BinarySearchch(int capacity){
        this.n = capacity;
        Scanner sc = new Scanner(System.in);
        arr = new int[this.n];
        for(int i=0;i<this.n;i++){
            arr[i] = sc.nextInt();
        }
    }
    int binarysearch(int data){
        int left = 0;
        int right = this.n-1;
        int mid;
        while(left<=right){
            mid = (int)(left+right)/2;
            if(data > this.arr[mid]){
                left = mid + 1;
            }
            else if(data < this.arr[mid]){
                right = mid - 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}
public class Binarysearch {
    public static void main(String args[]){
        BinarySearchch b1 = new BinarySearchch(5);
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        System.out.println(b1.binarysearch(n));
        n = sc.nextInt();
        System.out.println(b1.binarysearch(n));
        n = sc.nextInt();
        System.out.println(b1.binarysearch(n));

        
    }
}
