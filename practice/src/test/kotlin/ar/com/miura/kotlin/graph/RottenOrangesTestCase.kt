package ar.com.miura.kotlin.graph

import ar.com.miura.lc.graph.RottenOranges
import org.junit.jupiter.api.Test

class RottenOrangesTestCase {

    @Test
    fun `should find oranges`(){

        var input = Array<IntArray>(3, { intArrayOf(0,0,0) });

        input[0][0] = 2;
        input[0][1] = 1;
        input[0][2] = 1;

        input[1][0] = 1;
        input[1][1] = 1;

        input[2][1] = 1;
        input[2][2] = 1;

        var times = RottenOranges().orangesRotting(input);
        println("Times is : ${times} ");
        val stop = "10";

    }

}