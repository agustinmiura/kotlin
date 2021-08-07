package ar.com.miura.lc.tree.buildtree

import org.junit.jupiter.api.Test

/**
    [3,9,20,15,7]
    [9,3,15,20,7]
 */
class BuildTreeTestCase {

    @Test
    fun `should build a tree`() {

        val preorder = intArrayOf(3,9,20,15,7)
        val inorder = intArrayOf(9,3,15,20,7)

        val tree = Solution().buildTree(preorder, inorder)

        val stopPoint = "stopPoint"

    }
}