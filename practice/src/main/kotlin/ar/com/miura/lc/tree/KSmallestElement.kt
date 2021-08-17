package ar.com.miura.lc.tree

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-medium/108/trees-and-graphs/790/
 */
class KSmallestElement {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        var numbers = mutableListOf<Int>()
        inorder(root, numbers)
        return numbers.get(k - 1)
    }

    private fun inorder(node: TreeNode?, numbers: MutableList<Int>) {

        if (node == null) {
            return
        }

        if (node.left != null) {
            inorder(node.left, numbers)
        }

        numbers.add(node.`val`)

        if (node.right != null) {
            inorder(node.right, numbers)
        }

    }
}