package ar.com.miura.lc.sorting

import java.util.*
import kotlin.Comparator

class MeetingRooms2 {
    fun minMeetingRooms(intervals: Array<IntArray>): Int {
        if (intervals.size==0) {
            return 0;
        }

        var meetings = mutableListOf<IntArray>()
        var size = intervals.size;
        for(i in 0..(size-1)) {
            meetings.add(intervals[i]);
        }

        var comparator = Comparator<IntArray>{i1,i2 -> i1[0] - i2[0]};
        meetings.sortWith(comparator);

        var arrayComparator = Comparator<IntArray>{i1,i2 -> i1[1]-i2[1]};
        var pq: PriorityQueue<IntArray> = PriorityQueue<IntArray>(arrayComparator);

        var meeting = meetings.get(0);
        meetings.removeAt(0);
        pq.add(intArrayOf(meeting[0], meeting[1]));

        for(eachMeeting in meetings) {
            var earlyArray = pq.peek();

            /*
            [1,5]  -> 5
            */
            var currentEnding = earlyArray[1];

            /*
            [8,9] -> 8
            */
            var currentStart = eachMeeting[0];

            if (currentEnding<=currentStart) {
                var polled = pq.poll();
                polled[1] = eachMeeting[1];
                pq.add(polled);

            } else {
                pq.add(eachMeeting)

            }
        }

        return pq.size;
    }
}