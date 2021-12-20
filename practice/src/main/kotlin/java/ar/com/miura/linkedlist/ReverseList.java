package java.ar.com.miura.linkedlist;

public class ReverseList {
    public ListNode reverseList(ListNode head) {

        if (head==null) {
            return null;
        }

        /*
        Case one node
        */
        if (head!=null && head.next==null) {
            return head;
        }

        ListNode previous = head;
        ListNode current = head.next;
        previous.next = null;

        /**
         previous = [1]
         current = [2,3,4,5]
         **/
        while(current!=null) {
            //nextTemp = [3,4,5]
            ListNode nextTemp = current.next;
            //current = [2] , current = [2,1]
            current.next = previous;
            //previous = [2,1]
            previous = current;
            //current = [3,4,5]
            current = nextTemp;
        }

        return previous;

    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
