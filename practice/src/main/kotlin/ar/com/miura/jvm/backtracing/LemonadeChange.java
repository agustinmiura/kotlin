package ar.com.miura.jvm.backtracing;


/**
 * https://leetcode.com/problems/lemonade-change/
 */
public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for(int eachBill:bills) {
            if (eachBill==5) {
                five++;
            } else if (eachBill==10) {
                if (five==0) {
                    return false;
                } else {
                    ten--;
                }
            } else {
                if (five>0&&ten>0) {
                    five--;
                    ten--;
                } else if (five>=3) {
                    five=five-3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
