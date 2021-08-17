package ar.com.miura.expert.graph

import java.util.*

import java.util.*;

class Node(name: String) {
    val name: String = name
    val children = mutableListOf<Node>()

    fun depthFirstSearch(): List<String> {
        return dfs()
    }

    private fun dfs(): List<String> {
        var nodes = mutableListOf<String>()

        var stack: Stack<Node> = Stack<Node>()
        stack.push(this)
        var visited: MutableSet<Node> = mutableSetOf<Node>()

        while (!stack.isEmpty()) {

            var node: Node = stack.pop()
            if (!visited.contains(node)) {
                visited.add(node)
                nodes.add(node.name)
                for (adjacent in node.children) {
                    stack.push(adjacent)
                }
            }

        }
        return nodes
    }
}