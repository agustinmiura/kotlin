package ar.com.miura.lc.sorting

import java.util.*;

class MeetingsRoom {
    fun minMeetingRooms(intervals: Array<IntArray>): Int {
        if (intervals.size==0) {
            return 0;
        }

        var meetings = mutableListOf<IntArray>()
        var size = intervals.size;
        for(i in 0..(size-1)) {
            meetings.add(intervals[i]);
        }
        /*
        val pq = PriorityQueue<Int>(nums.size, { e1: Int, e2: Int -> e1 - e2 })
        */
        meetings.sortWith { x: IntArray, y: IntArray -> x[0] - y[0] };

        var comparator = Comparator<Int>{i1,i2 -> i1-i2};
        var pq:PriorityQueue<Int> = PriorityQueue<Int>(comparator);

        var meeting = meetings.get(0);
        meetings.removeAt(0);
        pq.add(meeting[1]);

        for(eachMeeting in meetings) {
            var lastTime = pq.poll();
            var endingTime = eachMeeting[1];
            if (endingTime>=lastTime) {
                pq.add(endingTime);
            } else {
                pq.add(endingTime);
                pq.add(lastTime);
            }
        }

        return pq.size;
    }
}