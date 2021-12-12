package ar.com.miura.lc.tree

import java.util.LinkedList
import java.util.Queue

class PopulatingNextElement {
    fun connect(root: Node?): Node? {
        if (root==null) {
            return null;
        }
        val queue: Queue<Node> = LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()) {

            val size = queue.size;

            for(i in 0..(size-1)) {
                val node = queue.poll();
                if (i < size - 1) {
                    node.next = queue.peek();
                }

                if (node.left!=null) {
                    queue.add(node.left);
                }

                if (node.right!=null) {
                    queue.add(node.right);
                }

            }
        }
        return root;
    }
}