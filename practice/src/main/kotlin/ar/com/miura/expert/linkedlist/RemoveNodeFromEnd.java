package ar.com.miura.expert.linkedlist;

public class RemoveNodeFromEnd {

    public static void removeKthNodeFromEnd(LinkedList head, int k) {

        LinkedList sentinel = new LinkedList(-1);
        sentinel.next = head;

        LinkedList node = sentinel;
        int size = -1;
        while(node!=null) {
            node = node.next;
            size++;
        }

        node = sentinel;
        int count = -1;
        int toReach = size-k-1;

        if (toReach==-1) {
            LinkedList next = head.next;
            head.value = next.value;
            head.next = next.next;
            return;
        }

        while(count!=toReach && toReach>=0) {
            count++;
            node = node.next;
        }

        node.next = node.next.next;

    }

    static class LinkedList {

        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }

    }
}
