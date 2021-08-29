package ar.com.miura.lc.treeserialize

import org.junit.jupiter.api.Test

class CodecTestCase {

    @Test
    fun `should serialize deserialize the tree`() {

        var l1 = TreeNode(4)
        var r1 = TreeNode(5)

        var left = TreeNode(2)
        var right = TreeNode(3)

        right.left = l1
        right.right = r1

        var root = TreeNode(1)
        root.left = left
        root.right = right

        var encoded = Codec().serialize(root)

        println("Encoded : ${encoded}")

    }

}