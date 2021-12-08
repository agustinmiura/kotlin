package ar.com.miura.lc.linkedlist

class MiddleElement {

  fun bestSolution(head: ListNode?): ListNode? {
    var slow:ListNode? = head;
    var fast:ListNode? = head;

    while(fast!=null && fast.next!=null) {
      slow = slow!!.next;
      fast = fast!!.next!!.next;
    }

    return slow!!;
  }

  fun middleNode(head: ListNode?): ListNode? {
    var size = 0
    var tempHead: ListNode? = head
    while (tempHead != null) {
      size++
      tempHead = tempHead.next
    }
    if (size == 1) {
      return head
    }
    var middle = size / 2
    if (middle == 0) {
      return tempHead
    } else {
      var current = 0
      tempHead = head
      while (current < middle) {
        tempHead = tempHead!!.next
        current++
      }
      return tempHead
    }
  }
}
