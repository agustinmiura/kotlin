package ar.com.miura.lc.strings

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/884/
 */
class Atoi {
    fun myAtoi(s: String): Int {

        var sFiltered = s.trim();
        if (sFiltered.length==0) {
            return 0;
        }

        var index = 0;
        var sign = 1;
        var total:Double = 0.0;

        if (sFiltered.get(index)=='+' || sFiltered.get(index)=='-') {
            sign = if (sFiltered.get(index)=='+') { 1 } else { -1 };
            index++;
        }

        var lowerLimit:Double = Math.pow(2.0,31.0);
        var upperLimit:Double = Math.pow(2.0,31.0)-1;

        while(index<sFiltered.length) {

            var character = sFiltered.get(index);

            if (character==' ') {
                index++;
            }

            var digit:Int = character - '0';
            var validDigit = (digit>=0) && (digit<10);
            if (!validDigit) {
                break;
            }

            total = total * 10.0 + digit;

            if (sign==-1 && total>lowerLimit) {
                total = lowerLimit;

            } else if (sign==1 && total>upperLimit) {
                total = upperLimit;

            }

            index++;
        }

        return (total * sign).toInt();


    }
}