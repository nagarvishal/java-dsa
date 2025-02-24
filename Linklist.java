class Node
{
    public int data;
    public Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
class Linklistclass
{
    Node head = null;
    int length;
    public void insertAtFirst(int data){
        if(this.head==null) this.head = new Node(data);
        else{
            Node temp = new Node(data);temp.next = this.head;this.head = temp;
        }
    }
    public void insertAtEnd(int data){
        if(this.head==null) this.head = new Node(data);
        else{
            Node temp1 = new Node(data); Node temp = this.head;
            while(temp!=null && temp.next!=null) temp = temp.next;
            temp.next = temp1;
        }
    }
    public boolean insertAtAfter(int data,int afterdata){
        if(this.head==null)return false;
        else{
            Node temp = this.head;
            while(temp!=null){
                if(temp.data==afterdata){
                    Node temp1 = new Node(data);
                    temp1.next = temp.next;
                    temp.next = temp1;
                    return true;
                }
                temp = temp.next;
            }
            return false;
        }
    }

    public int deleteAtFirst(){
        if(this.head==null)return -1;
        else{
            Node temp = this.head;this.head = this.head.next; return temp.data;
        }
    }
    public int deleteAtEnd(){
        if(this.head==null)return -1;
        else if(this.head.next==null){
            int data = this.head.data;this.head=null;return data;
        }
        else{
            Node temp = this.head;
            while(temp.next.next!=null) temp = temp.next;
            Node temp1 = temp.next;temp.next=null;
            return temp1.data;
        }
    }
    public boolean deleteGivenElement(int data){
        if(this.head == null)return false;
        else if(this.head.next == null){
            if(head.data == data){
                head = null;
                return true;
            }
            return false;
        }
        else if(this.head.data == data){
            this.head = this.head.next; return true;
        }
        else{
            Node temp = head;
            while((temp != null) && (temp.next != null)){
                if(temp.next.data == data){
                    temp.next = temp.next.next;
                    return true;
                }
                temp = temp.next;
            }
            return false;
        }
    }
    public void display(){
        Node temp = this.head;
        while(temp!=null){
            System.out.println(temp.data);temp = temp.next;
        }
    }

}
public class Linklist {
    public static void main(String args[]){
        Linklistclass l1 = new Linklistclass();
        l1.insertAtFirst(1);
        l1.insertAtFirst(2);
        l1.insertAtEnd(3);
        l1.insertAtEnd(4);
        l1.insertAtAfter(10, 3);
        l1.insertAtAfter(20, 2);
        l1.insertAtAfter(30, 4);
        l1.deleteAtFirst();
        l1.deleteAtEnd();
        l1.deleteGivenElement(10);
        l1.deleteGivenElement(20);
        l1.deleteGivenElement(4);
        l1.display();
    }
    
}
