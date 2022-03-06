package ar.com.miura.lc.linkedlist;

public class DetectCycle {
    public boolean hasCycle(ListNode head) {
        java.util.Set<ListNode> nodes = new java.util.HashSet();
        ListNode sentinel = new ListNode();
        sentinel.next = head;
        ListNode pointer = sentinel;
        while(pointer!=null) {
            pointer = pointer.next;
            if (nodes.contains(pointer)) {
                return true;
            } else {
                nodes.add(pointer);
            }
        }
        return false;
    }
}
