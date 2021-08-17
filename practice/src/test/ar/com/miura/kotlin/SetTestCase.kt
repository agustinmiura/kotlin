package ar.com.miura.kotlin

import org.junit.jupiter.api.Test
import java.util.*

class SetTestCase {

    @Test
    fun `should get elements in order`() {

        var sortedSet: SortedSet<Int> = TreeSet<Int>();
        var number = 10;
        for(i in 0..9) {
            number--;
            sortedSet.add(number);
        }

        for(e in sortedSet) {
            println(e);
        }

    }
}