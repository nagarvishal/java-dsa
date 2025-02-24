import java.util.Scanner;


class Sortingclass
{
    int arr[];
    int n;
    
    Sortingclass(int capacity){
        this.n = capacity;
        Scanner sc = new Scanner(System.in);
        arr = new int[this.n];
        for(int i=0;i<this.n;i++){
            arr[i] = sc.nextInt();
        }
    }
    void swapping(int index1,int index2){
        int temp = this.arr[index1];
        this.arr[index1] = this.arr[index2];
        this.arr[index2] = temp;
        return;
    }
    void bubblesort(){
        boolean temp;
        for(int i=0;i<n;i++){
            temp = true;
            for(int j=0;j<n-i-1;j++){
                if(this.arr[j] > this.arr[j+1]){
                    temp = false;
                    this.swapping(i,j);
                }
            }
            if(temp==true)return;
            temp = true;
            for(int j=n-i-1;j>0;j--){
                if(this.arr[j] < this.arr[j-1]){
                    this.swapping(j,j-1);
                    temp = false;
                }
            }
            if(temp==true)return;
        }
        return;
    }
    void selectionsort(){
        int min;
        int minindex;
        for(int i=0;i<this.n-1;i++){
            min = this.arr[i];
            minindex = i;
            for(int j = i+1; j<this.n; j++){
                if(this.arr[j] < min){
                    minindex = j;
                    min = this.arr[j];
                }
            }
            this.swapping(i,minindex);
        }
        return;
    }

    void insertionsort(){
        int j;
        for(int i=1;i<n;i++){
            for(j=i-1;j>=0;j--){
                if(this.arr[j] > this.arr[j+1]){
                    this.swapping(j+1,j);
                }
                else{
                    break;
                }
            }
        }
    }
    void quicksort(int left,int right){
        /** Quick Sort -  */
        /** [ 8 , 5 , 6 , 3 , 2 , 9 , 2 , 1 , 10 ] */
        /** 
         *  at index = 0, data = 8
         * [ 4 , 5 , 8 , 6 , 2 , 1 , 8 , 9 , 10 ]
         * new -> [ 5 , 6 , 3 , 2 , 2 , 1 ] -> index = 0,data = 5 ,                   [9 , 10] index = 0, data = 9
         * [3 , 2 , 2 , 1 , 5 , 6]                          [ 9, 10] return;
         * [ 3 , 2 , 2 , 1 ] , [ 6 ] return
         * [ 2 ,2 , 1] , [3]return
         * [1 , 2, 2]
         * [1] return , [2] return
         */
        if(left<right){
            int pindex = left;
            int data = this.arr[pindex];
            for(int i=left+1;i<=right;i++){
                if(this.arr[pindex] > this.arr[i]){
                    this.swapping(i,pindex);
                    if(i!=pindex+1){
                        this.swapping(pindex+1,i);
                    }
                    pindex = pindex + 1;
                }
            }
            this.quicksort(left, pindex-1);
            this.quicksort(pindex+1, right);
            return;
        }
        else return;

    }
    void mergesort(int left, int right){
        /** [ 5 , 7 , 4 , 3 , 8 , 2 , 1 , 9 , 10 ] */
        /**
         * [ 5 , 7 , 4 , 3] | [8 , 2 , 1 , 9 , 10]
         * [ 5 , 7 ] || [ 4, 3 ] | [ 8 , 2 ] || [ 1 , 9 , 10]
         * [5] ||| [7] || [4] ||| [3] | [8] ||| [2] || [1 , 9] ||| [10]
         * [5] ||| [7] || [4] ||| [3] | [8] ||| [2] || [1] |||| [9] ||| [10]
         * [5 , 7] || [ 3 , 4] | [ 2 , 8 ] || [1 , 9 , 10]
         * [ 3 , 4, 5, 7] | [ 1 , 2 , 8, 9 , 10]
         * [1 , 2, 3 , 4, 5, 7 , 8 , 9 , 10]
         */
        if(left < right){
            int middle = (int)(left+right)/2;
            this.mergesort(left, middle);
            this.mergesort(middle+1, right);
            int array[] = new int[right-left+1];
            int i = left,j=middle+1,k=0;
            while(i<=middle && j<=right){
                if(this.arr[i] > this.arr[j]){
                    array[k] = this.arr[j]; j++;k++;
                }
                else{
                    array[k] = this.arr[i]; i++;k++;
                }
            }
            while(i<=middle){
                array[k] = this.arr[i]; i++;k++;
            }
            while(j<=right){
                array[k] = this.arr[j]; j++;k++;
            }
            for( i = 0;i<k;i++){
                this.arr[i+left] = array[i];
            }
            return;
        }
        else{
            return;
        }
    }


    
    void display(){
        for(int i=0;i<this.n;i++){
            System.out.println(this.arr[i]);
        }
    }
}

class Heapsort
{
    int arr[];
    int n;
    int capacity;
    Heapsort(int capacity){
        this.n = 0;
        this.capacity = capacity;
        this.arr = new int[this.capacity];
    }
    void swapping(int index1, int index2){
        int data = this.arr[index1];
        this.arr[index1] = this.arr[index2];
        this.arr[index2] = data;
        return;
    }
    void insert(int data)
    {
        if(this.n == this.capacity)return;
        else{
            int index = this.n; this.n = this.n + 1;
            this.arr[index] = data;
            while(index > 0){
                if(this.arr[index] < this.arr[(int)(index-1)/2]){
                    this.swapping(index,(int)(index-1)/2);
                    index = (int)(index-1)/2;
                }
                else{
                    break;
                }
            }
        }
    }
    int delete(){
        if(this.n == 0)return -1;
        else{
            int index = 0;
            int data = this.arr[index];
            this.arr[index] = this.arr[this.n-1]; this.n = this.n-1;
            while(2*index+1 <= this.n-1){
                if(2*index+1 == this.n-1){
                    if(this.arr[index] > this.arr[2*index+1]){
                        this.swapping(index,2*index+1);index = 2*index+1;
                    }
                    else{
                        break;
                    }
                }
                else{
                    if((this.arr[index] > this.arr[2*index+1]) || (this.arr[index] > this.arr[2*index+2])){
                        if(this.arr[2*index+1] < this.arr[2*index+2]){
                            this.swapping(index,2*index+1);
                            index = 2*index+1;
                        }
                        else{
                            this.swapping(index,2*index+2);
                            index = 2*index+2;
                        }
                    }
                    else{
                        break;
                    }
                }
            }
            return data;
        }
    }
    boolean isempty(){
        if(this.n == 0)return true;return false;
    }
}



public class Sortingalgo {
    public static void main(String args[]){
        // Sortingclass s1 = new Sortingclass(10);
        // s1.bubblesort();
        // s1.selectionsort();
        // s1.insertionsort();
        // s1.quicksort(0, 5);
        // s1.mergesort(0, 9);

        // s1.display();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        Heapsort h1 = new Heapsort(n);
        for(int i=0;i<n;i++){
            h1.insert(arr[i]);
        }
        for(int i=0;i<n;i++){
            arr[i] = h1.delete();
        }
        for(int i=0;i<n;i++){
            System.out.println(arr[i]);
        }
        return;
    }
}
