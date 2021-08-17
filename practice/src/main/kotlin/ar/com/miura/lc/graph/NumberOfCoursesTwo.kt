package ar.com.miura.lc.graph

import java.util.*;

/**
 * https://leetcode.com/explore/learn/card/graph/623/kahns-algorithm-for-topological-sorting/3868/
 */
class NumberOfCoursesTwo {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {

        var graph = mutableMapOf<Int, MutableList<Int>>();
        var inGrades = mutableMapOf<Int,Int>();

        for(i in 0..(numCourses-1)) {
            inGrades.put(i,0);
        }

        /*
        build graph and grade
        */
        for(pre in prerequisites) {

            var destination = pre[0];
            var origin = pre[1];

            var adjacents = graph.getOrDefault(origin, mutableListOf<Int>());
            adjacents.add(destination);
            graph.put(origin, adjacents);

            var grade = inGrades.getOrDefault(destination, 0);
            grade++;
            inGrades.put(destination, grade);

        }

        /*
        find source for the graph
        */
        var queue:Queue<Int> = LinkedList<Int>();
        for((k,v) in inGrades) {
            if (v==0) {
                queue.offer(k);
            }
        }

        var orderedTasks = mutableListOf<Int>();

        while(!queue.isEmpty()) {
            var task = queue.poll();
            orderedTasks.add(task);

            var nextTasks = graph.getOrDefault(task, mutableListOf<Int>());

            for(eachTask in nextTasks) {
                var qty = inGrades.getOrDefault(eachTask,0);
                qty--;
                inGrades.put(eachTask, qty);
                if (qty==0) {
                    queue.offer(eachTask);
                }
            }

        }

        if (orderedTasks.size==numCourses) {
            return orderedTasks.toIntArray();
        } else {
            return intArrayOf(0);
        }

    }
}