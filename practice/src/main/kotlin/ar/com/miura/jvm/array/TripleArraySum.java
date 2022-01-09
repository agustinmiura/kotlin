package ar.com.miura.jvm.array;


public class TripleArraySum {
    public int threeSumMulti(int[] arr, int target) {

        java.util.Map<Integer, Long> freqMap = new java.util.TreeMap<>();

        for(Integer eachInteger:arr) {
            Long freq = freqMap.getOrDefault(eachInteger, 0L);
            freq++;
            freqMap.put(eachInteger, freq);
        }
        long qty = 0;
        for(Integer el1:freqMap.keySet()) {
            for(Integer el2: freqMap.keySet()) {
                int el3 = target - el1 - el2;
                if (freqMap.containsKey(el3)) {
                    long freq1 = freqMap.get(el1);
                    long freq2 = freqMap.get(el2);
                    long freq3 = freqMap.get(el3);

                    if (el1 == el2 && el2 == el3) {
                        qty += freq1 * (freq1-1) * (freq1 -2)/6;

                    } else if (el1 == el2 && el1 != el3) {

                        qty = (freq3) * getFactorial(freq1+freq2)/( (getFactorial(freq1)) * (getFactorial(freq2)));
                        //qty += freq1 * (freq1-1)/2  * freq3;

                    } else if (el1<el2 && el2<el3) {
                        qty += (freq1*freq2*freq3);
                    }
                }
            }
        }
        qty = qty % 1000000007;
        return (int)(qty);
    }

    private long getFactorial(long n) {
        long factorial = 1;
        for(int i=1;i<=n;i++) {
            factorial *= i;
        }
        return factorial;
    }

}
