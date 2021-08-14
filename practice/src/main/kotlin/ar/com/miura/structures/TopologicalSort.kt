package ar.com.miura.structures

import java.util.*

class TopologicalSort {

    fun topologicalSort(jobs: List<Int>, deps: List<List<Int>>): List<Int> {

        var orderMap = mutableMapOf<Int,Int>()
        var graph = mutableMapOf<Int, MutableList<Int>>()

        /*
        Create the graph
        Fill the grades of the nodes
        */
        for(eachDep in deps) {
            var origin = eachDep.get(0)
            var destination = eachDep.get(1)

            var adjacentList = graph.getOrDefault(origin, mutableListOf<Int>())
            adjacentList.add(destination)
            graph.put(origin, adjacentList)

            var qty = orderMap.getOrDefault(destination, 0)
            qty++
            orderMap.put(destination, qty)
        }

        var queue:Queue<Int> = LinkedList<Int>()
        for(vertex in jobs) {
            var qty = orderMap.getOrDefault(vertex, 0)
            if (qty==0) {
                queue.offer(vertex)
            }
        }

        /*
        */
        var orderedTasks = mutableListOf<Int>()
        var visitedQty = 0
        while(!queue.isEmpty()) {

            /*
            get a node increase qty ,
            and start filling the solution
            */
            var currentNode = queue.poll()
            visitedQty++
            orderedTasks.add(currentNode)

            var adjList = graph.getOrDefault(currentNode, mutableListOf<Int>())
            for(eachNear in adjList) {
                var grade = orderMap.getOrDefault(eachNear, 0)
                grade--
                orderMap.put(eachNear, grade)
                if (grade==0) {
                    queue.add(eachNear)
                }
            }
        }

        /**
         * With cycles we return an empty list
         */
        if (orderedTasks.size==jobs.size) {
            return orderedTasks
        } else {
            return listOf()
        }
    }

}