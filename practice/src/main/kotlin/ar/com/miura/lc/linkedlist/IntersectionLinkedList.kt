package ar.com.miura.lc.linkedlist

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-medium/107/linked-list/785/
 */
class IntersectionLinkedList {

    fun oddEvenList(head: ListNode?): ListNode? {

        if (head==null) {
            return null
        } else if (head!=null && head.next==null) {
            return head
        }

        var headAnswer:ListNode = ListNode(0)

        /*
        odd: 1
        even: 2
        */
        var count = 1

        var headOdd:ListNode = ListNode(0)
        headOdd.next = ListNode(0)

        var headEven:ListNode = ListNode(0)
        headEven.next = ListNode(0)

        var oddNode:ListNode = headOdd
        var evenNode:ListNode = headEven



        var node:ListNode? = head
        var index = 0
        while(node!=null) {

            var number = node.`val`
            if (index%2==0) {
                evenNode.next = ListNode(0)
                evenNode = evenNode.next!!
                evenNode.`val` = number

            } else {
                oddNode.next = ListNode(0)
                oddNode = oddNode.next!!
                oddNode.`val` = number

            }

            index++
            node = node.next
        }

        evenNode.next = headOdd.next
        return headEven.next
    }
}