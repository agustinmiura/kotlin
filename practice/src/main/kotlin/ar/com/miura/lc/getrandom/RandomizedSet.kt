package ar.com.miura.lc.getrandom

import java.util.*

class RandomizedSet() {

    /** Initialize your data structure here. */
    private var numbers = mutableListOf<Int>()

    private var map = mutableMapOf<Int,Int>()

    private var random = Random()


    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    fun insert(`val`: Int): Boolean {
        var value = `val`
        if (map.contains(value)) {
            return false
        } else {
            numbers.add(value)
            map.put(value, numbers.size-1)
            return true
        }

    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    fun remove(`val`: Int): Boolean {

        var value = `val`
        if (!map.contains(value)) {
            return false
        }

        var originalIndex = map.getOrDefault(value, -1)

        var lastElement = numbers.last()
        numbers.set(originalIndex,lastElement)
        map.put(lastElement, originalIndex)

        numbers.removeLast()
        map.remove(value)

        return true
    }

    /** Get a random element from the set. */
    fun getRandom(): Int {
        if (!numbers.isEmpty()) {
            var index = numbers.get(random.nextInt(numbers.size))
            index = index % numbers.size
            return numbers.get(index)

        } else {
            return -1

        }

    }

}
