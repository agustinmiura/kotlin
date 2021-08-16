package ar.com.miura.structures

class UnionFind(val size: Int) {
    val root: IntArray = IntArray(size, { i -> i })

    public fun find(x: Int): Int {
        var toFind = x
        while (toFind != root[toFind]) {
            toFind = root[toFind]
        }
        return toFind
    }

    public fun union(x: Int, y: Int) {
        var rootX = find(x)
        var rootY = find(y)
        if (rootX != rootY) {
            root[rootY] = rootX
        }
    }

    fun isConnected(x: Int, y: Int): Boolean {
        return find(x) == find(y)
    }

    fun getCount(): Int {
        return root.withIndex().filter { (i, value) -> i == value }.count()
    }
}