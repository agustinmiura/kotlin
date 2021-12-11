package ar.com.miura.lc.linkedlist;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {

        java.util.Stack<Integer> stack = new java.util.Stack<Integer>();

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode node = head;
        while(node!=null) {
            stack.push(node.val);
            node = node.next;
        }

        ListNode newDummy = new ListNode(0);
        ListNode newNode = newDummy;
        while(!stack.isEmpty()) {
            Integer val = stack.pop();
            newNode.next = new ListNode(val);
            newNode = newNode.next;
        }
        return newDummy.next;
    }
}
