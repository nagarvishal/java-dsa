package LinkList;



class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null)return head;
        int length = 0;
        ListNode temp = head;
        while(temp!=null){
            length = length + 1;
            temp = temp.next;
        }
        k = k%length;
        if(k==0)return head;
        else{
            int count = 1;
            ListNode temp1 = head;
            ListNode temp2 = null;
            ListNode temp3 = null;
            ListNode temp4 = null;

            temp = head;
            while(count!=(length-k) && temp!=null){
                temp = temp.next;
                count = count + 1;
            }
            temp2 = temp;
            temp3 = temp.next;
            temp4 = temp.next;
            while(temp4.next!=null)temp4 = temp4.next;

            temp2.next = null;
            temp4.next = temp1;
            head = temp3;
            return head;
        }
    }
}

public class  RotateList {
    public static void main(String args[])
    {
        ListNode head = new ListNode(1,null);
        head.next = new ListNode(2,null);
        head.next.next = new ListNode(3,null);
        head.next.next.next = new ListNode(4,null);
        head.next.next.next.next = new ListNode(5,null);
        head.next.next.next.next.next = new ListNode(6,null);

        Solution s1 = new Solution();
        ListNode temp = s1.rotateRight(head, 1);

        System.out.print("\n");
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp =temp.next;
        }
        return;
    }
}
