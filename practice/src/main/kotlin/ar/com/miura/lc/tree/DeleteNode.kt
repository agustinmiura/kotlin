package ar.com.miura.lc.tree

import ar.com.miura.lc.linkedlist.ListNode

/**
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 */
class DeleteNode {
    fun deleteNode(node: ListNode?) {
        if (node!=null) {
            node.`val` = node.next.`val`;
            node.next = node.next.next;
        }
    }
}