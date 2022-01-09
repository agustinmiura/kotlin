package ar.com.miura.jvm.dp;

public class OneZero {

    public int findMaxForm(String[] strs, int m, int n) {

        int index=0;
        int size = strs.length;
        int[][] stringFrequency = new int[size][2];

        for(String string:strs) {
            stringFrequency[index] = getFreqTable(string);
            index++;
        }

        int[][] dp = new int[m+1][n+1];

        for(int i=0;i<size;i++) {
            int zeroQty = stringFrequency[i][0];
            int oneQty = stringFrequency[i][1];

            for(int k=m;k>=zeroQty;k--) {
                for(int j = n; j>=oneQty; j--) {
                    dp[k][j] = Math.max(dp[k][j], dp[k-zeroQty][j-oneQty] + 1);
                }
            }
        }

        return dp[m][n];

    }

    private int[] getFreqTable(String string) {
        int[] freq= new int[2];

        for(char eachChar:string.toCharArray()) {
            if (eachChar=='0') {
                freq[0]++;

            } else {
                freq[1]++;

            }
        }

        return freq;
    }
}
