package ar.com.miura.jvm.dp;

public class NumberOfTeams {
    public int numTeams(int[] rating) {
        if (rating == null || rating.length==0) {
            return 0;
        }

        /*
        Find sequences rating[i]>rating[j]>rating[k]
        dp[i] = number of elements greater than
        */
        int count = 0;
        int size = rating.length;
        int[] dp = new int[size];

        for(int i=0;i<size;i++) {
            for(int j=i;j>=0;j--) {

                /**
                 Update the number of elements greater than the left
                 **/
                if (rating[i]>rating[j]) {
                    dp[i]++;
                    /*
                        rating[j]<rating[i] is valid
                        and also dp[j]: Amount of elements less than the rating[j]
                    */
                    count = (count + dp[j]);
                }
            }
        }

        /*
        Find sequences rating[i]<rating[j]<rating[k]
        dp[i] = number of elements less than to the left
        */
        dp = new int[rating.length];
        for(int i=0;i<size;i++) {
            for(int j=i;j>=0;j--) {
                if (rating[i]<rating[j]) {
                    dp[i]++;
                    count = (count + dp[j]);
                }
            }
        }

        return count;
    }
}
