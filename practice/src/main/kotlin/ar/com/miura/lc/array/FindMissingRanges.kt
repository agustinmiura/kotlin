package ar.com.miura.lc.array

class FindMissingRanges {
    fun findMissingRanges(nums: IntArray, lower: Int, upper: Int): List<String> {
        var strings = mutableListOf<String>();

        var previous = lower-1;
        var size = nums.size;
        var current = -1;
        for((i,v) in nums.withIndex()) {
            current = v;
            if ( (previous+1) <= (current-1) ) {
                var string = getRange(previous+1, current-1);
                strings.add(string)
            }
            previous = current;
        }
        /**
         * The last element we must process
         */
        previous = current;
        current = upper+1;
        if ( (previous+1) <= (current-1) ) {
            var string = getRange(previous+1, current-1);
            strings.add(string)
        }

        return strings;
    }

    /**
     *
     */
    private fun getRange(prev:Int, current:Int):String {
        if (prev==current) {
            return "${prev}";
        } else {
            return "${prev}=>${current}";
        }
    }
}