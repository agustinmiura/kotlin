package ar.com.miura.lc.tree.buildtree

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        return helper(0, 0, inorder.size-1, preorder, inorder)
    }

    private fun helper(
        preStart:Int,
        inStart:Int,
        inEnd:Int,
        preorder:IntArray,
        inorder:IntArray):TreeNode? {

        if (preStart > preorder.size-1 || inStart > inEnd) {
            return null
        }

        var root = TreeNode(preorder[preStart])

        var rootValue = root.`val`

        var inIndex = 0
        for(i in inStart..inEnd) {
            if (rootValue == inorder[i]) {
                inIndex = i
                break
            }
        }

        root.left = helper(
            preStart + 1,
            inStart,
            inIndex - 1,
            preorder,
            inorder
        )

        root.right = helper(
            preStart + inIndex - inStart + 1,
            inIndex + 1,
            inEnd,
            preorder,
            inorder
        )

        return root
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}