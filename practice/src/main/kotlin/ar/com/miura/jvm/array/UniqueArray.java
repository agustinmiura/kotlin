package ar.com.miura.jvm.array;


/**
 * https://leetcode.com/problems/minimum-increment-to-make-array-unique/solution/
 */
public class UniqueArray {

    public int thirdApproach(int[] numbers) {
        java.util.Arrays.sort(numbers);
        int ans = 0, taken = 0;

        for (int i = 1; i < numbers.length; ++i) {
            if (numbers[i-1] == numbers[i]) {
                taken++;
                ans -= numbers[i];
            } else {
                int give = Math.min(taken, numbers[i] - numbers[i-1] - 1);
                ans += give * (give + 1) / 2 + give * numbers[i-1];
                taken -= give;
            }
        }

        if (numbers.length > 0)
            ans += taken * (taken + 1) / 2 + taken * numbers[numbers.length - 1];

        return ans;
    }

    public int secondApproach(int[] numbers) {
        int[] count = new int[100000];
        java.util.Set<Integer> withDuplicates = new java.util.TreeSet<>();

        for (int x: numbers) {
            count[x]++;
        }

        int swaps = 0;
        int duplicatedTimes = 0;
        for(int number=0;number<100000;number++) {
            if (count[number]>=2) {
                duplicatedTimes = duplicatedTimes + count[number]-1;
                /**
                 * Count before the duplicated items
                 */
                swaps = swaps - (number * (count[number]-1));
            } else if (count[number]==0 && withDuplicates.size()>=1) {
                duplicatedTimes--;
                swaps = swaps + number;
            }
        }
        return swaps;
    }


    public int minIncrementForUnique(int[] numbers) {
        java.util.Arrays.sort(numbers);
        int length = numbers.length;
        int result = 0;
        for (int i = 1; i < length; i++) {
            if (numbers[i] <= numbers[i-1]) {
                int increment = numbers[i-1]-numbers[i] +1;
                numbers[i] = numbers[i] + increment;
                result = result +  increment;
            }
        }

        return result;
    }

}