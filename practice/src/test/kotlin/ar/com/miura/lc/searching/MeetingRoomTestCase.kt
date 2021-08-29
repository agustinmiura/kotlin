package ar.com.miura.lc.searching

import ar.com.miura.lc.sorting.MeetingsRoom
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MeetingRoomTestCase {

    @Test
    fun `should get meetings rooms`() {
        var meetings = Array<IntArray>(3, { intArrayOf(0,0)})
        meetings[0] = intArrayOf(0,30);
        meetings[1] = intArrayOf(5,10);
        meetings[2] = intArrayOf(15,20);
        var roomQty = MeetingsRoom().minMeetingRooms(meetings);
        assertEquals(2, roomQty)
    }

}