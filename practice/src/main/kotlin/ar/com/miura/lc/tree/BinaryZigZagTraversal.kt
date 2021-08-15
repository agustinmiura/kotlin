package ar.com.miura.lc.tree

import java.util.*

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-medium/108/trees-and-graphs/787/
 */
class BinaryZigZagTraversal {
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {

        if (root==null) {
            return listOf<List<Int>>()
        }

        var numbers = mutableListOf<List<Int>>()

        var nodes:Queue<TreeNode> = LinkedList<TreeNode>()
        nodes.add(root)

        var level = 0

        while(!nodes.isEmpty()) {

            var levelList = mutableListOf<Int>()
            var sons = mutableListOf<TreeNode>()

            /*
            Fill current level
            */
            var iterator:Iterator<TreeNode> = nodes.iterator()
            for(node in iterator) {
                levelList.add(node.`val`)

                if (node.left!=null) {
                    sons.add(node.left!!)
                }
                if (node.right!=null) {
                    sons.add(node.right!!)
                }
            }

            if (level%2==1) {
                levelList = levelList.asReversed()
            }

            numbers.add(levelList)

            /*
            empty the current queue
            */
            while(!nodes.isEmpty()) {
                nodes.poll()
            }

            /*
            Add nodes to the queue
            */
            for(node in sons) {
                nodes.add(node)
            }

            level++
        }

        return numbers

    }
}