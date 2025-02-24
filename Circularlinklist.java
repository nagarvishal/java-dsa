class Node
{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
class Linklist
{
    Node end;
    public void insertAtFront(int data){
        if(this.end == null){
            this.end = new Node(data); this.end.next = this.end;
        }
        else{
            Node temp = new Node(data);temp.next = this.end.next;
            this.end.next = temp;
        }
    }
    public void insertAtRear(int data){
        if(this.end == null){
            this.end = new Node(data); this.end.next = this.end;
        }
        else{
            Node temp = new Node(data);temp.next = this.end.next;this.end.next = temp;
            this.end = temp;
        }
    }
    public boolean insertAfter(int data,int afterdata){
        if(this.end == null){
            return false;
        }
        else{
            Node temp = this.end.next;
            do
            {
                if(temp.data == afterdata){
                    Node temp1 = new Node(data); temp1.next = temp.next;
                    temp.next = temp1;
                    return true;
                }
                temp = temp.next;
            }
            while(temp!=this.end.next);
            return false;
        }
    }
    public boolean deleteAtEnd(){
        if(this.end == null)return false;
        else if(this.end.next == this.end){
            this.end = null;return true;
        }
        else{
            Node temp = this.end.next;
            while(temp.next != this.end) temp = temp.next;
            temp.next = this.end.next;
            this.end = temp;
            return true;
        }
    }
    public boolean deleteAtFront(){
        if(this.end == null)return false;
        else if(this.end.next == this.end){
            this.end = null;return true;
        }
        else{
            Node temp = this.end.next; this.end.next = temp.next;
            return true;
        }
    }
    public boolean deleteGivenData(int data){
        if(this.end == null)return false;
        else if(this.end.next == this.end){
            if(this.end.data == data){
                this.end = null;return true;
            }
            return false;
        }
        else{
            Node temp = this.end;
            do
            {
                if(temp.next.data == data){
                    Node temp1 = temp.next;temp.next = temp1.next;
                    if(temp1 == this.end){
                        this.end = temp;
                    }
                    return true;
                }
                temp = temp.next;
            }
            while(temp!=this.end);
        }
        return true;
    }
    void display(){
        Node temp = this.end;
        do
        {
            System.out.println(temp.data);
            temp = temp.next;
        }
        while(temp!=this.end);
    }

}
public class Circularlinklist {
    public static void main(String args[]){
        Linklist l1 = new Linklist();
        l1.insertAtFront(5);
        l1.insertAtRear(6);
        l1.insertAtFront(8);
        l1.insertAtFront(12);
        l1.insertAfter(6,10);
        l1.insertAfter(5, 11);
        l1.deleteAtEnd();
        l1.deleteAtFront();
        l1.deleteGivenData(6);
        l1.display();
    }   
}
