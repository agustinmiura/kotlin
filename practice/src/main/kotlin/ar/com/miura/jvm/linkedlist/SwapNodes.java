package ar.com.miura.jvm.linkedlist;

public class SwapNodes {
    public ListNode swapNodes(ListNode head, int k) {

        if (head==null) {
            return null;
        }

        ListNode node = head;

        java.util.List<Integer> numbersArrayList = new java.util.ArrayList<>();
        while(node != null) {
            numbersArrayList.add(node.val);
            node = node.next;
        }

        Integer[] numbers = numbersArrayList.toArray(new Integer[numbersArrayList.size()]);

        int firstIndex = k-1;
        int lastIndex = numbersArrayList.size() - k;

        int lastValue = numbers[lastIndex];
        numbers[lastIndex] = numbers[firstIndex];
        numbers[firstIndex] = lastValue;

        ListNode newHead = new ListNode(numbers[0]);
        ListNode listNode = newHead;
        for(int i=1;i<numbers.length;i++) {

            ListNode nextNode = new ListNode(numbers[i]);
            listNode.next = nextNode;
            listNode = nextNode;

        }

        return newHead;

    }
}