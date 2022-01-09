package ar.com.miura.jvm.linkedlist;

/**
 * https://leetcode.com/explore/featured/card/april-leetcoding-challenge-2021/593/week-1-april-1st-april-7th/3693/
 */
public class PalindromeList {

    public boolean isPalindrome(ListNode head) {
        int size = 100000/2;
        java.util.List<Integer> intList = new java.util.ArrayList<>(size);
        ListNode node = head;
        intList.add(node.val);
        int i = 0;
        int j = 0;
        while(node.next!=null) {
            node = node.next;
            Integer number = node.val;
            intList.add(number);
            j++;
        }
        while(i<=j) {
            if (intList.get(i)!=intList.get(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
}