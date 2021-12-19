package ar.com.miura.lc.tree

import java.util.LinkedList
import java.util.Queue

class LargestValueTreeRow {
    fun largestValues(root: TreeNode?): List<Int> {
        if (root==null) {
            return listOf<Int>();
        }

        var largeElements = mutableListOf<Int>();

        var queue: Queue<TreeNode> = LinkedList<TreeNode>();
        queue.add(root!!);

        while(!queue.isEmpty()) {
            val qty = queue.size;
            var max = Int.MIN_VALUE;
            for(i in 0..(qty-1)) {
                var node = queue.poll();
                var value = node.`val`;
                if (value>max) {
                    max = value;
                }
                if (node.left != null) {
                    queue.add(node.left!!);
                }
                if (node.right!=null) {
                    queue.add(node.right!!);
                }

            }
            largeElements.add(max);
        }
        return largeElements;

    }
}