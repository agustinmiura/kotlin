package ar.com.miura.lc.intersectiontwolists

class Solution {
    fun getIntersectionNode(headA:ListNode?, headB:ListNode?):ListNode? {

        var newHeadA = ListNode(0)
        newHeadA.next = headA

        var newHeadB = ListNode(0)
        newHeadB.next = headB

        var setA = mutableSetOf<ListNode>()

        while( newHeadA.next != null ) {
            newHeadA = newHeadA.next!!
            setA.add(newHeadA)
        }

        while(newHeadB.next!=null) {
            newHeadB = newHeadB.next!!
            if (setA.contains(newHeadB)) {
                return newHeadB
            }

        }

        return null
    }
}
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}