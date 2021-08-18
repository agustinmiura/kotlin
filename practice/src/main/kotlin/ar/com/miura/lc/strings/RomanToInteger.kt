package ar.com.miura.lc.strings

/**
 * https://leetcode.com/problems/roman-to-integer/submissions/
 */
class RomanToInteger {
    fun romanToInt(s: String): Int {

        var map = mutableMapOf<Char,Int>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        var acum:Int = 0;
        var i = 0;

        var size = s.length;
        while(i<size) {

            var movedTwo = false;
            if (i<=size-2) {
                var iValue = map.getOrDefault(s.get(i),0);
                var jValue = map.getOrDefault(s.get(i+1), 0);
                if (iValue<jValue) {
                    acum += (jValue-iValue);
                    i=i+2;
                    movedTwo = true;
                }

            }

            if (!movedTwo) {
                acum += map.getOrDefault(s.get(i),0);
                i++;
            }

        }
        return acum;
    }
}