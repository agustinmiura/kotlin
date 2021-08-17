package ar.com.miura.lc.union

import ar.com.miura.structures.UnionFind

/**
 * https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3845/
 * Disjoint sets
 */
class NumberProvinces {
    fun findCircleNum(isConnected: Array<IntArray>): Int {
        var size = isConnected.size
        var unionFind = UnionFind(size)
        for (i in 0..size - 1) {
            for (j in 0..size - 1) {
                /*
                * perform union find here
                * */
                if (isConnected[i][j] == 1) {
                    unionFind.union(i, j)
                }
            }
        }
        return unionFind.getCount()
    }
}
