package ar.com.miura.jvm.number;

/**
 * https://leetcode.com/contest/biweekly-contest-47/problems/check-if-number-is-a-sum-of-powers-of-three/
 * 1780
 */
public class PowerOfThree {
    public boolean checkPowersOfThree(int n) {
        int number = n;
        int remainder = -1;
        while(number>0) {
            remainder = number % 3;
            if (remainder == 2) {
                return false;
            } else {
                number = number/3;
            }
        }
        return true;
    }
}