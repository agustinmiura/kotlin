package ar.com.miura.lc.graph

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class NumberOfCoursesTestCase {

    @Test
    fun `should find the order`() {
        /*
        * numCourses: Int, prerequisites: Array<IntArray>
        * */
        var numCourses = 2;
        var req = Array<IntArray>(1, { intArrayOf()});
        req[0] = intArrayOf(1,0);

        var order = NumberOfCoursesTwo().findOrder(2, req);
        assertEquals(2, order.size);
        assertEquals(0, order[0]);
        assertEquals(1, order[1]);
    }

}