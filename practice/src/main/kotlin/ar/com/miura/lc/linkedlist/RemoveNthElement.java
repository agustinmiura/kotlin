package ar.com.miura.lc.linkedlist;

public class RemoveNthElement {
    public SimpleListNode removeNthFromEnd(SimpleListNode head, int n) {
        int size = 0;


        SimpleListNode dummy = new SimpleListNode(0);
        dummy.next = head;

        SimpleListNode sentinel = head;
        while(sentinel!=null) {
            sentinel = sentinel.next;
            size++;
        }

        /*
        size 1 case
        */
        if (size==1 && n>=1) {
            return null;
        }

        int index = size-n;
        sentinel = dummy;
        while(index>=1) {
            index--;
            sentinel = sentinel.next;
        }

        sentinel.next = sentinel.next.next;

        return dummy.next;
    }
}
