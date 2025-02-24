// class Hash
// {
//     int array[];
//     int  n;
//     Hash(int capacity){
//         this.n = capacity;
//         this.array = new int[2*this.n];
//         for(int i=0;i<2*this.n;i++){
//             this.array[i] = -1;
//         }
//     }
//     void insert(int data){
//         int index = this.hashfunction(data);
//         if(this.array[index]!=-1){
//             for(int i=index+1;i<2*this.n;i++){
//                 if(this.array[i]==-1){
//                     this.array[i] = data;return;
//                 }
//             }
//         }
//         else{
//             this.array[index] = data;return;
//         }
//     }
//     int findindex(int data){
//         int index = this.hashfunction(data);
//         if(this.array[index] == data)return index;
//         else{
//             while(index < 2*this.n && this.array[index]!=data)index = index + 1;
//             if(index < 2*this.n)return index;
//             else return -1;
//         }
//     }
//     int hashfunction(int data){
//         int index = data%this.n;
//         return index;
//     }
//     void display(){
//         for(int i=0;i<2*this.n;i++)System.out.println(this.array[i]);
//     }

// }

// class Hash
// {
//     String strArray[];
//     int n;
//     Hash(int capacity){
//         this.n = capacity;
//         this.strArray = new String[2*this.n];
//         for(int i=0;i<2*this.n;i++)this.strArray[i] = "";
//     }
//     int hashfunction(String str){
//         int sum = 0;
//         for(int i=0;i<str.length();i++){
//             sum = sum + (int)str.charAt(i);
//         }
//         return sum%this.n;
//     }
//     void insert(String str){
//         int index = this.hashfunction(str);
//         if(this.strArray[index] == "") this.strArray[index] = str;
//         else{
//             for(int i=index;i<2*this.n;i++)if(this.strArray[i]!=""){this.strArray[i] = str;break;}
//         }
//         return;
//     }
//     int findIndex(String str){
//         int index = this.hashfunction(str);
//         for(int i=index;i<2*this.n;i++){
//             if(this.strArray[i] == str)return i;
//         }
//         return -1;
//     }
//     void display(){
//         for(int i=0;i<2*this.n;i++)System.out.println(this.strArray[i]+"   "+i);
//     }

// }


class Hash
{
    class Node
    {
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    Node larray[];
    int n;
    Hash(int capacity){
        this.n = capacity;
        this.larray = new Node[this.n];
        for(int i=0;i<this.n;i++)this.larray[i] = null;
    }
    int hashfunction(int data){
        int index = data%this.n;
        return index;
    }
    void insert(int data){
        int index = this.hashfunction(data);
        if(this.larray[index] == null){
            this.larray[index] = new Node(data);
        }
        else{
            Node temp = this.larray[index];
            while(temp.next!=null)temp = temp.next;
            temp.next = new Node(data);
            return;
        }
    }
    int findindex(int data){
        int index = this.hashfunction(data);
        Node temp = this.larray[index];
        while(temp!=null){
            if(temp.data == data)return index; temp =  temp.next;
        }
        return -1;
    }
    boolean delete(int data){
        int index = this.hashfunction(data);
        if(this.larray[index] == null)return false;
        else if(this.larray[index].data == data){
            this.larray[index] = this.larray[index].next; return true;
        }
        else{
            Node temp = this.larray[index];
            while(temp.next != null && temp != null){
                if(temp.next.data == data){
                    temp.next = temp.next.next; return true;
                }
                temp = temp.next;
            }
            return false;
        }
    }
    void display(){
        Node temp;
        for(int i=0;i<this.n;i++){
            temp = this.larray[i];
            if(temp==null){
                System.out.println("null");
            }
            else{
                while(temp!=null){
                    System.out.println(temp.data);
                    temp = temp.next;
                }
            }
        }
    }
}
public class Hashing {
    public static void main(String args[]){

        Hash h1 = new Hash(10);
        h1.insert(3);
        h1.insert(8);
        h1.insert(33);
        h1.insert(2);
        h1.insert(9);
        h1.insert(10);
        h1.insert(12);
        h1.insert(13);
        // System.out.println(h1.findindex(10));
        // System.out.println(h1.findindex(3));
        // System.out.println(h1.findindex(13));
        // System.out.println(h1.findindex(12));
        // System.out.println(h1.findindex(8));
        h1.display();

        


        // h1.insert("vishal nagar");
        // h1.insert("mayank agrawal");
        // h1.insert("keshave nagar");
        // h1.insert("deepak nagar");
        // h1.insert("manoj kumar");
        // h1.display();
        // System.out.println(h1.findIndex("vishal nagar"));
        // System.out.println(h1.findIndex("keshave nagar"));
        // System.out.println(h1.findIndex("manoj kumar"));
        // System.out.println(h1.findIndex("mayank agrawal"));
        // System.out.println(h1.findIndex("deepak kushwal"));



        // Hash h1 = new Hash(10);
        // h1.insert(5);
        // h1.insert(15);
        // h1.insert(22);
        // h1.insert(9);
        // h1.insert(21);
        // h1.insert(45);
        // h1.insert(99);
        // h1.insert(77);
        // System.out.println(h1.findindex(5));
        // System.out.println(h1.findindex(21));
        // System.out.println(h1.findindex(45));
        // System.out.println(h1.findindex(99));
        // System.out.println(h1.findindex(56));


        
    }
}
