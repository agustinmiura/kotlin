package ar.com.miura.lc.linkedlist

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-medium/107/linked-list/783/
 */
class AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {

        var headAnswer = ListNode(0)
        headAnswer.next = ListNode(0)

        var node1:ListNode? = if (l1!=null) { l1 } else { ListNode(0) }
        var node2:ListNode? = if (l2!=null) { l2 } else { ListNode(0) }

        var carry = 0
        var nodeAnswer = headAnswer.next
        var result = 0

        while ( node1!=null || node2!=null) {
            val first = if (node1!=null) { node1.`val` } else { 0 }
            val second = if (node2!=null) { node2.`val` } else { 0 }

            result = first + second + carry

            if (result>=10) {
                carry = 1
                nodeAnswer!!.`val` = result - 10

            } else {
                carry = 0
                nodeAnswer!!.`val` = result

            }

            if (node1!=null) { node1=node1.next }
            if (node2!=null) { node2=node2.next }

            if (node1!=null || node2!=null) {
                nodeAnswer!!.next = ListNode(0)
                nodeAnswer = nodeAnswer.next
            }

        }

        if (carry>=1) {
            nodeAnswer!!.next = ListNode(1)
        }
        return headAnswer.next
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}