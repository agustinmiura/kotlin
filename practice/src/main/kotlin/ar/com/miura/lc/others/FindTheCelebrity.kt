package ar.com.miura.lc.others

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/114/others/825/
 */
class FindTheCelebrity {
    fun findCelebrity(n: Int) : Int {
        var qty = n;
        var candidates = mutableSetOf<Int>();
        /*
        first find all the candidates for the celebrity
        */

        for(i in 0..(qty-1)) {
            var check = isCandidate(i,n);
            if (check) {
                candidates.add(i);
            }
        }

        for(eachCandidate in candidates) {
            if (isCelebrity(eachCandidate, n)) {
                return eachCandidate;
            }

        }
        return -1;
    }

    private fun isCandidate(candidate:Int, n:Int):Boolean {
        for(i in 0..(n-1)) {
            if (i!=candidate) {
                if (knows(candidate,i)) {
                    return false;
                }
            }
        }
        return true;
    }

    /*
    check if everyone knows the candidate
    */
    private fun isCelebrity(candidate:Int, n:Int):Boolean {

        for(i in 0..(n-1)) {
            if (i!=candidate && !knows(i,candidate)) {
                return false;
            }
        }

        return true;
    }

    private fun knows(i: Int, candidate: Int):Boolean {
        return true;
    }

    /* The knows API is defined in the parent class Relation.
      fun knows(a: Int, b: Int) : Boolean {} */

}