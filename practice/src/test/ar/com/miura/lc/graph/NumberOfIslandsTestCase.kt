package ar.com.miura.lc.graph

import kotlin.test.Test
import kotlin.test.assertEquals

class NumberOfIslandsTestCase {

    /**
    grid = [
    ["1","1","1","1","0"],
    ["1","1","0","1","0"],
    ["1","1","0","0","0"],
    ["0","0","0","0","0"]
    ]
    Array<CharArray>
     */
    @Test
    fun `should find the number of islands`() {

        val grid = Array<CharArray>(4, { CharArray(4,{'0'}) })
        grid[0] = charArrayOf('1','1','1','1','1');
        grid[1] = charArrayOf('1','1','0','1','0');
        grid[2] = charArrayOf('1','1','0','0','0');
        grid[3] = charArrayOf('0','0','0','0','0');

        val qty = NumberOfIslands().numIslands(grid);
        assertEquals(1, qty)

    }

}