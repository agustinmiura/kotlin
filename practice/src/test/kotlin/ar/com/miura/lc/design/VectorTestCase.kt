package ar.com.miura.lc.design

import org.junit.jupiter.api.Test

class VectorTestCase {

    @Test
    fun `should test vector`() {

        var input = Array<IntArray>(4, { intArrayOf()})
        input[0] = intArrayOf(1,2);
        input[1] = intArrayOf(3);
        input[2] = intArrayOf(4)

        var vector2D = Vector2D(input);

        var element0 = vector2D.next();
        var element1 = vector2D.next();
        var element2 = vector2D.next();
        var element3 = vector2D.next();

        var stop = "stop";

    }
}