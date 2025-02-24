class Heapclass
{
    int n;
    int capacity;
    int array[];
    Heapclass(int capacity){
        this.n = 0;
        this.capacity = capacity;
        this.array = new int[this.capacity];
    }
    void swapping(int index1, int index2){
        int temp = this.array[index1]; this.array[index1] = this.array[index2];
        this.array[index2] = temp;
        return;

    }
    boolean findElement(){
        
        return true;
    }
    boolean insert(int data){
        if(this.n == this.capacity)return false;
        int index = this.n; 
        this.array[index] = data; this.n = this.n + 1;
        while(index>0){
            if(this.array[(int)((index-1)/2)] < this.array[index]){
                this.swapping(index, (int)(index-1)/2);
                index = (int)((index-1)/2);
            }
            else{
                break;
            }
        }

        return true;
    }
    int delete(){
        if(this.n == 0)return -1;
        else{
            int index = 0; int data = this.array[index];
            this.array[index] = this.array[this.n-1]; this.n = this.n-1;
            while(2*index+1 <= this.n-1){
                if(2*index+1 == this.n-1){
                    if(this.array[2*index+1] > this.array[index]){
                        this.swapping(2*index+1,index);
                        index = 2*index+1;
                    }
                    else{
                        break;
                    }
                }
                else{
                    if(this.array[2*index+1] > this.array[index] || this.array[2*index+2] > this.array[index]){
                        if(this.array[2*index+1] > this.array[2*index+2]){
                            this.swapping(2*index+1, index);
                            index = 2*index+1;
                        }
                        else{
                            this.swapping(2*index+2, index);
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
    boolean deleteGivenElement(int data){
        int index = 0;
        while(index < this.n){
            if(this.array[index] == data){
                this.array[index] = this.array[this.n-1]; this.n = this.n - 1;
                while(2*index+1 <= this.n-1){
                    if(2*index+1 == this.n-1){
                        if(this.array[2*index+1] > this.array[index]){
                            this.swapping(2*index+1, index);
                            index = 2*index+1;
                        }
                        else break;
                    }
                    else{
                        if((this.array[2*index+1] > this.array[index]) || (this.array[2*index+2] > this.array[index])){
                            if(this.array[2*index+1] > this.array[2*index+2]){
                                this.swapping(index,2*index+1);index = 2*index+1;
                            } 
                            else{
                                this.swapping(index, 2*index+2);index = 2*index+2;
                            }
                        }
                        else{
                            break;
                        }
                    }
                }
            }
            index = index + 1;
        }
        return false;
    }



}
public class Heap {
    public static void main(String args[]){
        Heapclass h1 = new Heapclass(10);
        h1.insert(3);
        h1.insert(5);
        h1.insert(9);
        h1.insert(1);
        h1.insert(10);
        h1.insert(2);
        h1.insert(8);
        h1.insert(9);
        h1.insert(4);
        System.out.println(h1.delete());
        System.out.println(h1.delete());
        System.out.println(h1.delete());
        System.out.println(h1.delete());
        System.out.println(h1.delete());
        System.out.println(h1.delete());
        System.out.println(h1.delete());
    }
}
