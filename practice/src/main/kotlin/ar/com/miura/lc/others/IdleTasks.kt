package ar.com.miura.lc.others

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-medium/114/others/826/
 */
class IdleTasks {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        var count: IntArray = IntArray(26)
        var maxFreq = 0
        for ((k, v) in tasks.withIndex()) {
            count[v - 'A']++
            maxFreq = Math.max(maxFreq, count[v - 'A'])
        }

        var sortedFrequencies = count.sortedArray()
        var totalIdleTime = (maxFreq - 1) * n
        var index = 24
        while (index >= 0) {
            totalIdleTime -= Math.min(maxFreq - 1, sortedFrequencies[index])
            index--
        }
        totalIdleTime = Math.max(0, totalIdleTime)
        return tasks.size + totalIdleTime
    }
}