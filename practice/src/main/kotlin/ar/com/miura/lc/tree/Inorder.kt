package ar.com.miura.lc.tree

import java.util.*

class Inorder {
    fun inorderTraversal(root: TreeNode?): List<Int> {

        if (root == null) {
            return listOf<Int>()
        }

        var ints = mutableListOf<Int>()
        walkTree(root, ints)
        return ints
    }

    private fun walkTree(node: TreeNode?, ints: MutableList<Int>) {

        var nodes: Stack<TreeNode> = Stack<TreeNode>()

        var current: TreeNode? = node

        while (current != null || !nodes.isEmpty()) {

            while (current != null) {
                nodes.push(current)
                current = current.left
            }

            current = nodes.pop()
            ints.add(current.`val`)
            current = current.right
        }
    }
}