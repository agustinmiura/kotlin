package ar.com.miura.lc.treeserialize

import java.util.*

/**
 * Your Codec object will be instantiated and called as such:
 * var ser = Codec()
 * var deser = Codec()
 * var data = ser.serialize(longUrl)
 * var ans = deser.deserialize(data)
*/
class Codec() {

    // Encodes a URL to a shortened URL.
    fun serialize(root: TreeNode?): String {
        var sBuilder = StringBuilder()
        subSerialize(root, sBuilder)
        //println("string : ${sBuilder.toString()} ")
        return sBuilder.toString()
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        var strings:List<String> = data.split(",")

        var queue:Queue<String> = LinkedList<String>()
        for(string in strings) {
            queue.offer(string)
        }

        return deserialize(queue)
    }

    private fun deserialize(queue:Queue<String>):TreeNode? {

        if (!queue.isEmpty()) {
            return null
        }

        var content:String = queue.poll()
        if (content=="null") {
            return null
        }

        var root = TreeNode(content.toInt())
        root.left = deserialize(queue)
        root.right = deserialize(queue)

        return root
    }


    private fun subSerialize(root: TreeNode?, sBuilder:StringBuilder) {

        if (root==null) {
            sBuilder.append("null,")

        } else {

            val value:String = root.`val`.toString()
            sBuilder.append(value + ",")
            sBuilder.append(subSerialize(root.left, sBuilder))
            sBuilder.append(subSerialize(root.right, sBuilder))

        }

    }

}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}