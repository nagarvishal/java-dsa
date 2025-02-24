class Node
{
    int data;
    Node prev;
    Node next;
    Node(int data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
class Linklist
{
    Node head = null;
    void insertAtFront(int data){
        if(this.head==null)
            this.head = new Node(data);
        else{
            Node temp = new Node(data); temp.next = this.head; 
            this.head.prev = temp;
            this.head = temp;
        }
        return;
    }
    void insertAtRear(int data){
        if(this.head==null)
            this.head = new Node(data);
        else{
            Node temp = this.head;
            while(temp.next != null) temp = temp.next;
            Node temp1 = new Node(data);temp.next = temp1;temp1.prev = temp;
            return;
        }
    }
    boolean insertAfterData(int data,int afterdata){
        if(this.head==null)return false;
        else if(this.head.next==null){
            if(this.head.data == afterdata){
                Node temp = new Node(data); temp.prev = this.head; this.head.next = temp; return true;
            }
            return false;
        }
        else{
            Node temp = this.head;
            while(temp != null){
                if(temp.data == afterdata){
                    Node temp1 = new Node(data);
                    if(temp.next == null){
                        temp1.next = null;temp1.prev = temp;
                        temp.next = temp1;
                    }
                    else{
                        temp1.next = temp.next;temp1.prev = temp;
                        temp.next.prev = temp1;temp.next = temp1;
                    }
                    return true;
                }
                temp = temp.next;
            }
            return false;
        }
    }
    boolean deleteAtFront(){
        if(this.head==null)return false;
        else if(this.head.next == null){
            this.head = null;return true;
        }
        else{
            this.head = this.head.next;this.head.prev = null;
            return true;
        }
    }
    boolean deleteAtRear(){
        if(this.head==null)return false;
        else if(this.head.next == null){
            this.head = null;return true;
        }
        else{
            Node temp = this.head;
            while(temp != null && temp.next != null && temp.next.next!= null){
                temp = temp.next;
            }
            temp.next = null;
            return true;
        }
    }
    boolean deleteGivenData(int data){
        if(this.head == null)return false;
        else if(this.head.next == null){
            if(this.head.data == data){
                this.head = null;
                return true;
            }
            return false;
        }
        else if(this.head.data == data){
            Node temp = this.head.next;temp.prev = null;this.head = temp;
            return true;
        }
        else{
            Node temp = this.head;
            while(temp!=null && temp.next != null){
                if(temp.next.data == data){
                    if(temp.next.next == null){
                        temp.next = null;return true;
                    }
                    else{
                        Node temp1 = temp.next;
                        temp.next = temp1.next;
                        temp1.next.prev = temp;
                        return true;
                    }
                }
            }
        }
        return true;
    }
    void display(){
        Node temp = this.head;
        while(temp!=null){
            System.out.println(temp.data);temp = temp.next;
        }
    }
}
public class Doublylinklist {
    public static void main(String args[]){
        Linklist l1 = new Linklist();
        l1.insertAtFront(5);
        l1.insertAtFront(2);
        l1.insertAtRear(10);
        l1.insertAtRear(15);
        l1.insertAfterData(7, 5);
        l1.insertAfterData(77, 2);
        l1.display();
    } 
}
