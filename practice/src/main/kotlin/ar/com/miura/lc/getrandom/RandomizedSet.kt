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
        numbers.add(`val`)
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    fun remove(`val`: Int): Boolean {

        var value = `val`
        if (!map.contains(value)) {
            return false
        }

        var toDelete = value
        var originalIndex = map.getOrDefault(value, -1)

        var lastElement = numbers.last()

        numbers.add(lastElement,originalIndex)
        map.put(lastElement, originalIndex)

        println(" Numbers size : ${numbers.size} ")

        numbers.removeAt(numbers.size-1)
        map.remove(lastElement)

        return true
    }

    /** Get a random element from the set. */
    fun getRandom(): Int {
        if (!numbers.isEmpty()) {
            var index = numbers.get(random.nextInt(numbers.size))
            return numbers.get(index)

        } else {
            return -1

        }

    }

}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * var obj = RandomizedSet()
 * var param_1 = obj.insert(`val`)
 * var param_2 = obj.remove(`val`)
 * var param_3 = obj.getRandom()
 */