package ar.com.miura.jvm.math;

public class ArmstrongNumber {
    public boolean isArmstrong(int n) {
        java.util.List<Integer> digits = new java.util.ArrayList();
        int div = n;
        int remainder = n;
        while(div>10) {
            remainder = div % 10;
            div = div/10;
            digits.add(remainder);
        }
        digits.add(div);
        int digitQty = digits.size();
        int sum = 0;
        for(int i=0;i<digits.size(); i++) {
            int digit = digits.get(i);
            sum += (int)Math.pow(digit, digitQty*1.0);
        }
        return sum==n;
    }
}
