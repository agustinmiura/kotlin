package ar.com.miura.lc.strings

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/887/
 */
class LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.size==0) {
            return "";
        } else if (strs.size==1) {
            return strs[0];
        }
        var commonPrefix = getCommonPrefix(strs[0], strs[1]);
        if (commonPrefix.equals("")) {
            return "";
        }
        for(i in 1..(strs.size-1)) {
            commonPrefix = getCommonPrefix(commonPrefix, strs[i]);
        }
        return commonPrefix;
    }
    private fun getCommonPrefix(input0:String, input1:String):String {
        var stringBuilder = StringBuilder();
        var minSize = Math.min(input0.length, input1.length);
        for(k in 0..(minSize-1)) {
            if (input0.get(k)==input1.get(k)) {
                stringBuilder.append(input0.get(k));
            } else {
                break;
            }
        }
        return stringBuilder.toString();
    }
}