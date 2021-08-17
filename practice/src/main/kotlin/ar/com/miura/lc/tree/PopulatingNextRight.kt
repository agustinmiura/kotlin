package ar.com.miura.lc.tree

import java.util.*

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-medium/108/trees-and-graphs/789/
 */
class PopulatingNextRight {
    fun connect(root: Node?): Node? {
        if (root == null) {
            return null
        } else {
            root.next = null
            subConnect(root)
            return root
        }
    }

    private fun subConnect(root: Node) {

        var nodes: Queue<Node> = LinkedList<Node>()

        nodes.add(root)

        while (!nodes.isEmpty()) {

            var sons = mutableListOf<Node>()
            val iterator: Iterator<Node> = nodes.iterator()

            var before: Node? = null
            for (node in iterator) {

                val nodeLeft: Node? = node.left
                if (nodeLeft != null) {
                    sons.add(nodeLeft)
                }

                val nodeRight: Node? = node.right
                if (nodeRight != null) {
                    sons.add(nodeRight)
                }

                if (before != null) {
                    before.next = node
                }
                before = node

            }

            nodes.clear()

            for (node in sons) {
                nodes.add(node)
            }
        }
    }
}