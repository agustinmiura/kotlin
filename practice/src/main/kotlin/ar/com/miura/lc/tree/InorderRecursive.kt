package ar.com.miura.lc.tree

class InorderRecursive {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        var ints = mutableListOf<Int>()
        walkTree(root, ints)
        return ints
    }

    private fun walkTree(node: TreeNode?, ints: MutableList<Int>) {

        if (node==null) {
            return
        }

        if (node.left!=null) {
            walkTree(node.left, ints)
        }

        ints.add(node.`val`)

        if (node.right!=null) {
            walkTree(node.right, ints)
        }

    }
}