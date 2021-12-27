package ar.com.miura.jvm.array;

public class BestTimeToBuyAndSell {
    public int maxProfit(int[] prices) {

        int maxProfit = Integer.MIN_VALUE;
        int size = prices.length;
        int minNumber = prices[0];
        for(int i=1;i<size;i++) {

            int beforePrice = prices[i-1];
            minNumber = Math.min(beforePrice, minNumber);

            int currentProfit = prices[i]-minNumber;
            if (currentProfit>maxProfit) {
                maxProfit = currentProfit;
            }

        }

        return (maxProfit>=0) ? (maxProfit) : (0);
    }
}
